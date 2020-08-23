package com.zyf0806.drawpad;

import java.awt.Graphics;

import javax.swing.JFrame;

public class DrawPad {

	public static void main(String[] args) {
		DrawPad  drawpad = new DrawPad();
		drawpad.initUI();
	}
	
	public void initUI() {
		// 创建窗体对象
		JFrame  drawFrame = new JFrame();
		drawFrame.setTitle("画图");
		drawFrame.setSize(600,500);
		drawFrame.setLocationRelativeTo(null);
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawFrame.setVisible(true); // 可视化
		
		// 获取这个窗体对象的绘制工具 - 画笔
		Graphics g = drawFrame.getGraphics();
		System.out.println("g=="+g);
		
		// 窗体添加鼠标监听器 
		DrawListener dl=  new DrawListener();
		
		drawFrame.addMouseListener(dl);
		
		dl.g = g;
		
	}

}
