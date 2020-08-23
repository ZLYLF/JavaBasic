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
		// ��������������� 
		DrawListener dl = new DrawListener();
		
		JFrame df = new JFrame("��ͼ��");
		df.setSize(800,600);
		df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		df.setLayout(new FlowLayout());
		
		
		String[] btnstrs = {"ֱ��","����","Բ","ʵ�ľ���"};
		for (int i = 0; i < btnstrs.length; i++) {
			addButton(btnstrs[i], dl, df);
		}
		Color[] colors = {Color.black,Color.white,Color.red,Color.green,Color.blue}; 
		for (int i = 0; i < colors.length; i++) {
			addButton("", dl, df, colors[i], 30, 30);
		}
		
		df.setVisible(true);// ���ӻ� 
		
		
		// ���� / ����  �ڿ��ӻ�֮���ȡ  
		Graphics g = df.getGraphics();
		System.out.println("g="+g);
		
		
		
		df.addMouseListener(dl);
		dl.g = g;// ��ֵ   �� -> �� 
	
	}
	// ���� 
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
