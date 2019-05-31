package cn.wh.warehouse.department.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wh.warehouse.department.entity.Department;
import cn.wh.warehouse.department.service.DepartmentService;

@Controller
@RequestMapping("/department/")
public class DepartmentController {
	@Resource
	private DepartmentService departmentService;
	@RequestMapping("doGetDepartment")
	@ResponseBody
	public List<Department> doGetDepartment(){
		return departmentService.GetDepartment();
	}

	
}




