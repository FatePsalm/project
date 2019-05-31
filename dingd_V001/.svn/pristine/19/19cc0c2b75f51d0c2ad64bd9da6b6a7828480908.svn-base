package cn.dingd.dd.common.entity;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * @author zoucong 
 * 2018年2月8日下午2:58:00 
 * 计划任务实体类
 */
public class SchedulerJob implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	// 任务名称
	private String jobName;
	// 任务类型
	private Integer type;
	// 触发时间
	private Date triggerTime;
	// 任务创建时间
	private Date createTime;
	// 执行状态,1.未执行，2.已执行
	private Integer status;
	// 执行的服务器
	private String host;

	public SchedulerJob() {

	}

	/**
	 * 新建初始化一个任务
	 * @param date
	 * @param jobName
	 * @param type
	 */
	public SchedulerJob(Date triggerTime, String jobName, Integer type) {
		this.triggerTime = triggerTime;
		this.jobName = jobName;
		this.type = type;
		this.createTime = new Date();
		this.status = 1;
		this.host = getLocalhostId();

	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Date getTriggerTime() {
		return triggerTime;
	}

	public void setTriggerTime(Date triggerTime) {
		this.triggerTime = triggerTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getLocalhostId() {
		String host = null;
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return host;
	}

}
