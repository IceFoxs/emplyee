package com.yunplus.test;

import java.util.List;

import org.junit.Test;

import com.yunplus.domain.Employee;
import com.yunplus.service.EmployeeService;
import com.yunplus.service.impl.EmployeeServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonArrayTest {
	 @Test
	 public void test() {
		 EmployeeService emp = new EmployeeServiceImpl();
		 List<Employee> list =emp.getAllEmployee();
	     JSONObject map = JSONObject.fromObject(list.get(0));
	     JSONArray  array  = new JSONArray();
	     System.out.println(map.toString());
	     for(Employee e: list) {
	        array.add(e);
	     }
	     System.out.println(array.toString());
	 }
}
