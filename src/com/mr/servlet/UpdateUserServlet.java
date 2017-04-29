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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
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
		String name=new String(request.getParameter("name").getBytes("ISO-8859-1"),"UTF-8");
		String password=request.getParameter("password");
		User user=(User)request.getSession().getAttribute("user");
		request.getSession().removeAttribute("user");
		user.setName(name);
		user.setPassword(password);
		userService.updateUser(user);
		request.setAttribute("message","用户信息修改成功，请重新登录");
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
