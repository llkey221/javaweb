package com.study.controller.ch03;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpCookie;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responseDemo5")
public class responseDemo5 extends HttpServlet{

		public responseDemo5(){
			super();
		}
		protected void doGet(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{

			//一个数字大概占10个像素
			//2.声明生成图片对象，在内存中创建一张图片
			BufferedImage img=new BufferedImage(70, 20, BufferedImage.TYPE_INT_BGR);	
			//3.得到图片
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setColor(Color.WHITE); //设置图片背景 
			 
			g.fillRect(0,0,70,20);	//填充背景色
			//4.向图片上写数据
			g.setColor(Color.BLUE); //设置图片上的背景颜色
			g.setFont(new Font(null,Font.BOLD,20));  //设置字体大小
			String checkcode=makeNum();
			//把验证码保存在session
			request.getSession().setAttribute("checkcode", checkcode);
			g.drawString(checkcode, 0,20);
			//5.设置响应头控制浏览器以图片的方式打开 
			response.setContentType("image/jpeg");
//			response.setHeader("content-type","image/jpeg");
			//6.设置响应头控制浏览器不缓存图片数据
			response.setDateHeader("expires", -1);
			response.setHeader("Cache-Control","no-cache");
			response.setHeader("Pragma","no-cache");	
			//7.将图片输出到浏览器		
			ImageIO.write(img, "jpeg", response.getOutputStream());
		}
		
		protected void doPost(HttpServletRequest request,HttpServletResponse response)
			throws ServletException,IOException{
			
		}
		
		private String makeNum() {
			// TODO Auto-generated method stub
			Random rnd=new Random();
			String num=rnd.nextInt(999999)+"";
			StringBuffer sb=new StringBuffer();
			
			for(int i=0;i<6-num.length();i++){
				sb.append(0);
			}
			num=sb.toString()+num;
			return num;
		}
}
