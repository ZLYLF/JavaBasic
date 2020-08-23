package com.zyf0807.loginui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 	实现动作监听器 接口
 * @author Administrator
 *
 */

import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginListener implements ActionListener{
	// 定义属性 
	JTextField nameField;
	JPasswordField pwdField;
	
	// 实现接口中的抽象方法 
	  public void actionPerformed(ActionEvent e) {
		  // 得到按钮上的字符串
		  String btnstr = e.getActionCommand();
		  System.out.println("按钮被点击了"+btnstr);
		  if(btnstr.equals("登录")) {
			  // 获取输入框中的字符串 
			  	String namestr= nameField.getText();
				String pwdstr= pwdField.getText();
				// 验证账号密码
				if(namestr.equals("admin")&&pwdstr.equals("admin123")) {
					System.out.println("登录成功！！");
					
				}else {
					System.out.println("登录失败！！");
					LoginUI  loginUI= new LoginUI();
					loginUI.initUI();
				}
		  }else if(btnstr.equals("注册")) {
//			  打开注册界面
			  
		  }
		
	  }
}
