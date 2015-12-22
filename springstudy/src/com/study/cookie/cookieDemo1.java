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
				out.println("��ӭ���٣�" + loginName);
				out.println(",���ϴη��ʵ�ʱ���ǣ�");
				out.println(date.toLocaleString());
			}else{
				out.println("���ǵ�һ�η��ʱ�վ��");
			}
			
		}else{
			
			out.println("���ǵ�һ�η��ʱ�վ��");
		}
		/**
		 * ͨ������Cookie�������½�һ��Cookie����Cookie�����С���ܳ���4KB��
		 * һ��վ�㣬�����һ��ֻ������20��Cookie��һ�������һֻ������300��Cookie
		 * ����ͨ��Cookie��setMaxAge()��������Cookie�Ĺ���ʱ�䣬����Ϊ��λ
		 * ���Ҫɾ��һ���Ѿ����ڵ�Cookie����ͨ������Cookie��setMaxAge(0)�����ù���ʱ��Ϊ0��
		 * ��������ɾ����Cookie,
		 * ����ͨ��setDomain()����Cookie����Ч��ͨ��getDomain()��ȡcookie����Ч�� 
		 * ����ͨ��setPath()����Cookie��·�����磺/servlet �£���ֻ������/servlet���·��ʱ
		 * �Ż�������Cookie��ͨ��getPath������ȡCookie���õ�·�� 
		 * �����Ҫ��Cookie�д洢���֣���ͨ��UrlEncoder.encode("","utf-8")�ȰѺ��ֱ���ΪUTF-8
		 * �ٱ��浽Cookie�У���ȡ����Cookieʱ���ѻ�ȡ������ͨ��URLDecoder.deode("","utf-8")
		 * �����ѱ�������ݽ���Ϊ����
		 * 
		 */
		Cookie cookieName=new Cookie("name",URLEncoder.encode("Richard �ƻ�","UTF-8"));
		cookieName.setMaxAge(60*60*24); 	//����Cookie����ʱ��Ϊ24Сʱ
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
