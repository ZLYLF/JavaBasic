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
		// ����������ϼ�������
		DrawListener dl = new DrawListener();
		
		JFrame df = new JFrame();
		df.setTitle("��ͼ��");
		df.setSize(700,600);
		df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		FlowLayout fl = new FlowLayout();
		df.setLayout(new FlowLayout()); // ֻ����һ�� 
		
		// ���� 
		String[] btnstrs = {"ֱ��","ʵ��Բ","����","Բ","������"};
		// �������� 
		for (int i = 0; i < btnstrs.length; i++) {
				addJButton(btnstrs[i], df, dl);
		}
		
		Color[] colors= {Color.black,Color.white,Color.red,Color.gray,Color.green,Color.blue};
		for (int i = 0; i < colors.length; i++) {
			addJButton(colors[i], df, dl);
		}
		
	
		df.setVisible(true);// ���ӻ� 
		
		// ��ȡgraphics   ��Ҫ�ڿ��ӻ�֮���ȡ
		// ���� 
		Graphics g = 	df.getGraphics();
		
//		g.draw
		
		
		df.addMouseListener(dl);
		
		dl.g = g;//�����ʶ���������������е����� g   
	}
	// ��Ӱ�ť
	public void addJButton(String btnstr,JFrame df,DrawListener dl) {
		JButton btn = new JButton(btnstr);
		df.add(btn);
		btn.addActionListener(dl);
		
	}
	// ��ɫ��ť  ��������  
	public void addJButton(Color color,JFrame df,DrawListener dl) {
		JButton btn = new JButton();
		btn.setBackground(color);
		btn.setPreferredSize(new Dimension(40,30));
		df.add(btn);
		btn.addActionListener(dl);
		
	}
	
	

}
