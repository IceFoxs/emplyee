package com.yunplus.web.controller;

import java.io.IOException;

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
 * Servlet implementation class UserLogin
 */
@WebServlet("/login.do")
public class UserLogin extends HttpServlet {
    private UserService service = new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username +" "+password);
	    User user = service.findUser(username);
	    System.out.println(user);
	    if(user!=null&&user.getUsername().equals(username)&&user.getPassword().equals(password)) {
	    	request.getSession().setAttribute("user", user);
	    	response.sendRedirect(getServletContext().getContextPath()+"/emsdemo/emplist.html");
	    }
	    else {
	    	response.sendRedirect(getServletContext().getContextPath()+"/emsdemo/login.html");
	    }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
