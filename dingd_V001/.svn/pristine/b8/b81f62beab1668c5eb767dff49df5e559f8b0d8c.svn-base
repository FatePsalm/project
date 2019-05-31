package cn.dingd.dd.auction.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.dingd.dd.common.entity.SchedulerJob;

/**
 * @author zoucong
 * 2018年2月8日下午3:12:57
 */
public interface SchedulerJobDao {

	//插入job
	Integer insertJob(SchedulerJob job);
	//获取所有job
	List<SchedulerJob> getAll();
	//跟新job的状态
	Integer updateJob(@Param("jobName") String jobName,@Param("type")Integer type);
}
