package com.zyf0816.drawpad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DrawPad {
	public static void main(String[] args) {
		DrawPad drawpad = new DrawPad();
		drawpad.initUI();
	}
	
	
	
	public void initUI() {
		// 给窗体加载上监听机制
		DrawListener dl = new DrawListener();
		
		JFrame df = new JFrame();
		df.setTitle("画图板");
		df.setSize(700,600);
		df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		FlowLayout fl = new FlowLayout();
		df.setLayout(new FlowLayout()); // 只能用一次 
		
		// 数组 
		String[] btnstrs = {"直线","实心圆","矩形","圆","三角形"};
		// 遍历数组 
		for (int i = 0; i < btnstrs.length; i++) {
				addJButton(btnstrs[i], df, dl);
		}
		
		Color[] colors= {Color.black,Color.white,Color.red,Color.gray,Color.green,Color.blue};
		for (int i = 0; i < colors.length; i++) {
			addJButton(colors[i], df, dl);
		}
		
	
		df.setVisible(true);// 可视化 
		
		// 获取graphics   需要在可视化之后获取
		// 画笔 
		Graphics g = 	df.getGraphics();
		
//		g.draw
		
		
		df.addMouseListener(dl);
		
		dl.g = g;//将画笔对象传入监听器对象中的属性 g   
	}
	// 添加按钮
	public void addJButton(String btnstr,JFrame df,DrawListener dl) {
		JButton btn = new JButton(btnstr);
		df.add(btn);
		btn.addActionListener(dl);
		
	}
	// 颜色按钮  方法重载  
	public void addJButton(Color color,JFrame df,DrawListener dl) {
		JButton btn = new JButton();
		btn.setBackground(color);
		btn.setPreferredSize(new Dimension(40,30));
		df.add(btn);
		btn.addActionListener(dl);
		
	}
	
	

}
