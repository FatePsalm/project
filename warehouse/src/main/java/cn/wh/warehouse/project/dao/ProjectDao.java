package cn.wh.warehouse.project.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;



import cn.wh.warehouse.common.web.PageObject;
import cn.wh.warehouse.project.entity.Project;

public interface ProjectDao {
	public List<Project> findPageObjects(@Param("project")Project project,
			@Param("pageObject")PageObject pageObject);
	public Integer getRowCount(@Param("project")Project project);
	public void saveObject(Project project);
	public Project FindById(Project project);
	public void UpdateProject(Project project);
	public Double getSumCost(@Param("project")Project project);
}
