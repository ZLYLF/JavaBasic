package com.zyf0807.loginui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 	ʵ�ֶ��������� �ӿ�
 * @author Administrator
 *
 */

import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginListener implements ActionListener{
	// �������� 
	JTextField nameField;
	JPasswordField pwdField;
	
	// ʵ�ֽӿ��еĳ��󷽷� 
	  public void actionPerformed(ActionEvent e) {
		  // �õ���ť�ϵ��ַ���
		  String btnstr = e.getActionCommand();
		  System.out.println("��ť�������"+btnstr);
		  if(btnstr.equals("��¼")) {
			  // ��ȡ������е��ַ��� 
			  	String namestr= nameField.getText();
				String pwdstr= pwdField.getText();
				// ��֤�˺�����
				if(namestr.equals("admin")&&pwdstr.equals("admin123")) {
					System.out.println("��¼�ɹ�����");
					
				}else {
					System.out.println("��¼ʧ�ܣ���");
					LoginUI  loginUI= new LoginUI();
					loginUI.initUI();
				}
		  }else if(btnstr.equals("ע��")) {
//			  ��ע�����
			  
		  }
		
	  }
}
