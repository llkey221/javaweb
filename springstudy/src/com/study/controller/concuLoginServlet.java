package com.study.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class concuLoginServlet
 */
@WebServlet("/concuLoginServlet")
public class concuLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int i=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public concuLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	response.setContentType("text/html");
    	i++;
    	PrintWriter out=response.getWriter();
    	
    	out.append("this is concorrent request");
    	out.append("<br/>");
    	out.append("i="+i);
    	out.flush();
    	out.close();
    }
    
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
    	doGet(request,response);
    }

}
