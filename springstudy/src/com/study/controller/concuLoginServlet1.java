package com.study.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class concuLoginServlet1
 */
@WebServlet("/concuLoginServlet1")
public class concuLoginServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int i=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public concuLoginServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		i++;
		
		try {
			Thread.sleep(4*1000);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		response.getWriter().append("i value is :" + i);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
