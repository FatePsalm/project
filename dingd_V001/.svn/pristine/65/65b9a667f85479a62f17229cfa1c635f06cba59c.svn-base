package Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import cn.dingd.dd.common.entity.CarDominantEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2018年3月15日 下午4:25:59 类说明
 */
public class Json {
	public static void main(String[] args) {
		System.out.println("appearance_7_1".replaceAll("[\\d,_]", "").trim());
		carDominant();
	}
	static void imgPars(MultipartFile[] file) {
		//获取图片信息
		Map<String, MultipartFile> map=new HashMap<>();
		for (MultipartFile multipartFile : file) {
			String imgName = getImgName(multipartFile);
			String[] split = imgName.split("_");
			String appearance = "appearance".toUpperCase();
			String skeleton = "skeleton".toUpperCase();
			String interior = "interior".toUpperCase();
			String damageType = split[0].toUpperCase();
			String typeNumber = split[1];
			String sort = split[2];
			String tag = null;
			if(damageType.equals(appearance)) {
				tag=("1"+typeNumber+sort).trim();
			}else if (damageType.equals(skeleton)) {
				tag=("2"+typeNumber+sort).trim();
			}else if (damageType.equals(interior)){
				tag=("3"+typeNumber+sort).trim();
			}
			map.put(tag, multipartFile);
		}
	}
	static void carDominant() {
		String string1 = "{\"appearance_7\":[{\"appearance7\":\"../img\",\"carDescribe\":\"2\",\"damageType\":1,\"dominant\":\"1,2,5\",\"typeNumber\":7,\"xy\":\"2.4003623188405796,2.2192028985507246\"},{\"appearance7\":\"../img\",\"carDescribe\":\"1\",\"damageType\":1,\"dominant\":\"5,9,1\",\"typeNumber\":7,\"xy\":\"2.4094202898550723,1.2409420289855073\"}]}";
		String string2 = "{\"appearance_7\":[]}";
		List<CarDominantEntity> list = new ArrayList<>();
		JSONObject jsonObject = JSONObject.fromObject(string1);
		Map<String, Object> map = jsonObject;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object Value = entry.getValue();
			System.out.println("Key = " + key + ", Value = " + Value);
			// 解析value
			JSONArray fromObject = JSONArray.fromObject(Value);
			Iterator<Object> it = fromObject.iterator();
			int sort=1;
			while (it.hasNext()) {
				CarDominantEntity carDominantEntity =new CarDominantEntity();
				// 解析key
				carDominantEntity.setImgRemark(key);
 				JSONObject ob = (JSONObject) it.next();
 				String key1 = (String) it.next();
 				System.out.println("ob="+ob);
				carDominantEntity.setDominant(ob.getString("dominant"));
				carDominantEntity.setDamageType(ob.getInt("damageType"));
				carDominantEntity.setTypeNumber(ob.getInt("typeNumber"));
				carDominantEntity.setCarDescribe(ob.getInt("carDescribe"));
				carDominantEntity.setXy(ob.getString("xy"));
				carDominantEntity.setSort(sort);
				//损伤类型_损伤位置_排序
				carDominantEntity.setTag(carDominantEntity.getDamageType().toString()+carDominantEntity.getTypeNumber().toString()+carDominantEntity.getSort());
				list.add(carDominantEntity);
				sort++;
			}
			System.out.println(list);
		}
	}
	public static String getImgName(MultipartFile file) {
		return file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf("."));
	}
}
