package com.yunplus.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunplus.domain.Employee;
import com.yunplus.service.EmployeeService;
import com.yunplus.service.impl.EmployeeServiceImpl;
public class ShowAllEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService  service  =  new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       List<Employee> list = service.getAllEmployee();
	       response.setContentType("text/html;charset=UTF-8");
	       PrintWriter out  =response.getWriter();
	       out.write("员工如下：<br/>");
	       for(Employee e : list) {
	    	   out.write(e.getId()+"     "+e.getName()+"    "+e.getSalary()+"   "+e.getJob()+"<br/>");
	       }
	       out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
