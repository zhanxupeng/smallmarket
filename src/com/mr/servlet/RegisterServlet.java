package com.mr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.domain.User;
import com.mr.service.UserService;
import com.mr.service.factory.UserServiceFactory;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=UserServiceFactory.getUserService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		//String name=request.getParameter("name");
		String password=request.getParameter("password");
		User user=new User(id,name,password);
		boolean result=userService.insertUser(user);
		if(result){
			request.setAttribute("message","注册成功，现在可以登录了");
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}else{
			request.setAttribute("message","账号已经存在，请选择其他账号注册");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
	}

}
