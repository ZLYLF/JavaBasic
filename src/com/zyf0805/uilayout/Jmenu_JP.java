package com.zyf0805.uilayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Jmenu_JP extends JFrame{
	
	public static void main(String[] args) {
		new Jmenu_JP();
	}
	public Jmenu_JP() {
	setSize(800,700);
	setDefaultCloseOperation(3);
	
	JMenuBar jMenuBar = new JMenuBar();
	
	JMenu jMenu1 = new JMenu("菜单1");
	JMenu jMenu2 = new JMenu("菜单2");
	JMenu jMenu3 = new JMenu("菜单3");
	
	JMenuItem jmi = new JMenuItem("About1");
	JMenuItem jmi2 = new JMenuItem("About2");
	JMenuItem jmi3 = new JMenuItem("About3");
	
	jMenu1.add(jmi2);
	jMenu1.add(jmi3);
	
	jMenuBar.add(jMenu1);
	jMenuBar.add(jMenu2);
	jMenuBar.add(jMenu3);
	
	JMenu jMenu1_1 = new JMenu("菜单1_1");
	jMenu1.add(jMenu1_1);
	jMenu1_1.add(jmi);
	
	// 监听实现 
	jMenu1_1.addMouseMotionListener(new MouseMotionListener() {
		
		@Override
		public void mouseMoved(MouseEvent e) {
			System.out.println("菜单1-—1");
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
	
	// 菜单
	jmi2.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(e.getActionCommand());
		}
	});
	
	jmi.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(e.getActionCommand());
		}
	});
	
	setJMenuBar(jMenuBar);
	
	
	// 存放选项卡的组件
	JTabbedPane jTabbedpane = new JTabbedPane();
	jTabbedpane.setPreferredSize(new Dimension(300,300));
	JPanel jPanel =new JPanel();
	
	JPanel jPane2 =new JPanel();
	jTabbedpane.addTab("一", jPanel);
	jTabbedpane.addTab("二", jPane2);
	
	//面板
	JPanel jp1 = new JPanel();
	jp1.setBackground(Color.CYAN);
	jp1.setLayout(new FlowLayout());
	jp1.setPreferredSize(new Dimension(500,300));
	
	jp1.add(jTabbedpane);
	
	add(jp1,BorderLayout.SOUTH);
	
	setVisible(true);
	}
}
