package com.study.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SynLoginServlet
 */
@WebServlet("/SynLoginServlet")
public class SynLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int i=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SynLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out =response.getWriter();
		out.append("Served at: ").append(request.getContextPath());
		out.append("<br/>this is synchronized servlet");
		
		/*
		 * servlet实例，在一个生命周期里只创建一次，在第一次请求的时候调用init方法创建，
		 * 每过来一个请求web服务器则创建一个线程来处理它，如果多个请求访问的数据是一个
		 * 全局对象，则会产生并发线程安全问题，通过synchronized对象锁方式，锁定实例对象
		 * 实现线程安全访问，并发时排队等候安全锁释放，该方式在处理并发时性能不好，造成请求排序等待
		 * 可以通过实现SingleThreadModel，，Servlet以单线程模式来调用其它的service方法
		 * 
		 */
		synchronized(this){
			i++;
			try{
				Thread.sleep(1000*4);				
			}catch(InterruptedException e)	{				
				e.printStackTrace();
			}	
			response.getWriter().write("<br/>"+i+"");
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
