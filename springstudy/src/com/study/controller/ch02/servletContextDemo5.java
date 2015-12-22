package com.study.controller.ch02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class servletContextDemo5
 */
@WebServlet("/servletContextDemo5")
public class servletContextDemo5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletContextDemo5() {
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
		readSrcDirPropCfgFile(response);
		response.getWriter().println("<hr/>");
		readWebRootPropCfgFile(response);
		response.getWriter().println("<hr/>");
		readPropCfgFile(response);

		response.getWriter().println("<hr/>");
		readPropCfgFile2(response);
	}

	private void readPropCfgFile2(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/study/controller/ch02/db3.properties");
		
		Properties prop=new Properties();
		prop.load(in);
		String url=prop.getProperty("url");
		
		response.getWriter().println("读取com.study.controller.ch02下的db3.properties:");
		response.getWriter().println(MessageFormat.format("url={0}", url));
	}

	private void readPropCfgFile(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String path=this.getServletContext().getRealPath("/WEB-INF/classes/db/config/db2.properties");
		InputStream in=new FileInputStream(path);
		
		Properties prop=new Properties();
		prop.load(in);
		String url=prop.getProperty("url");
		
		response.getWriter().println("读取db.config包下的db2.properties");
		
		response.getWriter().println(MessageFormat.format("url={0}", url));
		
	}

	private void readWebRootPropCfgFile(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		InputStream in=this.getServletContext().getResourceAsStream("/db4.properties");
		
		Properties prop=new Properties();
		prop.load(in);
		
		String url=prop.getProperty("url");
		response.getWriter().println("读取WebRoot目录下的db4.properties");
		response.getWriter().println(MessageFormat.format("url={0}", url));
		
		
	}

	private void readSrcDirPropCfgFile(HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		InputStream in=this.getServletContext().getResourceAsStream("/WEB-INF/classes/db1.properties");
		
		Properties prop=new Properties();
		prop.load(in);
		
		String url=prop.getProperty("url");
		
		response.getWriter().println("读取src目录下的db1.properties配置文件：");
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
