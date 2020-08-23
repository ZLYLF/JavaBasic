package com.zyf0811.gyj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

// �̳�һ��������  
public class ImagePad extends JFrame{
	
	public static void main(String[] args) {
			
		ImagePad  imagepad = new ImagePad();
		imagepad.initUI();
		
	}
	
	public void initUI() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ر�ʱ�˳� 
		setVisible(true);
	}
	
	// Graphics  ͼ��  
	// ���ƻ�����ͼ�� 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 3D ͼ�� 
		for (int i = 0; i < 255; i++) {
		// ��ɫ  R G B 0-255  (256*256*256) 0-255 ������ 
		Color color = new Color(i,0,0);
		// ������ɫ 
		g.setColor(color);
		// ʵ�ľ��� ���Ͻǵ����� 
//		g.fillRect(100+i/3, 100+i/2, 255-i, 255-i);
		// ���ε�����Բ 
		g.fillOval(100+i/2, 100+i/2, 255-i, 255-i);
		}
		
		// ������ 
		//������� 
		Random ran = new Random();
		
		// ÿ��ʮ�����ص� ����һ����ɫ 
		for (int i = 0; i < 500; i+=10) {
			for (int j = 0; j < 500; j+=10) {
				// �����ɫ 
				Color color = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256),50);
				//�������ɫ ����һ��10*10ʵ�ľ��� 
				g.setColor(color);
				g.fillRect(i, j, 10, 10);
			}
		}
		
	}
	

}
