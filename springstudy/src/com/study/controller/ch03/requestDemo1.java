package com.study.controller.ch03;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class requestDemo1
 */
@WebServlet("/requestDemo1")
public class requestDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestUrl=request.getRequestURL().toString();
		String requestURI=request.getRequestURI();
		String queryString=request.getQueryString();
		String pathInfo=request.getPathInfo();
		String remoteAddr=request.getRemoteAddr();
		String remoteHost=request.getRemoteHost();
		String localAddr=request.getLocalAddr();
		String localName=request.getLocalName();
		
		response.setContentType("text/html");
		
		
		PrintWriter out=response.getWriter();
		
		out.println(MessageFormat.format("requestUrl:{0}", requestUrl));
		out.println("<br/>");
		out.println(MessageFormat.format("requestURI:{0}", requestURI));
		out.println("<br/>");
		out.println(MessageFormat.format("queryString:{0}", queryString));
		out.println("<br/>");
		out.println(MessageFormat.format("pathInfo:{0}", pathInfo));
		out.println("<br/>");
		out.println(MessageFormat.format("remoteAddr:{0}", remoteAddr));
		out.println("<br/>");
		out.println(MessageFormat.format("remoteHost:{0}", remoteHost));
		out.println("<br/>");
		out.println(MessageFormat.format("localAddr:{0}", localAddr));
		out.println("<br/>");
		out.println(MessageFormat.format("localName:{0}", localName));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
