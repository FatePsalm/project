package cn.wh.warehouse.echarts.dao;


import java.util.List;

import cn.wh.warehouse.echarts.entity.SendPeople;




public interface EchartsDao {
	List<SendPeople> getSendPeople();
	Integer getCount();
}
