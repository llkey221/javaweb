package com.study.controller.ch03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class responseDemo2
 */
@WebServlet("/responseDemo2")
public class responseDemo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public responseDemo2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		//ͨ��ʹ�� <meta>��ǩ�����ÿͻ����������ʾ���ַ�������
		response.setContentType("text/html");
		out.print("<meta http-equiv='content-type' content='text/html;charset=utf-8'/>");
		//ͨ������content-typeָ���ͻ�����ʾ���ַ�������
//		response.setHeader("content-type", "text/html;charset=utf-8");
		out.println("�л����񹲺͹�");
		out.println(1);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
