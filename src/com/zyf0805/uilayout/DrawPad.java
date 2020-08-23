package com.zyf0805.uilayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DrawPad {
	
	ArrayList<Component> btnlist= new ArrayList();
	
	public static void main(String[] args) {
		DrawPad drawpad = new DrawPad();
		drawpad.initUI();
	}

	// 初始化界面
	public void initUI() {
		JFrame jf = new JFrame("画图板");
		jf.setSize(600, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 菜单条
		JMenuBar jmb = new JMenuBar();
		
		// 菜单
		JMenu jm1 = new JMenu("File");

		jmb.add(jm1);
		
		// 菜单项
		JMenuItem jmitem = new JMenuItem("run");
		jm1.add(jmitem);
		btnlist.add(jmitem);
		JMenu jm2 = new JMenu("Edit");
		jm1.add(jm2);

		JMenuItem jmitem2 = new JMenuItem("open");
		jm2.add(jmitem2);
		btnlist.add(jmitem2);
		

		// 添加菜单条
		jf.setJMenuBar(jmb);
		// 边框布局
		// 东西南北 中
		// 面板
		JPanel jpn = new JPanel();
		jpn.setBackground(Color.WHITE);
		
		jpn.setPreferredSize(new Dimension(0, 80));
		
		// 按钮
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton("TestBtn" + i);
			btn.setRolloverEnabled(true); 
//			设置 rolloverEnabled属性，必须是 true才能发生翻转效果。  
			btn.setPreferredSize(new Dimension(40,40));
			btn.setRolloverIcon(new ImageIcon("img/by1.jpg")); 
			
			btn.setIcon(new ImageIcon("img/by3.jpg"));
			jpn.add(btn);
			btnlist.add(btn);
		}
			
		// 颜色面板
		JPanel jpcolor = new JPanel();
		jpcolor.setBackground(Color.WHITE);
		jpcolor.setPreferredSize(new Dimension(0, 80));
		Random random = new Random();
		// 按钮
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton("TestBtn" + i);
			btn.setBackground(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
			jpcolor.add(btn);
			btnlist.add(btn);
		}
		// 界面添加北边面板
//		jf.add(jpn, BorderLayout.NORTH);

		// 中央面板
		JPanel jpc = new JPanel();
		jpc.setBackground(Color.CYAN);
//		jpc.setPreferredSize(new Dimension(0, 80));
		jpc.setLayout(null); //设置null布局 
		
//		添加自定义位置的按钮
		JButton btn = new JButton("自定义位置");
		btn.setBounds(100, 100, 150, 100);
		btn.setRolloverEnabled(true); 
//		设置 rolloverEnabled属性，必须是 true才能发生翻转效果。  
		btn.setRolloverIcon(new ImageIcon("img/by1.png")); 
		
		btn.setIcon(new ImageIcon("img/by3.jpg"));
		jpc.add(btn);
		jf.add(jpc, BorderLayout.CENTER);

		
		//选项卡 
		JTabbedPane jtabpanel = new JTabbedPane();
		// 选项卡添加选项面板 
		jtabpanel.addTab("图形", jpn);
		jtabpanel.addTab("颜色", jpcolor);
		
		// 边框布局设置 组件方位 
		jf.add(jtabpanel, BorderLayout.NORTH);
		

		jf.setVisible(true);

	}

}
