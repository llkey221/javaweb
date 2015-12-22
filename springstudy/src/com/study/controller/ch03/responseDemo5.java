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

			//һ�����ִ��ռ10������
			//2.��������ͼƬ�������ڴ��д���һ��ͼƬ
			BufferedImage img=new BufferedImage(70, 20, BufferedImage.TYPE_INT_BGR);	
			//3.�õ�ͼƬ
			Graphics2D g=(Graphics2D)img.getGraphics();
			g.setColor(Color.WHITE); //����ͼƬ���� 
			 
			g.fillRect(0,0,70,20);	//��䱳��ɫ
			//4.��ͼƬ��д����
			g.setColor(Color.BLUE); //����ͼƬ�ϵı�����ɫ
			g.setFont(new Font(null,Font.BOLD,20));  //���������С
			String checkcode=makeNum();
			//����֤�뱣����session
			request.getSession().setAttribute("checkcode", checkcode);
			g.drawString(checkcode, 0,20);
			//5.������Ӧͷ�����������ͼƬ�ķ�ʽ�� 
			response.setContentType("image/jpeg");
//			response.setHeader("content-type","image/jpeg");
			//6.������Ӧͷ���������������ͼƬ����
			response.setDateHeader("expires", -1);
			response.setHeader("Cache-Control","no-cache");
			response.setHeader("Pragma","no-cache");	
			//7.��ͼƬ����������		
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
