package com.zyf0806.loginui;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Dimension;
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
		// 创建一个窗体对象
		JFrame loginFrame = new JFrame();
		loginFrame.setTitle("QQ");
		loginFrame.setSize(400, 400);
		loginFrame.setLocationRelativeTo(null);// 居中显示
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭时退出程序
		// 流式布局器
		FlowLayout fl = new FlowLayout();
		loginFrame.setLayout(fl);

		/**
		 * 创建组件对象
		 */
		// 图片 （标签）
		ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\eclipse-workspace\\MyJavaDrawPad\\image\\login.png");

		JLabel imgjla = new JLabel(img);

		// 标签 （文字）
		JLabel namejla = new JLabel("账号：");
		JLabel pwdjla = new JLabel("密码：");

		// 输入框
		JTextField nameField = new JTextField();
		JPasswordField pwdField = new JPasswordField();

		// 按钮
		JButton loginbtn = new JButton("登录");
		
		// 复选框
//		JCheckBox  

		/**
		 * 设置组件对象的属性
		 */
		// 尺寸
		Dimension dim = new Dimension(310, 30);
		nameField.setPreferredSize(dim);// 组件设置尺寸
		pwdField.setPreferredSize(dim);
		
		// 设置颜色
		loginbtn.setBackground(Color.BLUE);
		
		
		/**
		 * 将组件对象加载到窗体上
		 */
		loginFrame.add(imgjla);

		loginFrame.add(namejla);
		loginFrame.add(nameField);

		loginFrame.add(pwdjla);
		loginFrame.add(pwdField);

		loginFrame.add(loginbtn);

		loginFrame.setVisible(true);// 可视化 组件的加载必须在这行代码之前

	}

}
