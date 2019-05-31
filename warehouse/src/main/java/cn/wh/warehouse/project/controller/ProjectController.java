package cn.wh.warehouse.project.controller;




import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wh.warehouse.common.web.PageObject;
import cn.wh.warehouse.project.entity.Project;
import cn.wh.warehouse.project.service.ProjectService;


@Controller
@RequestMapping("/project/")
public class ProjectController {
	@Resource
	private ProjectService projectService;
	
	@RequestMapping("listUI.do")
	public String listUI(){
		return "project/project_list";
	}
	@RequestMapping("doUpdateProject")
	@ResponseBody
	public void doUpdateProject(Project project){
		System.out.println(project);
		projectService.UpdateProject(project);
	}
	
	@RequestMapping("doFindById")
	@ResponseBody
	public Project doFindById(Project project){
		System.out.println(project.getId());
		return projectService.FindById(project);
	}
	
	@RequestMapping("doSaveProject")
	@ResponseBody
	public void doSaveProject(Project project){
		projectService.saveObject(project);
		System.out.println(project);
	}
	@RequestMapping("editUI")
	public String editUI(){
		return "project/project_edit";
	}
	
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public Map<String, Object> doFindPageObjects(Project project,PageObject pageObject){
		return projectService.findPageObjects(project,pageObject);
	}
	
}




