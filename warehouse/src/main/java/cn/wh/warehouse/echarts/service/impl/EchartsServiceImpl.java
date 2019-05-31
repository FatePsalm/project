package cn.wh.warehouse.echarts.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wh.warehouse.echarts.dao.EchartsDao;
import cn.wh.warehouse.echarts.entity.SendPeople;
import cn.wh.warehouse.echarts.service.EchartsService;
@Service
public class EchartsServiceImpl implements EchartsService {
	@Resource 
	private EchartsDao echartsDao;
	
	public Map<String, Object> getSendPeople() {
		Map<String, Object> map=new HashMap<String,Object>();
		List<String> xList=new ArrayList<String>();
		List<SendPeople> data=echartsDao.getSendPeople();
		for(SendPeople e:data){
			xList.add(e.getName());
		}
		Integer integer=echartsDao.getCount();
		map.put("xList", xList);
		map.put("data", data);
		map.put("Count", integer);
		return map;
	}

}
