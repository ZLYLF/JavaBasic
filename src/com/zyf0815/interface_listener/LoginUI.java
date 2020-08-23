package com.zyf0815.interface_listener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		// 创建窗体对象
		javax.swing.JFrame lf = new javax.swing.JFrame();
		// 设置窗体对象的属性
		lf.setTitle("登录");
		lf.setSize(400, 400); // 宽 高 左上角是原点   顶级容器专用
		lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭时退出程序
		lf.setLocationRelativeTo(null);// 居中显示
		// 创建一个流式布局器对象
		FlowLayout fl = new FlowLayout();
		// 设置流式布局器
		lf.setLayout(fl);

		/**
		 * 创建组件对象
		 */
		// 标签 （图片） 参数  路径 
		ImageIcon image = new ImageIcon("./image/login.png");
		JLabel imgJla = new JLabel(image);
		
		// 标签：文字
		JLabel nameJla = new JLabel("账号：");
		JLabel pwdJla = new JLabel("密码：");
		
		// 输入框   文本   /   密码 
		JTextField   namein = new JTextField();
		JPasswordField pwdin = new JPasswordField();
		
		
		
		// 记住密码  复选框
//		JCheckBox  
		
		// 按钮
		JButton loginBtn = new JButton("登录");
		JButton registBtn = new JButton("注册");

		/**
		 * 设置组件对象的属性
		 */
//		R G  B 0-255  256位 * 256 *256 ARGB
//		Color color = new Color(0,0,0);// 黑色
//		Color color = new Color(255,255,255);// 白色
		Color color = new Color(255,255,255);
		loginBtn.setBackground(color);
		
		// 尺寸
		Dimension btndim = new Dimension(80,30);
		loginBtn.setPreferredSize(btndim);// 组件专用
		
		// 输入框尺寸
		
		Dimension indim = new Dimension(300,30);
		namein.setPreferredSize(indim);
		pwdin.setPreferredSize(indim);
		/**
		 * 将组件对象加载到窗体上
		 */
		lf.add(imgJla);
		lf.add(nameJla);
		lf.add(namein);
		lf.add(pwdJla);
		lf.add(pwdin);
		lf.add(loginBtn);
		lf.add(registBtn); 

		// 放在最后面
		lf.setVisible(true);// 显示在屏幕上 必须要 如果没有程序不会执行
		
		// 按钮添加动作监听器 
		LoginListener loginlitener = new LoginListener();
		loginBtn.addActionListener(loginlitener);
		registBtn.addActionListener(loginlitener);
		
		// 把输入框对象传入 监听器对象中 
		loginlitener.namein = namein;
		loginlitener.pwdin = pwdin;
		
	}

}
