package com.study.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookieDemo1
 */
@WebServlet("/cookieDemo1")
public class cookieDemo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cookieDemo1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setHeader("content-type", "text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out =response.getWriter();
		
		Cookie [] cookies=request.getCookies();
		if(cookies!=null){			
			Date date=null;
			String loginName=null;
			for(int i=0;i<cookies.length;i++){
				Cookie cookie=cookies[i];
				if(cookie.getName().equals("lastAccessTime")){
					Long lastAccessTime=Long.parseLong(cookie.getValue());
					date=new Date(lastAccessTime);				
				}	
				if(cookie.getName().equals("name")){
					loginName=URLDecoder.decode(cookie.getValue(),"utf-8");
				}
			}
			if (loginName != null && date != null) {
				out.println("欢迎光临，" + loginName);
				out.println(",您上次访问的时间是：");
				out.println(date.toLocaleString());
			}else{
				out.println("您是第一次访问本站！");
			}
			
		}else{
			
			out.println("您是第一次访问本站！");
		}
		/**
		 * 通过创建Cookie对象来新建一个Cookie对象，Cookie对象大小不能超过4KB，
		 * 一个站点，浏览器一般只允许创建20个Cookie，一个浏览器一只允许创建300条Cookie
		 * 可以通过Cookie的setMaxAge()方法设置Cookie的过期时间，以秒为单位
		 * 如果要删除一个已经存在的Cookie可以通过设置Cookie的setMaxAge(0)，设置过期时间为0，
		 * 则立即会删除该Cookie,
		 * 可以通过setDomain()设置Cookie的有效域，通过getDomain()获取cookie的有效域 
		 * 可以通过setPath()设置Cookie的路，比如：/servlet 下，则只有请求/servlet这个路径时
		 * 才会带上这个Cookie，通过getPath方法获取Cookie设置的路径 
		 * 如果需要向Cookie中存储汉字，则通过UrlEncoder.encode("","utf-8")先把汉字编码为UTF-8
		 * 再保存到Cookie中，获取汉字Cookie时，把获取的内容通过URLDecoder.deode("","utf-8")
		 * 方法把编码后内容解码为汉字
		 * 
		 */
		Cookie cookieName=new Cookie("name",URLEncoder.encode("Richard 唐华","UTF-8"));
		cookieName.setMaxAge(60*60*24); 	//设置Cookie过期时间为24小时
		response.addCookie(cookieName);
		
		Cookie cookie=new Cookie("lastAccessTime",System.currentTimeMillis()+"");
		response.addCookie(cookie);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
