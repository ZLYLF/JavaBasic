package com.zyf0816.xj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class ImagePad extends JFrame{
	
	public static void main(String[] args) {
		new ImagePad();
	}
	
	public ImagePad() {
		setTitle("ͼ����");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ر�ʱ�˳����� 
		setVisible(true);// ���ӻ� 
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		Graphics   ͼ��    ���ƹ���    �Կ� --- ͼ����ʾ����Ļ 
		
//		// RGB 
//		Color color = new Color(100,100,100);  // ��ɫ(0,0,0)  
//		
//		// ���ø�Graphics  g
//		g.setColor(color);
//		//  x1 y1 x2 y2 
//		g.drawLine(100, 100, 500, 100);
		
		Random ran = new Random();
		int[][] colorIn= new int[500][500];
		// �����˴�ש  --  ���طŴ�ȡ һ��������ĳ����ɫ��Ȼ���������ȫ���Ƴ������ɫ
//			500*500
		for (int i = 50; i < 550; i+=10) {
			for (int j = 50; j < 550; j+=10) {
				
				// ��ɫ 				(0  +   255 +  100)/3
				Color color = new Color(ran.nextInt(100),ran.nextInt(256),ran.nextInt(256));
//				colorIn[i][j] = color.getRGB();
				g.setColor(color);
				
				// �Ҷ�  (0  +   255 +  100)/3
				
				
				// ��ֵ��  0    255 
				
				// �ͻ� �������С��һ�µ�Բ 
				// ���Ͻǵ�����   w  h 
				g.fillRect(i, j, 10, 10);
				// ���ε�����Բ  
//				g.fillOval(i, j, 10, 10);
//				for (int k = 0; k < 10; k++) {
//					for (int k2 = 0; k2 < 10; k2++) {
//						g.drawLine(i+k, j+k2, i+k, j+k2);
//					}
//					
//				}
				
				
			}
		}
		
		
		
		
		
		// �ͻ� -- ȡ һ��������ĳ����ɫ ������ƴ�С 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
