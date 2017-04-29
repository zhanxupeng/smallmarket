package com.mr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mr.domain.Commodity;
import com.mr.service.CommodityService;
import com.mr.service.factory.CommodityServiceFactory;

/**
 * Servlet implementation class CommodityIdSearchServlert
 */
@WebServlet("/CommodityIdSearchServlert")
public class CommodityIdSearchServlert extends HttpServlet {
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
		int id=Integer.parseInt(request.getParameter("id"));
		Commodity commodity=commodityService.selectById(id);
		request.setAttribute("commodity",commodity);
		request.getRequestDispatcher("commodityidsearch.jsp").forward(request, response);
	}

}
