package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.News;
import entity.User;

import service.NewService;
import service.UserService;
import service.impl.NewServiceImpl;
import service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {

	 
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
		 
		
		PrintWriter out = response.getWriter();
		String action=request.getParameter("action");
		if(action.equals("login")){
			UserService userService=new UserServiceImpl();
			String name=request.getParameter("userName");
			String pwd=request.getParameter("pwd");
			User user=userService.getUserByName(name, pwd);
			
			String result="{";
			if(null==user){
				System.out.println("空");
				result+="result:\"shibai\",msg:\"用户名或密码错误\"}";
			}else{
				request.getSession().setAttribute("USER", user); 
				result+="result:\"chenggong\"}";
			}
			System.out.println(result);
			out.print(result);
		}else if(action.equals("loginOut")){//判断是否是注销
			request.getSession().removeAttribute("USER");//移除session
			response.sendRedirect("pre/Login.jsp");//重定向
			
		}else if(action.equals("index")){
			String loginName=request.getParameter("loginName");
			UserService userService=new UserServiceImpl();
	
			User users=userService.getUserBy(loginName);
			//存到请求中
			request.setAttribute("user", users);
			//转发到jsp页面
			request.getRequestDispatcher("backend/Usera.jsp")
			.forward(request, response);
			
		}else if(action.equals("queryUserList")){
			UserService userService=new UserServiceImpl();
			List<User> userList=userService.getUser();
			//存到请求中
			request.setAttribute("userList", userList);
			
			//转发到jsp页面
			request.getRequestDispatcher("backend/Userb.jsp")
			.forward(request, response);
			
		}
		
		
		out.flush();
		out.close();
	}

}
