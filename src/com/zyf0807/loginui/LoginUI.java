package com.zyf0807.loginui;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginUI {
	
	public static void main(String[] args) {
		LoginUI  loginUI= new LoginUI();
		loginUI.initUI();
	}
	
	
	// 初始化方法 
	public  void initUI() {
		// 创建一个窗体对象   - 容器 
		JFrame loginFrame= new JFrame();
		// 设置窗体属性
		loginFrame.setTitle("QQ");
		loginFrame.setSize(400,400);// W  H
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗体时退出程序
		loginFrame.setLocationRelativeTo(null);// 居中显示 
		loginFrame.setResizable(false);// 不可改变窗体尺寸
		// 流式布局
		FlowLayout fl = new FlowLayout();
		loginFrame.setLayout(fl);
		
		/**
		 * 创建组件对象
		 */
		// 图片 - 标签
		ImageIcon  img = new ImageIcon("C:\\Users\\Administrator\\eclipse-workspace\\MyJavaDrawPad\\image\\login.png");
		JLabel  imgJla = new JLabel(img);  // 将图片对象加载到标签上 
		
		// 标签 - 文字 
		JLabel nameJla = new JLabel("账号：");
		JLabel pwdJla = new JLabel("密码：");
		
		// 输入框
		JTextField nameField = new JTextField();
		JPasswordField pwdField = new JPasswordField();
		
		
		// 按钮
		JButton btn = new JButton("登录");
		JButton regbtn = new JButton("注册");
		
		// 复选框
//		JCheckBox 
				
		
		/**
		 * 设置组件对象的属性 
		 */
		// 尺寸
		Dimension  dim = new Dimension(310,30);
		nameField.setPreferredSize(dim);  // 组件设置尺寸 
		pwdField.setPreferredSize(dim);
		
		/**
		 * 将组件对象加载到窗体上
		 */
		loginFrame.add(imgJla);
		
		loginFrame.add(nameJla);
		loginFrame.add(nameField);
		
		loginFrame.add(pwdJla);
		loginFrame.add(pwdField);
		
		loginFrame.add(btn);
		loginFrame.add(regbtn);
		
		// 可视化 必须放在所有组件加载之后
		loginFrame.setVisible(true);// 可视化   将窗体显示在屏幕上 
		
		
		// 创建实现了动作监听器接口的类的 对象 
		LoginListener  loginListener = new LoginListener();
				
		// 按钮添加动作监听
		btn.addActionListener(loginListener);
		regbtn.addActionListener(loginListener);
		loginListener.nameField  = nameField;
		loginListener.pwdField = pwdField;
		
	}

}
