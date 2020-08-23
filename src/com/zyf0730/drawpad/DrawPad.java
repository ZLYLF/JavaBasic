package com.zyf0730.drawpad;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

public class DrawPad {
	
// 创建一个图形数组
	Shape[] shapes = new Shape[100];
	
	public static void main(String[] args) {
		DrawPad drawpad = new DrawPad();
		drawpad.initUI();
	}

	// 初始界面的方法
	public void initUI() {
		// 创建实现了鼠标监听器接口的类的对象
		DrawListener dl = new DrawListener(shapes);
		JFrame drawFrame = new JFrame();
		drawFrame.setTitle("画图板");
		drawFrame.setSize(800, 600);
		drawFrame.setLocationRelativeTo(null);
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawFrame.setLayout(null);
		
		JPanel  btnPanel= new JPanel();// 面板容器 
		btnPanel.setBounds(0, 0, 800, 100);
		btnPanel.setBackground(Color.CYAN);
		
		
		MyJPanel  drawPanel= new MyJPanel(shapes);// 面板容器 
		drawPanel.setBounds(0, 105, 800, 595);
		drawPanel.setBackground(Color.WHITE);
		
		String[] btnstrs = { "直线", "矩形", "圆", "递归地毯","三角形" };
		
		for (int i = 0; i < btnstrs.length; i++) {
			JButton btn = new JButton(btnstrs[i]);
			btn.setBounds(100+i*80, 50, 60, 32);
			btnPanel.add(btn);
			
			btn.addActionListener(dl);
		}
		
		Color[] colors= {Color.BLACK,Color.white,Color.BLUE,Color.GREEN};
		for (int i = 0; i < colors.length; i++) {
			JButton btn = new JButton();
			btn.setBackground(colors[i]);
			btn.setPreferredSize(new Dimension(40,30));
			btnPanel.add(btn);
			btn.addActionListener(dl);
		}
		
		drawFrame.add(btnPanel);
		drawFrame.add(drawPanel);
		
		drawFrame.setVisible(true);// 可视化

		// 获取画笔 --- 必须要放在 可视化之后
		Graphics g = drawPanel.getGraphics();
		System.out.println(g);
//		g.drawLine(x1, y1, x2, y2);
//		// 创建实现了鼠标监听器接口的类的对象
//		DrawListener dl = new DrawListener();
		drawPanel.addMouseListener(dl);// 窗体添加鼠标监听器
		dl.gr = g;
	}

}
