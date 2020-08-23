package com.zyf0816.ui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginUI {
	
	public static void main(String[] args) {
		LoginUI loginui = new LoginUI();
		loginui.initUI();
	}
	
	
	// 初始化界面的方法
	public void initUI() {
		JFrame lf = new JFrame();
		// 设置窗体属性
		lf.setTitle("XX登录");
		lf.setSize(500,500);// 宽 高   单位：像素 
		lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭时退出程序
		lf.setLocationRelativeTo(null);// 居中显示 
		
		// 设置布局 
		// 流式布局 
		FlowLayout fl = new FlowLayout();
		lf.setLayout(fl);
		
			
		
		/**
		 * 创建组件对象 
		 */
		// 图片 - 标签 
		ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\Desktop\\hklogin.jpg");
		JLabel imgjla = new JLabel(img);
		
		
		//文字 标签
		JLabel namejla = new JLabel("账号：");
		JLabel pwdjla = new JLabel("密码：");
		
		// 输入框 
		JTextField nameField = new JTextField();
		JPasswordField pwdField = new JPasswordField();
		
		// 复选框
//		JCheckBox 
		
		// 按钮 
		JButton btn = new JButton("登录");
		
		/**
		 * 设置组件对象的属性
		 */
		btn.setBackground(Color.BLUE);
		// 尺寸
		Dimension dim = new Dimension(400,30);
		nameField.setPreferredSize(dim);
		pwdField.setPreferredSize(dim);
		
		/**
		 * 加载到窗体上
		 */
		
		lf.add(imgjla);
		lf.add(namejla);
		lf.add(nameField);
		lf.add(pwdjla);
		lf.add(pwdField);
		
		lf.add(btn);
		
		
		lf.setVisible(true);// 可视化 将窗体显示在屏幕上  需要放在所有组件加载之后 
	}
	
	
	
	
	
	
	

}
