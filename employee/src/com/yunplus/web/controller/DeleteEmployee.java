package com.yunplus.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunplus.service.EmployeeService;
import com.yunplus.service.impl.EmployeeServiceImpl;

import net.sf.json.JSONObject;

public class DeleteEmployee extends HttpServlet {       
	private  EmployeeService  service  =  new EmployeeServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8"); 
		  String id= request.getParameter("id");
	      int status = service.deleteEmployee(Integer.parseInt(id));
	      JSONObject obj=null;
	      if(status==1) {
	    	  obj= JSONObject.fromObject("{\"status\":1}");
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
