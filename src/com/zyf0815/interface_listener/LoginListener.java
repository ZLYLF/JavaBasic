package com.zyf0815.interface_listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginListener implements ActionListener{
	JTextField namein=null;
	JPasswordField pwdin=null;
	
	// �������İ�ť �����ʱ�Զ�����
	 public void actionPerformed(ActionEvent e) {
		 // �õ���ť�ϵ��ַ��� 
		String btnstr = e.getActionCommand();
		 
		 System.out.println(btnstr + "��ť������� ");
		 if(btnstr.equals("��¼")) {
			String namestr = namein.getText();
			String pwdstr = pwdin.getText();
			 if(namestr.equals("admin")&&pwdstr.equals("123")) {
				 System.out.println("��¼�ɹ�");
				 JFrame rgframe =new JFrame("��½��!!");
				 rgframe.setSize(400,200);
				 rgframe.setVisible(true);
			 }
			 
		 }else if(btnstr.equals("ע��")) {
			 JFrame rgframe =new JFrame("ע��");
			 rgframe.setSize(400,200);
			 rgframe.setVisible(true);
			 
		 }
		 
	 }
}
