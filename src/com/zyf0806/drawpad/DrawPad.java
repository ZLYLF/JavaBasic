package com.zyf0806.drawpad;

import java.awt.Graphics;

import javax.swing.JFrame;

public class DrawPad {

	public static void main(String[] args) {
		DrawPad  drawpad = new DrawPad();
		drawpad.initUI();
	}
	
	public void initUI() {
		// �����������
		JFrame  drawFrame = new JFrame();
		drawFrame.setTitle("��ͼ");
		drawFrame.setSize(600,500);
		drawFrame.setLocationRelativeTo(null);
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawFrame.setVisible(true); // ���ӻ�
		
		// ��ȡ����������Ļ��ƹ��� - ����
		Graphics g = drawFrame.getGraphics();
		System.out.println("g=="+g);
		
		// ��������������� 
		DrawListener dl=  new DrawListener();
		
		drawFrame.addMouseListener(dl);
		
		dl.g = g;
		
	}

}
