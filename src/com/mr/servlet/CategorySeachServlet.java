package com.mr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.domain.Commodity;
import com.mr.service.CommodityService;
import com.mr.service.factory.CommodityServiceFactory;

/**
 * Servlet implementation class CategorySeachServlet
 */
@WebServlet("/CategorySeachServlet")
public class CategorySeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommodityService commodityService=CommodityServiceFactory.getCommodityService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category=request.getParameter("category");
		List<Commodity> list=commodityService.selectByCategory(category);
		request.setAttribute("list",list);
		request.getRequestDispatcher("commoditylist.jsp").forward(request, response);
	}

}
