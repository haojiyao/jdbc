package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.New;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import entity.News;
import entity.Product;
import entity.ProductCategory;

import service.NewService;
import service.ProCateService;
import service.ProductService;
import service.impl.NewServiceImpl;
import service.impl.ProCateServiceImpl;
import service.impl.ProductServiceImpl;

public class ProCateServlet extends HttpServlet {

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request,response);
		 
	}

	 
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//设置编码方式
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
			ProCateService pro=new ProCateServiceImpl();
			String action=request.getParameter("action");
			if(action.equals("main")){
				List<ProductCategory> procate=new ArrayList<ProductCategory>();
				procate=pro.getProductCategory(0, 1);
				request.getSession().setAttribute("PRO_CATE", procate);
				NewService newService=new NewServiceImpl();
				List<News> newList=newService.getNewsByTop5();
				request.setAttribute("newList", newList);
				ProductService proDao=new ProductServiceImpl();
				List<Product> products=proDao.getProByL1orL2orL3(null, null, null);
				request.setAttribute("proList", products);
				System.out.println("==============>"+products.get(1).getCategoryLevel1Id());
				request.getRequestDispatcher("pre/main.jsp").forward(request, response);
			}else if(action.equals("selpro")){
				//查询当前分类下的子分类
				List<ProductCategory> level2=new ArrayList<ProductCategory>();
				List<ProductCategory> level3=new ArrayList<ProductCategory>();
				System.out.println("===============>三级列表"+request.getParameter("id"));
				int id=Integer.parseInt(request.getParameter("id"));
				level2=pro.getProductCategory(id, 2);
				System.out.println("=========level2"+level2.size());
				String result="<h2>";//二级分类
				String rellevel3="";//存放所有三级分类
				for (int i = 0; i < level2.size(); i++) {
					result+=level2.get(i).getName()+"\\";
					level3=pro.getProductCategory(level2.get(i).getId(), 3);
					for(int j = 0; j < level3.size(); j++){
						rellevel3+="<a href=\"procate?action=select&id="
					+level3.get(j).getId()+"\">"+level3.get(j).getName()+"</a>|";
					}
				}
				System.out.println(result+"</h2>"+rellevel3);
				//响应数据
				PrintWriter out=response.getWriter();
				out.print(result+"</h2>"+rellevel3);
			}else if(action.equals("queryProductCategoryList")){
				int parentId=Integer.parseInt(request.getParameter("parentId"));
				List<ProductCategory> procate=pro.getProductCategory(parentId, 0);
				PrintWriter out=response.getWriter();
				JSON json=(JSON) JSON.toJSON(procate);
				out.print(json);
				out.flush();
				out.close();

			}
			
	}
}