package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;

import service.ProductService;
import service.impl.ProductServiceImpl;
import utils.Pager;

public class ProductServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		 doPost(request,response);
	}
 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				//设置编码
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html;charset=utf-8");
				String action=request.getParameter("action");
				ProductService proService=new ProductServiceImpl();
				if(action.equals("list")){//查询全部商品
				
					int pageNo=0;
					//获取当前的页数currentpage：当前的页数
					if(request.getParameter("currentPage")==null){
						pageNo=1;
					}else{
						pageNo=Integer.parseInt(request.getParameter("currentPage"));
						
					}
					int rowCount=proService.getProByL1orL2orL3(null, null, null).size();
					
					Pager pager=new Pager(rowCount, 5, pageNo);
					pager.setUrl("productServlet?action=list");
					
					List<Product> proList=proService.getProBy(null, null, null, pageNo+"", "5");//查询全部商品
					//存到请求中
					request.setAttribute("proList", proList);
					request.setAttribute("pager", pager);
					//转发到jsp页面
					request.getRequestDispatcher("backend/product.jsp")
					.forward(request, response);
				}else if(action.equals("delete")){
					int id=Integer.parseInt(request.getParameter("id"));
					boolean fanh=proService.delectProduct(id);
					if(fanh){
						request.setAttribute("msg", "<script>alert('删除成功')</script>");
						
					
					}else {
						request.setAttribute("msg", "<script>alert('删除失败')</script>");
					}
					request.getRequestDispatcher("productServlet?action=list").forward(request, response);
				}else if(action.equals("toAddProduct")){
					response.sendRedirect("backend/addProduct.jsp");
				
				
				}else if (action.equals("addProduct")) {
					
					System.out.println(request.getParameter("id"));
					if(request.getParameter("id")==null||request.getParameter("id").trim().length()==0){
						//调用添加的方法
						Product pro=new Product();
						int level1=0;
						int level2=0;
						int level3=0;
						String name=request.getParameter("names");
						String des=request.getParameter("description");
						String fileName=request.getParameter("photo");
						float price=0;
						int stock=0;
						System.out.println("name:"+name);
						System.out.println(fileName);
						if(request.getParameter("categoryLevel1Id")!=null){
							level1=Integer.parseInt(request.getParameter("categoryLevel1Id"));
						}
						if(request.getParameter("categoryLevel2Id")!=null){
							level2=Integer.parseInt(request.getParameter("categoryLevel2Id"));
						}
						if(request.getParameter("categoryLevel3Id")!=null){
							level3=Integer.parseInt(request.getParameter("categoryLevel3Id"));
						}
						if(request.getParameter("price")!=null){
							price=Float.parseFloat(request.getParameter("price"));
						}
						if(request.getParameter("stock")!=null){
							stock=Integer.parseInt(request.getParameter("stock"));
						}
							
						pro.setName(name);
						pro.setFileName(fileName);
						pro.setPrice(price);
						pro.setStock(stock);
						pro.setCategoryLevel1Id(level1);
						pro.setCategoryLevel2Id(level2);
						pro.setCategoryLevel3Id(level3);
						pro.setDescription(des);
						
						boolean result=proService.add(pro);
						if(result){
							request.setAttribute("msg", "<script>alert('添加成功')</script>");
							response.sendRedirect("backend/addProduct.jsp");
						}else { 
							request.setAttribute("msg", "<script>alert('添加失败')</script>");
							response.sendRedirect("backend/addProduct.jsp");
						}
						
					}else{
						//调用修改的方法
						Product pro=new Product();
						
						int level1=0;
						int level2=0;
						int level3=0;
						String name=request.getParameter("name");
						String des=request.getParameter("description");
						String fileName=request.getParameter("photo");
						float price=0;
						int stock=0;
						if(request.getParameter("categoryLevel1Id")!=null){
							level1=Integer.parseInt(request.getParameter("categoryLevel1Id"));
						}
						if(request.getParameter("categoryLevel2Id")!=null){
							level2=Integer.parseInt(request.getParameter("categoryLevel2Id"));
						}
						if(request.getParameter("categoryLevel3Id")!=null){
							level3=Integer.parseInt(request.getParameter("categoryLevel3Id"));
						}
						if(request.getParameter("price")!=null){
							price=Float.parseFloat(request.getParameter("price"));
						}
						if(request.getParameter("stock")!=null){
							stock=Integer.parseInt(request.getParameter("stock"));
						}
						int id=Integer.parseInt(request.getParameter("id"));
						pro.setId(id);
						pro.setName(name);
						pro.setFileName(fileName);
						pro.setPrice(price);
						pro.setStock(stock);
						pro.setCategoryLevel1Id(level1);
						pro.setCategoryLevel2Id(level2);
						pro.setCategoryLevel3Id(level3);
						pro.setDescription(des);
						boolean result=proService.update(pro);
						if(result){
							request.setAttribute("msg", "<script>alert('修改成功')</script>");
							request.getRequestDispatcher("productServlet?action=list").forward(request, response);
						}else { 
							request.setAttribute("msg", "<script>alert('修改失败')</script>");
							response.sendRedirect("backend/addProduct.jsp");
						}
					}
				}
		  
	}

}
