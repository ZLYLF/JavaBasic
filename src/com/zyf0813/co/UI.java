package com.zyf0813.co;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UI {
	
	public static void main(String[] args) {
		UI  ui = new UI();
		ui.initUI();
	}
	
	// 初始化界面
	public void initUI() {
		// 创建窗体对象 
		JFrame jf = new JFrame();
		jf.setTitle("画图板");
		jf.setSize(500,600);// W  H 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭时退出程序
		jf.setLocationRelativeTo(null);// 居中显示
		// 布局 
//		FlowLayout fl = new FlowLayout();
//		jf.setLayout(fl);
		
		
//		灵活布局 
//		jf.setLayout(null);
//		jpn.setBounds(100, 100, 200, 200);
		
		
		// 面板   默认布局 - 流式布局 
		JPanel jpn = new JPanel();
		jpn.setBackground(Color.CYAN);
		
		JPanel jpw = new JPanel();
		jpw.setBackground(Color.GRAY);
		
		JPanel jpc = new JPanel();
		jpc.setBackground(Color.WHITE);
		
		// 设置尺寸
		Dimension dim = new Dimension(100,100);
		jpn.setPreferredSize(dim);
		jpw.setPreferredSize(dim);
		
		/**
		 * 创建组件对象 
		 */
		// 图片 - 标签 
		ImageIcon img = new ImageIcon("image/login.png");
		JLabel imgjla = new JLabel(img);
		
		// 文字标签 
		JLabel nameJla = new JLabel("账号：");
		JLabel pwdJla = new JLabel("密码：");
		
		
		// 输入框
		JTextField  nameField = new JTextField();
		JPasswordField pwdField = new JPasswordField();
		
		// 复选框
//		JCheckBox  repwd = new JCheckBox();
//		html
		
		// 超链接 标签 
		JLabel   aJla = new JLabel("<html><a href='https://www.baidu.com'>百度</a></html>");
		
		
		//按钮 
		
		JButton loginBtn = new JButton("登录");
		
		
		JButton  btn1 = new JButton("马赛克");
		JButton  btn2 = new JButton("高斯模糊");
		JButton  btn3 = new JButton("灰度");
		
		
		
		
		/**
		 * 设置组件的属性
		 * 
		 */
		Dimension fielddim = new Dimension(300,30);
		nameField.setPreferredSize(fielddim);
		pwdField.setPreferredSize(fielddim);
		
		/**
		 * 将组件加载到对应容器上
		 */
		
		jpw.add(btn1);// 加到面板上
		jpw.add(btn2);
		jpw.add(btn3);
		
		
		// 加载到中间界面上的组件 
		jpc.add(imgjla);
		jpc.add(nameJla);
		jpc.add(nameField);
		jpc.add(pwdJla);
		jpc.add(pwdField);
		jpc.add(loginBtn);
		jpc.add(aJla);
		
		
		
		// 窗体添加 面板 
		jf.add(jpn,BorderLayout.NORTH);
		jf.add(jpw,BorderLayout.WEST);
		jf.add(jpc);
		
		jf.setVisible(true);// 可视化   加载组件之后 
		
		
	}

}
