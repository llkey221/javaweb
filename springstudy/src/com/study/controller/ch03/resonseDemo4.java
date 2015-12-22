package com.study.controller.ch03;

import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * Servlet implementation class resonseDemo4
 */
@WebServlet("/resonseDemo4")
public class resonseDemo4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resonseDemo4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1.首先设置5秒刷新一次
		response.setHeader("refresh","5");
		//2.声明生成图片对象，在内存中创建一张图片
		BufferedImage img=new BufferedImage(80, 20, BufferedImage.TYPE_INT_BGR);	
		//3.得到图片
		Graphics2D g=(Graphics2D)img.getGraphics();
		g.setColor(Color.WHITE); //设置图片背景 
		 
		g.fillRect(0,0,80,20);	//填充背景色
		//4.向图片上写数据
		g.setColor(Color.BLUE); //设置图片上的背景颜色
		g.setFont(new Font(null,Font.BOLD,20));  //设置字体大小
		g.drawString(makeNum(), 0,20);
		//5.设置响应头控制浏览器以图片的方式打开 
		response.setContentType("image/jpeg");
//		response.setHeader("content-type","image/jpeg");
		//6.设置响应头控制浏览器不缓存图片数据
		response.setDateHeader("expires", -1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");	
		//7.将图片输出到浏览器
		ImageIO.write(img, "jpg", response.getOutputStream());
		
		
	}

	private String makeNum() {
		// TODO Auto-generated method stub
		Random rnd=new Random();
		String num=rnd.nextInt(9999999)+"";
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;i<7-num.length();i++){
			sb.append(0);
		}
		num=sb.toString()+num;
		return num;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
