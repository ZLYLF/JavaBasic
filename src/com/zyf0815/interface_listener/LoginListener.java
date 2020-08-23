package com.zyf0815.interface_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginListener implements ActionListener{
	JTextField namein=null;
	JPasswordField pwdin=null;
	
	// 被监听的按钮 被点击时自动调用
	 public void actionPerformed(ActionEvent e) {
		 // 得到按钮上的字符串 
		String btnstr = e.getActionCommand();
		 
		 System.out.println(btnstr + "按钮被点击了 ");
		 if(btnstr.equals("登录")) {
			String namestr = namein.getText();
			String pwdstr = pwdin.getText();
			 if(namestr.equals("admin")&&pwdstr.equals("123")) {
				 System.out.println("登录成功");
				 JFrame rgframe =new JFrame("登陆成!!");
				 rgframe.setSize(400,200);
				 rgframe.setVisible(true);
			 }
			 
		 }else if(btnstr.equals("注册")) {
			 JFrame rgframe =new JFrame("注册");
			 rgframe.setSize(400,200);
			 rgframe.setVisible(true);
			 
		 }
		 
	 }
}
