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
		drawFrame.setTitle("画图");
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗体时退出程序 
		// 居中显示 

		drawFrame.setVisible(true);// 可视化 
		
		//获取画笔 必须在可视化之后  不能报null 
		Graphics g =drawFrame.getGraphics();
		System.out.println(g);
		
		// 创建监听器类的对象 
		DrawListener dl = new DrawListener();
		drawFrame.addMouseListener(dl);
		dl.g = g;
	}
	
	
	
}
