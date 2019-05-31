package cn.wh.warehouse.department.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.wh.warehouse.department.dao.DepartmentDao;
import cn.wh.warehouse.department.entity.Department;
import cn.wh.warehouse.department.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Resource
	private DepartmentDao departmentDao;
	
	public List<Department> GetDepartment() {
		// TODO Auto-generated method stub
		return departmentDao.GetDepartment();
	}

}
