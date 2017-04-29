package com.mr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mr.domain.User;
import com.mr.service.UserService;
import com.mr.service.factory.UserServiceFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
		//获取id和密码
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		User user=userService.selectUser(id, password);
		if(user==null){
			request.setAttribute("message","账号或密码错误，请重新输入！");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}else{
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		}
	}

}
