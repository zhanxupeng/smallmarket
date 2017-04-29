package com.mr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.domain.User;
import com.mr.service.OrdersService;
import com.mr.service.factory.OrdersServiceFactory;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
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
		int id=Integer.parseInt(request.getParameter("id"));
		int number=Integer.parseInt(request.getParameter("number"));
		int card_id=Integer.parseInt(request.getParameter("cardid"));
		String password=request.getParameter("password");
		User user=(User) request.getSession().getAttribute("user");
		int result=ordersService.placeOrder(id, number, card_id, password, user.getId());
		/**
		 * 用户下单
		 * 获得的信息有商品id和数量，银行卡号和密码，用户账号
		 * 返回的结果为0表示账号或密码错误，1表示余额不足，2表示成功
		 */
		if(result==0){
			request.setAttribute("message","银行卡账号或密码错误，请重新输入");
			request.getRequestDispatcher("bankcard.jsp").forward(request, response);
		}else if(result==1){
			request.setAttribute("message","银行卡余额不足，请选择其他银行卡");
			request.getRequestDispatcher("bankcard.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("UserMessageServlet").forward(request, response);
		}
	}

}
