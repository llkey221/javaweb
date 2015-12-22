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
		//1.��������5��ˢ��һ��
		response.setHeader("refresh","5");
		//2.��������ͼƬ�������ڴ��д���һ��ͼƬ
		BufferedImage img=new BufferedImage(80, 20, BufferedImage.TYPE_INT_BGR);	
		//3.�õ�ͼƬ
		Graphics2D g=(Graphics2D)img.getGraphics();
		g.setColor(Color.WHITE); //����ͼƬ���� 
		 
		g.fillRect(0,0,80,20);	//��䱳��ɫ
		//4.��ͼƬ��д����
		g.setColor(Color.BLUE); //����ͼƬ�ϵı�����ɫ
		g.setFont(new Font(null,Font.BOLD,20));  //���������С
		g.drawString(makeNum(), 0,20);
		//5.������Ӧͷ�����������ͼƬ�ķ�ʽ�� 
		response.setContentType("image/jpeg");
//		response.setHeader("content-type","image/jpeg");
		//6.������Ӧͷ���������������ͼƬ����
		response.setDateHeader("expires", -1);
		response.setHeader("Cache-Control","no-cache");
		response.setHeader("Pragma","no-cache");	
		//7.��ͼƬ����������
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
