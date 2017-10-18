package com.yunplus.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.yunplus.dao.EmplyeeDao;
import com.yunplus.dao.UserDao;
import com.yunplus.dao.impl.EmployeeDaoImpl;
import com.yunplus.dao.impl.UserDaoImpl;
import com.yunplus.domain.Employee;
import com.yunplus.domain.User;
import com.yunplus.service.EmployeeService;
import com.yunplus.service.UserService;
import com.yunplus.service.impl.EmployeeServiceImpl;
import com.yunplus.service.impl.UserServiceImpl;

import net.sf.json.JSONObject;

public class EmplyeeDaoImplTest {
	@Test
	public void test() {
		EmplyeeDao emp = new EmployeeDaoImpl();
		List<Employee> list =emp.getAllEmployee();
		for(Employee e : list) {
		System.out.println(e);
		}
		Assert.assertNotNull(list);
	}
	@Test
	public void test1() {
		EmployeeService emp = new EmployeeServiceImpl();
		List<Employee> list =emp.getAllEmployee();
		for(Employee e : list) {
		System.out.println(e);
		}
		Assert.assertNotNull(list);
	}
	@Test
	public void test2() {
		EmplyeeDao emp = new EmployeeDaoImpl();
		int n =emp.deleteEmployee(10);
		Assert.assertEquals(1,n);
	}
	@Test
	public void test3() {
		EmployeeService emp = new EmployeeServiceImpl();
		int n =emp.deleteEmployee(11);
		Assert.assertEquals(1,n);
	}
	@Test
	public void test4() {
		EmplyeeDao emp = new EmployeeDaoImpl();
		int n =emp.updateEmployee(12,"sssss",6000,30);
		Assert.assertEquals(1,n);
	}
	@Test
	public void test5() {
		EmployeeService emp = new EmployeeServiceImpl();
		int n =emp.updateEmployee(new Employee(1,"sssss",6000,40));
		Assert.assertEquals(1,n);
	}
	@Test
	public void test6() {
		 JSONObject obj = JSONObject.fromObject("{\"status\":"+1+"}");
		 System.out.println(obj);
	}
	@Test
	public void test7() {
		EmplyeeDao emp = new EmployeeDaoImpl();
		Employee e =emp.findOneEmployee(6);
		Assert.assertNotNull(e);
	}
	@Test
	public void test8() {
		EmployeeService emp = new EmployeeServiceImpl();
		Employee e =emp.findOneEmployee(10);
		Assert.assertNotNull(e);
	}
	@Test
	public void test9() {
		EmplyeeDao emp = new EmployeeDaoImpl();
		
		int n =emp.insertEmployee(11,"sssss",6000,30);
		
		Assert.assertEquals(1,n);
	}
	@Test
	public void test10() {
		EmployeeService emp = new EmployeeServiceImpl();
		int n =emp.insertEmployee(new Employee(12,"sssss",6000,40));
		Assert.assertEquals(1,n);

	}
	@Test
	public void test11() {
		UserDao user = new UserDaoImpl();
		int status=user.addUser("’‘‘∆ÃŒ","dasdada");
		Assert.assertEquals(1, status);
	}
	@Test
	public void test12() {
		UserDao user = new UserDaoImpl();
		User u = user.findUser("’‘‘∆ÃŒ");
		Assert.assertNotNull(u);
	}
	@Test
	public void test13() {
		UserService user = new UserServiceImpl();
		int status=user.addUser(new User("’‘‘∆ÃŒ1","dasdada"));
		Assert.assertEquals(1, status);
	}
	@Test
	public void test14() {
		UserService user = new UserServiceImpl();
		User u = user.findUser("’‘‘∆ÃŒ1");
		Assert.assertNotNull(u);
	}
}
