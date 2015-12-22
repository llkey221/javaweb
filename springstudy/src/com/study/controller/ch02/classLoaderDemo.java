package com.study.controller.ch02;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class classLoaderDemo
 */
@WebServlet("/classLoaderDemo")
public class classLoaderDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classLoaderDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("content-type", "text/html;charset=utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.getWriter().println("<hr/>");
		test1(response);
		response.getWriter().println("<hr/>");
		test(response);
	}

	private void test1(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		ClassLoader load=classLoaderDemo.class.getClassLoader();
		
		InputStream in=load.getResourceAsStream("db1.properties");
		
		Properties prop=new Properties();
		prop.load(in);
		
		String url=prop.getProperty("url");
		
		response.getWriter().println(MessageFormat.format("url={0}", url));
		
	}

	private void test(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		ClassLoader load=classLoaderDemo.class.getClassLoader();
		
		InputStream in=load.getResourceAsStream("com/study/controller/ch02/db3.properties");
		
		Properties prop=new Properties();
		prop.load(in);
		String url=prop.getProperty("url");
		response.getWriter().println("classLoader ¶ÁÈ¡com.study.controller.ch02ÏÂdb3.properties");
		
		
		response.getWriter().println(MessageFormat.format("url={0}", url));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
