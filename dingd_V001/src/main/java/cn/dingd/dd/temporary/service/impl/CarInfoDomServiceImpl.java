package cn.dingd.dd.temporary.service.impl;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.dingd.dd.common.util.Constant;
import cn.dingd.dd.common.util.FileUtils;
import cn.dingd.dd.common.util.StringUtils;
import cn.dingd.dd.common.web.PageObject;
import cn.dingd.dd.temporary.dao.CarInfoDomDao;
import cn.dingd.dd.temporary.dao.CarPictureDomDao;
import cn.dingd.dd.temporary.entity.CarInfoDom;
import cn.dingd.dd.temporary.entity.CarPictureDom;
import cn.dingd.dd.temporary.service.CarInfoDomService;
/**
 * 临时版车辆信息service
 * @author XCD
 *
 */
@Service
public class CarInfoDomServiceImpl implements CarInfoDomService {
	
	
	@Resource
	private CarInfoDomDao carInfoDomDao; 
	@Resource
	private CarPictureDomDao carPictureDomDao; 
	/**
	 * 添加车辆信息
	 */
	@SuppressWarnings("unused")
	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean addCarInfoDom(CarInfoDom carInfoDom,MultipartFile[] files) {
           
         try {
        	System.err.println(carInfoDomDao.addCarInfo(carInfoDom)+"============");
        	// MultipartFile fil=files[5];
     		/** 
     		 * 一次上传多张图片 
     		 */  
        	    List<CarPictureDom> ls=new ArrayList<>();
     		    List<String> list = new ArrayList<String>();  

    		    // 上传位置  
     		    String path=Constant.UP_PATH;
     		    File f = new File(path);  
     		    if (!f.exists())  
     		        f.mkdirs();  
     		    CarPictureDom carPictureDom=null;
     		    for (int i = 0; i < files.length; i++) {  
     		        // 获得原始文件名  
     		        String fileName = files[i].getOriginalFilename();  
     		        
     		        System.out.println("原始文件名:" + fileName);
     		        String name=null;
     		       
     		        name=fileName.substring(0,fileName.indexOf("."));
     		        if(!StringUtils.isNotNullStr(name)){
     		        	  throw new Exception("文件名不能为空!");  
     		        }
     		        carPictureDom=new CarPictureDom();
     		        carPictureDom.setShowSort(i+1);
     		        carPictureDom.setPicture(fileName);
     		        if(i==0){
     		        carPictureDom.setCover(1);
     		        }
     		        // 新文件名  
     		        String newFileName = UUID.randomUUID().toString();  
     		        if (!files[i].isEmpty()) {  
     		            try {  
     		            		          
     						File file = FileUtils.byte2File(files[i].getBytes(), path, newFileName);
     		               
     		            } catch (Exception e) {  
     		                e.printStackTrace();  
     		            }  
     		        }  
     		        carPictureDom.setUrl(Constant.PICTUREADR+newFileName);
     		        carPictureDom.setCarId(carInfoDom.getId());
     		        ls.add(carPictureDom);
     		        System.out.println("上传图片到:" + path + newFileName);  
     		        list.add(path + newFileName);  
     		    }  
			
			carPictureDomDao.addCarPicture(ls);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	/**
	 * 删除车辆信息
	 */
	@Override
	public boolean deleteCarInfo(int id) {

          try {
			carInfoDomDao.deleteCarInfo(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	
	/**
	 * 获取车辆信息列表
	 */
	@Override
	public List<Map> queryCarInfoList(PageObject pageObject) {
		List<Map> map=null;
        try {
        	pageObject.setRowCount(carInfoDomDao.queryCarInfoPage());
        	map=carInfoDomDao.queryCarList(pageObject);
        	return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	/**
	 * 根据参数获取车辆信息
	 */
	@Override
	public List<Map> queryCarInfoParam(float money, float moneyEnd, String carCx,PageObject pageObject) {

		List<Map> map=null;
        try {
        	pageObject.setRowCount(carInfoDomDao.queryCarInfoPage());
        	map=carInfoDomDao.queryCarInfoParam(money,moneyEnd,carCx,pageObject);
        	return map;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
    
	/**
	 * 修改车辆信息
	 */
	@Override
	public boolean updCarInfoDom(CarInfoDom carInfoDom) {

        try {
        	carInfoDomDao.updCarInfo(carInfoDom);
        	return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	
	}
    /**
     * 删除车辆图片
     */
	@Override
	public boolean delCarPictureDom(int id) {
		
		try {
			carPictureDomDao.delCarPictureDom(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	/**
	 * 查询总页数
	 * @return
	 */
	@Override
	public int queryCarInfoPage() {
		
	    try {
			return carInfoDomDao.queryCarInfoPage();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
   
	/**
	 * 获取车辆的详细信息
	 */
	@Override
	public CarInfoDom queryCarInfo(int id) {
		
		try {
			return carInfoDomDao.queryCarInfo(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	/**
	 * 修改车辆图片信息
	 * @param files
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unused")
	@Override
	public int updCarPictureDom(MultipartFile[] files,int id) {
		try {
			/** 
			 * 一次上传多张图片 
			 */
			List<CarPictureDom> ls = new ArrayList<>();
			List<String> list = new ArrayList<String>();
			String path = Constant.UP_PATH;
			File f = new File(path);
			if (!f.exists())
				f.mkdirs();
			CarPictureDom carPictureDom = null;
			for (int i = 0; i < files.length; i++) {
				// 获得原始文件名  
				String fileName = files[i].getOriginalFilename();

				System.out.println("原始文件名:" + fileName);
				String name = null;

				name = fileName.substring(0, fileName.indexOf("."));
				if (!StringUtils.isNotNullStr(name)) {
					throw new Exception("文件名不能为空!");
				}
				carPictureDom = new CarPictureDom();
				try {
					carPictureDom.setShowSort(Integer.parseInt(name));
				} catch (Exception e) {
					throw new RuntimeException("图片名格式不正确!");
				}
				carPictureDom.setPicture(fileName);
				// 新文件名  
				String newFileName = UUID.randomUUID() + fileName;
				if (!files[i].isEmpty()) {
					try {

						File file = FileUtils.byte2File(files[i].getBytes(), path, newFileName);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				carPictureDom.setUrl(Constant.PICTUREADR + newFileName);
				carPictureDom.setCarId(id);
				ls.add(carPictureDom);
				System.out.println("上传图片到:" + path + newFileName);
				list.add(path + newFileName);
			}
		return carPictureDomDao.updCarPicture(carPictureDom);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	
	}

	/**
	 * 批量删除车辆信息
	 * @param ids
	 * @return
	 */
	@Override
	public boolean delCarInfoList(List<Integer> ids) {
		
		try {
			carInfoDomDao.deleteCarInfoList(ids);
			for (int i = 0; i < ids.size(); i++) {
				carPictureDomDao.delCarPictureDomParam(ids.get(i));
			} 
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	/**
	 * 设为封面
	 */
	@Override
	public boolean updCover(int id,int carId) {
		try {
			carPictureDomDao.updCover(id,carId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	
	
}
