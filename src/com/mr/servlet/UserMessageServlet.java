package com.mr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.domain.Orders;
import com.mr.domain.User;
import com.mr.service.OrdersService;
import com.mr.service.factory.OrdersServiceFactory;

/**
 * Servlet implementation class UserMessageServlet
 */
@WebServlet("/UserMessageServlet")
public class UserMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdersService ordersService=OrdersServiceFactory.getOrdersService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=(User)request.getSession().getAttribute("user");
		List<Orders> list=ordersService.selectOrdersByUserId(user.getId());
		request.setAttribute("list",list);
		request.getRequestDispatcher("usermessage.jsp").forward(request, response);
	}

}
