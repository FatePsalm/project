package cn.dingd.dd.biz.backgroud.service.impl;


import cn.dingd.dd.biz.backgroud.dao.DictionaryDao;
import cn.dingd.dd.biz.backgroud.dao.SjOderMapper;
import cn.dingd.dd.biz.backgroud.service.BizCommonService;
import cn.dingd.dd.biz.backgroud.service.SjOderService;
import cn.dingd.dd.biz.common.entity.CheckBillExample;
import cn.dingd.dd.biz.common.entity.StaffInfo;
import cn.dingd.dd.common.entity.*;
import cn.dingd.dd.common.util.EX;
import cn.dingd.dd.common.util.Variable;
import cn.dingd.dd.common.web.PageObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class SjOderServiceImpl implements SjOderService {
    @Autowired
    private SjOderMapper sjOderMapper;
    @Autowired
    private BizCommonService bizCommonService;
    @Autowired
    private DictionaryDao dictionaryDao;

    @Override
    public Map<String, Object> selectCarImgGroup(Integer carId, Integer type) {
        Map<String, Object> map= null;
        try {
            //其他标志
            List<Map<String, Object>> dd_pj = dictionaryDao.selectGroup(Variable.dd_pj);
            //其他证件
            List<Map<String, Object>> dd_zj = dictionaryDao.selectGroup(Variable.dd_zj);
            //图片信息
            List<CarPictureEntity> carPictureEntities = sjOderMapper.selectCarImgGroup(carId, Variable.dd_pj);
            List<CarPictureEntity> carPictureEntities1 = sjOderMapper.selectCarImgGroup(carId, Variable.dd_zj);
            imgInfo(dd_pj,carPictureEntities);
            imgInfo(dd_zj,carPictureEntities1);
            map = new HashMap<>();
            map.put("dd_pj",dd_pj);
            map.put("dd_zj",dd_zj);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return map;
    }
    /**
     * 时间: 2018/5/7 17:15
     * 功能描述:解析图片
     */
    public void imgInfo(List<Map<String, Object>> listMap, List<CarPictureEntity> list) {
        if (list == null)
            return;
        for (Map index : listMap
                ) {
            Integer dictValue = (Integer) index.get("dictValue");
            for (CarPictureEntity entity : list
                    ) {
                if (entity.getDdDictId() == dictValue) {
                    List<CarPictureEntity> indexList = (List<CarPictureEntity>) index.get("list");
                    if (indexList == null) {
                        indexList = new ArrayList<>();
                    }
                    indexList.add(entity);
                    index.put("list", indexList);
                }
            }
        }
    }
    /**
     * 时间: 2018/5/7 18:10
     * 功能描述:隐形损伤
     */
    @Override
    public Map<String, Object> selectCarY(Integer id) {
        Map<String, Object> map = null;
        try {
            //外观
            List<Map<String, Object>> damage_WG = dictionaryDao.selectGroup(Variable.dd_WG_YX);
            //骨架
            List<Map<String, Object>> damage_GJ = dictionaryDao.selectGroup(Variable.dd_GJ);
            //损伤
            List<CarDamageEntity> carDamageEntities = sjOderMapper.selectCarY(id);
            Map<String, List<CarDamageEntity>> collect = carDamageEntities.stream()
                    .collect(Collectors.groupingBy(CarDamageEntity::getDamageType));
            List<CarDamageEntity> carDamageEntities1 = collect.get(String.valueOf(Variable.damage_WG));
            List<CarDamageEntity> carDamageEntities2 = collect.get(String.valueOf(Variable.damage_GJ));
            damageInfoY(damage_WG, carDamageEntities1);
            damageInfoY(damage_GJ, carDamageEntities2);
            map = new HashMap<>();
            map.put("damage_WG", damage_WG);
            map.put("damage_GJ", damage_GJ);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return map;
    }

    /**
     * 时间: 2018/5/7 18:10
     * 功能描述:显性损伤
     */
    @Override
    public Map<String, Object> selectCarX(Integer id) {
        Map<String, Object> map = null;
        try {
            //外观
            List<Map<String, Object>> damage_WG = dictionaryDao.selectGroup(Variable.dd_WG);
            //骨架
            List<Map<String, Object>> damage_GJ = dictionaryDao.selectGroup(Variable.dd_GJ);
            //内饰
            List<Map<String, Object>> damage_NS = dictionaryDao.selectGroup(Variable.dd_NS);
            //损伤
            List<CarDominantEntity> carDominantEntities = sjOderMapper.selectCar(id);
            Map<Integer, List<CarDominantEntity>> collect = carDominantEntities.stream()
                    .collect(Collectors.groupingBy(CarDominantEntity::getDamageType));
            List<CarDominantEntity> carDominantEntities1 = collect.get(Variable.damage_WG);
            List<CarDominantEntity> carDominantEntities2 = collect.get(Variable.damage_GJ);
            List<CarDominantEntity> carDominantEntities3 = collect.get(Variable.damage_NS);
            damageInfo(damage_WG, carDominantEntities1);
            damageInfo(damage_GJ, carDominantEntities2);
            damageInfo(damage_NS, carDominantEntities3);
            map = new HashMap<>();
            map.put("damage_WG", damage_WG);
            map.put("damage_GJ", damage_GJ);
            map.put("damage_NS", damage_NS);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return map;
    }

    /**
     * 时间: 2018/5/7 17:15
     * 功能描述:解析损伤--显性
     */
    public void damageInfo(List<Map<String, Object>> listMap, List<CarDominantEntity> list) {
        if (list == null)
            return;
        for (Map index : listMap
                ) {
            Integer dictValue = (Integer) index.get("dictValue");
            for (CarDominantEntity entity : list
                    ) {
                if (entity.getTypeNumber() == dictValue) {
                    List<CarDominantEntity> indexList = (List<CarDominantEntity>) index.get("list");
                    if (indexList == null) {
                        indexList = new ArrayList<>();
                    }
                    indexList.add(entity);
                    index.put("list", indexList);
                }
            }
        }
    }

    /**
     * 时间: 2018/5/7 17:15
     * 功能描述:解析损伤--隐形
     */
    public void damageInfoY(List<Map<String, Object>> listMap, List<CarDamageEntity> list) {
        if (list == null)
            return;
        for (Map index : listMap
                ) {
            Integer dictValue = (Integer) index.get("dictValue");
            for (CarDamageEntity entity : list
                    ) {
                if (Integer.parseInt(entity.getTypeNumber()) == dictValue) {
                    List<CarDamageEntity> indexList = (List<CarDamageEntity>) index.get("list");
                    if (indexList == null) {
                        indexList = new ArrayList<>();
                    }
                    indexList.add(entity);
                    index.put("list", indexList);
                }
            }
        }
    }

    @Override
    public Map<String, Object> selectCarZH(Integer carID) {
        Map<String, Object> map = null;
        try {
            map = sjOderMapper.selectCarZH(carID);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return map;
    }

    public List<CheckBillEntity> selectIdALL(Integer id) {
        List<CheckBillEntity> checkBillEntities = null;
        try {
            checkBillEntities = sjOderMapper.selectIdALL(id);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return checkBillEntities;
    }

    /**
     * 时间: 2018/4/28 15:13
     * 功能描述:把Map封装入创建人电话和姓名
     */
    public void checkMap(Map<String, Object> stringObjectMap) throws Exception {
        if (stringObjectMap != null) {
            Integer checkType = (Integer) stringObjectMap.get("checkType");
            if (checkType == Variable.checkBill_PC || checkType == Variable.checkBill_JC) {
                StaffInfoEntity createPerson = sjOderMapper.selectStaffId((Integer) stringObjectMap.get("createPerson"));
                if (createPerson != null) {
                    stringObjectMap.put("UserName", createPerson.getuName());
                    stringObjectMap.put("UserPhone", createPerson.getuPhone());
                }
            } else if (checkType == Variable.checkBill_SJ) {
                AUserEntity createPerson = sjOderMapper.selectAuseId((Integer) stringObjectMap.get("createPerson"));
                if (createPerson != null) {
                    stringObjectMap.put("UserName", createPerson.getuName());
                    stringObjectMap.put("UserPhone", createPerson.getuPhone());
                }
            }
        }
    }

    /**
     * 时间: 2018/4/28 14:28
     * 功能描述:根据ID查询检测订单详细
     */
    @Override
    public Map<String, Object> selectId(Integer id) {
        Map<String, Object> stringObjectMap = null;
        try {
            stringObjectMap = sjOderMapper.selectId(id);
            checkMap(stringObjectMap);
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        return stringObjectMap;
    }

    public String listToString(List<Integer> stringList) {
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (Integer index : stringList) {
            if (flag) {
                result.append(","); // 分隔符
            } else {
                flag = true;
            }
            result.append(index);
        }
        return result.toString();
    }

    /**
     * 时间: 2018/4/28 15:12
     * 功能描述:获取订单列表
     */
    public Map<String, Object> selectFind(CheckBillEntity checkBillEntity, PageObject pageObject, StaffInfo staffInfo) {
        List<Integer> integers = bizCommonService.orgIdsInStaff(staffInfo.getId());//获取当前登陆用户(负责人)下所有的员工
        String s = listToString(integers);//list<Integer>转String
        List<Map<String, Object>> selectFind = null;
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        Page<Object> objects;
        try {
            objects = PageHelper.startPage(pageObject.getPageCurrent(), pageObject.getPageSize());
            selectFind = sjOderMapper.selectFind(checkBillEntity, s);
            pageObject.setRowCount((int) objects.getTotal());
            if (selectFind != null) {
                for (Map<String, Object> index : selectFind
                        ) {
                    checkMap(index);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            EX.mysqlE();
        }
        objectObjectHashMap.put("list", selectFind);
        objectObjectHashMap.put("pageObject", pageObject);
        return objectObjectHashMap;
    }

    @Override
    public int countByExample(CheckBillExample example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByExample(CheckBillExample example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(CheckBillEntity record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insertSelective(CheckBillEntity record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<CheckBillEntity> selectByExample(CheckBillExample example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CheckBillEntity selectByPrimaryKey(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int updateByExampleSelective(CheckBillEntity record, CheckBillExample example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByExample(CheckBillEntity record, CheckBillExample example) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(CheckBillEntity record) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updateByPrimaryKey(CheckBillEntity record) {
        // TODO Auto-generated method stub
        return 0;
    }

}
