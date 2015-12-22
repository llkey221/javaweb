package com.study.controller.ch02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class initparamServlet
 */
@WebServlet("/initparamServlet")
public class initparamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ServletConfig config;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public initparamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public  void init(ServletConfig config) throws ServletException {
    	this.config=config;
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		String firstName=this.config.getInitParameter("FirstName");
		
		PrintWriter out=response.getWriter();
		out.append("<hr/>");
		out.append("FirstName="+firstName+"<br/>");
		out.append("<hr/>");
		
		Enumeration<String> names=this.config.getInitParameterNames(); 
		while(names.hasMoreElements()){
			String name=names.nextElement();
			String value=this.config.getInitParameter(name);
			out.append(name+"="+value);
			out.append("<br/>");			
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
;