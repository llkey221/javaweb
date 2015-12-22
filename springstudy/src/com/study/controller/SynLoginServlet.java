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
		 * servletʵ������һ������������ֻ����һ�Σ��ڵ�һ�������ʱ�����init����������
		 * ÿ����һ������web�������򴴽�һ���߳�����������������������ʵ�������һ��
		 * ȫ�ֶ��������������̰߳�ȫ���⣬ͨ��synchronized��������ʽ������ʵ������
		 * ʵ���̰߳�ȫ���ʣ�����ʱ�ŶӵȺ�ȫ���ͷţ��÷�ʽ�ڴ�����ʱ���ܲ��ã������������ȴ�
		 * ����ͨ��ʵ��SingleThreadModel����Servlet�Ե��߳�ģʽ������������service����
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
