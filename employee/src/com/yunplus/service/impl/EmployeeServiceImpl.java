package com.yunplus.service.impl;

import java.util.List;

import com.yunplus.service.EmployeeService;
import com.yunplus.dao.EmplyeeDao;
import com.yunplus.dao.impl.EmployeeDaoImpl;
import com.yunplus.domain.Employee;

public class EmployeeServiceImpl  implements EmployeeService  {
    private EmplyeeDao empDao = new EmployeeDaoImpl();
	@Override
	public List getAllEmployee() {
		List list = null;
		list = empDao.getAllEmployee();
		return list;
	}
	@Override
	public int deleteEmployee(int id) {
		int status =0;
		status=empDao.deleteEmployee(id);
		return status;
	}
	@Override
	public int updateEmployee(Employee e) {
		int status =0;
		status=empDao.updateEmployee(e.getId(),e.getName(),e.getSalary(),e.getJob());
		return status;
	}
	@Override
	public Employee findOneEmployee(int eid) {
		Employee emp =null;
		emp=empDao.findOneEmployee(eid);
		return emp;
	}
	@Override
	public int insertEmployee(Employee e) {
		int status =0;
		status=empDao.insertEmployee(e.getId(),e.getName(),e.getSalary(),e.getJob());
		return status;
	}
}
