package com.study.controller.ch03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class userLogin
 */
@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String checkCode=request.getParameter("checkcode");
		
		if(checkCode==null){
			request.getSession().setAttribute("message", "please input checkcode");
			response.sendRedirect(request.getContextPath()+ "/login.jsp");			
			return;
		}
		String sessionCheckcode=(String) request.getSession().getAttribute("checkcode");
		if(sessionCheckcode==null|| !sessionCheckcode.equals(checkCode)){
			request.getSession().setAttribute("message", "please input valid checkcode");
			response.sendRedirect(request.getContextPath()+ "/login.jsp");
			return;
		}
		
		if(name==null||name.trim()==""){
			request.getSession().setAttribute("message", "please input username");
			response.sendRedirect(request.getContextPath()+ "/login.jsp");
			return;
		}
		
		if(password==null||password.trim()==""){
			request.getSession().setAttribute("message", "please input password");
			response.sendRedirect(request.getContextPath()+ "/login.jsp");
			return;
		}
		
		if(name.equals("admin")&&password.equals("admin")){
			request.getSession().setAttribute("name", name);
			request.getSession().removeAttribute("message");
			response.sendRedirect(request.getContextPath()+ "/index.jsp");						
		}else{
			request.getSession().setAttribute("message", "please check your name or password!");
			response.sendRedirect(request.getContextPath()+ "/login.jsp");
		}
			
			
	}

}
