package cn.wh.warehouse.project.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wh.warehouse.common.web.PageObject;
import cn.wh.warehouse.project.dao.ProjectDao;
import cn.wh.warehouse.project.entity.Project;
import cn.wh.warehouse.project.service.ProjectService;
@Service
public class ProjectServiceImpl implements ProjectService{
	@Resource
	private ProjectDao projectDao;
	public Map<String, Object> findPageObjects(Project project,PageObject pageObject) {
		List<Project> list=projectDao.findPageObjects(project,pageObject);
		int rowCount=projectDao.getRowCount(project);
		System.out.println("rowCount="+rowCount);
		pageObject.setRowCount(rowCount);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("list", list);
		map.put("pageObject", pageObject);
		map.put("cost", projectDao.getSumCost(project));
		return map;
	}
	public void saveObject(Project project) {
		// TODO Auto-generated method stub
		projectDao.saveObject(project);
	}
	public Project FindById(Project project) {
		// TODO Auto-generated method stub
		return projectDao.FindById(project);
	}
	public void UpdateProject(Project project) {
		// TODO Auto-generated method stub
		projectDao.UpdateProject(project);
	}

}
