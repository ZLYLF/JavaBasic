package com.zyf0730.drawpad;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

public class DrawPad {
	
// ����һ��ͼ������
	Shape[] shapes = new Shape[100];
	
	public static void main(String[] args) {
		DrawPad drawpad = new DrawPad();
		drawpad.initUI();
	}

	// ��ʼ����ķ���
	public void initUI() {
		// ����ʵ�������������ӿڵ���Ķ���
		DrawListener dl = new DrawListener(shapes);
		JFrame drawFrame = new JFrame();
		drawFrame.setTitle("��ͼ��");
		drawFrame.setSize(800, 600);
		drawFrame.setLocationRelativeTo(null);
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		drawFrame.setLayout(null);
		
		JPanel  btnPanel= new JPanel();// ������� 
		btnPanel.setBounds(0, 0, 800, 100);
		btnPanel.setBackground(Color.CYAN);
		
		
		MyJPanel  drawPanel= new MyJPanel(shapes);// ������� 
		drawPanel.setBounds(0, 105, 800, 595);
		drawPanel.setBackground(Color.WHITE);
		
		String[] btnstrs = { "ֱ��", "����", "Բ", "�ݹ��̺","������" };
		
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
		
		drawFrame.setVisible(true);// ���ӻ�

		// ��ȡ���� --- ����Ҫ���� ���ӻ�֮��
		Graphics g = drawPanel.getGraphics();
		System.out.println(g);
//		g.drawLine(x1, y1, x2, y2);
//		// ����ʵ�������������ӿڵ���Ķ���
//		DrawListener dl = new DrawListener();
		drawPanel.addMouseListener(dl);// ���������������
		dl.gr = g;
	}

}
