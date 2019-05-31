package cn.dingd.dd.management.service.impl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.dingd.dd.auction.controller.WebSocket;
import cn.dingd.dd.common.util.Constant;
import cn.dingd.dd.management.dao.TrackingDao;
import cn.dingd.dd.management.service.MamageTrackingService;
import net.sf.json.JSONObject;

/**
 * @author 作者 Name:CaoGang
 * @version 创建时间：2017年12月13日 下午3:29:31 类说明 
 * 专员跟踪
 */
@Service
public class MamageTrackingServiceImpl implements MamageTrackingService {
	@Resource
	private TrackingDao trackingDao;
	/**提醒已过保留价*/
	public String Remind() {
		// 群发消息
		for (WebSocket item :WebSocket.webSocketSet) {
			try {
				Constant.result_Map.put("light", 1);
              	item.sendMessage(JSONObject.fromObject(Constant.result_Map).toString());
              	//System.out.println("==============加价==========="+JSONObject.fromObject(Constant.result_Map));
			} catch (IOException e) {
				e.printStackTrace();
				continue;
			}
		}
		return "提醒成功!";
	}
	/**专员跟踪*/
	public List<Map<String, Object>> Tracking(){
		return trackingDao.Tracking();
	}
}
