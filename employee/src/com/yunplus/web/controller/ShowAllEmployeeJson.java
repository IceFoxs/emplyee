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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ShowAllEmployeeJson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService emp = new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8");
		  response.setHeader("Cache-Control","no-cache");
		  response.setHeader("Expires","-1");
		  response.setHeader("Pragma","no-cache");
		if(request.getSession().getAttribute("user")!=null) {
		
		 List<Employee> list =emp.getAllEmployee();
	     JSONArray  array  = new JSONArray();
	     for(Employee e: list) {
	        array.add(e);
	     }
	     PrintWriter out  =response.getWriter();
	     out.write(array.toString());
	     out.close();
		}else {
			response.sendRedirect(getServletContext().getContextPath()+"/emsdemo/login.html");
		}
	 }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
