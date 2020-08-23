package com.zyf0812.drawpad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DrawPad {
	public static void main(String[] args) {
		DrawPad drawpad = new DrawPad();
		drawpad.initUI();
		
	}
	
	public void initUI() {
		// 界面添加鼠标监听器 
		DrawListener dl = new DrawListener();
		
		JFrame df = new JFrame("画图板");
		df.setSize(800,600);
		df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		df.setLayout(new FlowLayout());
		
		
		String[] btnstrs = {"直线","矩形","圆","实心矩形"};
		for (int i = 0; i < btnstrs.length; i++) {
			addButton(btnstrs[i], dl, df);
		}
		Color[] colors = {Color.black,Color.white,Color.red,Color.green,Color.blue}; 
		for (int i = 0; i < colors.length; i++) {
			addButton("", dl, df, colors[i], 30, 30);
		}
		
		df.setVisible(true);// 可视化 
		
		
		// 画笔 / 画布  在可视化之后获取  
		Graphics g = df.getGraphics();
		System.out.println("g="+g);
		
		
		
		df.addMouseListener(dl);
		dl.g = g;// 传值   右 -> 左 
	
	}
	// 重载 
	public void addButton(String btnstr,ActionListener al,JFrame jf) {
		JButton  btn = new JButton(btnstr);
		jf.add(btn);
		btn.addActionListener(al);
	}
	
	public void addButton(String btnstr,ActionListener al,JFrame jf,Color color,int w,int h) {
		JButton  btn = new JButton(btnstr);
		btn.setPreferredSize(new Dimension(w,h));
		btn.setBackground(color);
		jf.add(btn);
		btn.addActionListener(al);
	}

}
