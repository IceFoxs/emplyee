package com.yunplus.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunplus.domain.Employee;
import com.yunplus.service.EmployeeService;
import com.yunplus.service.impl.EmployeeServiceImpl;

import net.sf.json.JSONObject;

public class UpdateEmployee extends HttpServlet {
	private  EmployeeService  service  =  new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   response.setCharacterEncoding("UTF-8");
		   response.setContentType("text/html;charset=UTF-8");    
		   int id = Integer.parseInt(request.getParameter("id"));
		   String name = request.getParameter("name");
		   int salary = Integer.parseInt(request.getParameter("salary"));
		   int job = Integer.parseInt(request.getParameter("job"));
		   Employee emp = null;
		   JSONObject obj=null;
		   int status = 0;
		   emp=service.findOneEmployee(id);
		   if(emp!=null) {
			   emp = new Employee(id, name, salary, job);
			   System.out.println(emp);
			   status = service.updateEmployee(emp);
			   if(status==1) {
			    	  obj= JSONObject.fromObject("{\"status\":1}");
			   }   
		   }
		   else {
			    obj= JSONObject.fromObject("{\"status\":0}");
		   }
		   PrintWriter out  =response.getWriter();
		   out.write(obj.toString());
		   out.close(); 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
