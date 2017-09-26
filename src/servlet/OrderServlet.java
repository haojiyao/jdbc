package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Order;

import service.OrderService;
import service.impl.OrderServiceImpl;
import sun.awt.image.OffScreenImage;
import utils.Pager;

public class OrderServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("index")){
			String loginName=request.getParameter("loginName");
			OrderService orderServlet=new OrderServiceImpl();
			int pageNo=0;
			if(request.getParameter("currentpage")==null){
				pageNo=1;
			}else {
				pageNo=Integer.parseInt(request.getParameter("currentpage"));
			}
			//获取共多少条
			int count=orderServlet.getOrder(loginName, null, null).size();
			//分页的参数
			Pager pager=new Pager(count, 3, pageNo);
			pager.setUrl("order?action=index");
			
			List<Order> orders=orderServlet.getOrder(loginName, pageNo+"", 3+"");
			
			request.setAttribute("pager", pager);
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("backend/Order.jsp").forward(request, response);
			
		}else if(action.equals("queryAllOrder")){
			OrderService orderServlet=new OrderServiceImpl();
			
			int pageNo=0;
			if(request.getParameter("currentpage")==null){
				pageNo=1;
			}else {
				pageNo=Integer.parseInt(request.getParameter("currentpage"));
			}
			//获取共多少条
			int count=orderServlet.getquan(null, null).size();
			//分页的参数
			Pager pager=new Pager(count, 3, pageNo);
			pager.setUrl("order?action=index");
			
			List<Order> orders=orderServlet.getquan(pageNo+"", 3+"");
			
			request.setAttribute("pager", pager);
			request.setAttribute("orders", orders);
			request.getRequestDispatcher("backend/Ordera.jsp").forward(request, response);
			
			
			
		}
		
		
	}

}
