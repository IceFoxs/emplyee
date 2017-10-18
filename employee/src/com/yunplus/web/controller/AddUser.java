package com.yunplus.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yunplus.domain.User;
import com.yunplus.service.UserService;
import com.yunplus.service.impl.UserServiceImpl;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/adduser.do")
public class AddUser extends HttpServlet {
	private UserService userService = new UserServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setCharacterEncoding("UTF-8");
		  request.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html;charset=UTF-8"); 
		  String username = request.getParameter("username");
		  String password = request.getParameter("password");
		  User user= null;
		  int status =0;
		  JSONObject obj=null;
		  if(username!=null&&!"".equals(username)) {
			  user = userService.findUser(username);
			  if(user==null) {
				  user = new User(username, password);
				  status=userService.addUser(user);
			  }
		  }
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
