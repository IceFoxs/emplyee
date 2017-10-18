package com.yunplus.service;

import java.util.List;

import com.yunplus.domain.Employee;

public interface EmployeeService {
	 List getAllEmployee();
	 int deleteEmployee(int id);
	 int updateEmployee(Employee e);
	 Employee findOneEmployee(int eid);
	 int insertEmployee(Employee e);
}
