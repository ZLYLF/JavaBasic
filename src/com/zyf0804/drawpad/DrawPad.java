package com.zyf0804.drawpad;

import java.awt.Graphics;
import javax.swing.JFrame;

public class DrawPad {
	public static void main(String[] args) {
		DrawPad drawpad = new DrawPad();
		drawpad.initUI();
		
	}

	public void initUI() {
		JFrame drawFrame = new JFrame();
		drawFrame.setSize(600,500);
		drawFrame.setTitle("��ͼ");
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �رմ���ʱ�˳����� 
		// ������ʾ 

		drawFrame.setVisible(true);// ���ӻ� 
		
		//��ȡ���� �����ڿ��ӻ�֮��  ���ܱ�null 
		Graphics g =drawFrame.getGraphics();
		System.out.println(g);
		
		// ������������Ķ��� 
		DrawListener dl = new DrawListener();
		drawFrame.addMouseListener(dl);
		dl.g = g;
	}
	
	
	
}
