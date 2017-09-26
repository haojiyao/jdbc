package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.NewService;
import service.ProductService;
import service.impl.NewServiceImpl;
import service.impl.ProductServiceImpl;
import utils.Pager;
import entity.News;
import entity.Product;

public class NewServlet extends HttpServlet {

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
		//设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		if(action.equals("list")){//查询新闻
			NewService newService=new NewServiceImpl();
			int pageNo=0;
			//获取当前的页数currentpage：当前的页数
			if(request.getParameter("currentPage")==null){
				pageNo=1;
			}else{
				pageNo=Integer.parseInt(request.getParameter("currentPage"));
				
			}
			int rowCount=newService.getNews(null, null).size();
			
			Pager pager=new Pager(rowCount, 10, pageNo);
			pager.setUrl("NewServlet?action=list");
			
			List<News> newList=newService.getNews(pageNo+"", 10+"");
			//存到请求中
			request.setAttribute("newList", newList);
			request.setAttribute("pager", pager);
			//转发到jsp页面
			request.getRequestDispatcher("backend/Newsa.jsp")
			.forward(request, response);
			
			
		}
		
		
	}

}
