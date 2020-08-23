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
	
	
	// ��ʼ������ 
	public  void initUI() {
		// ����һ���������   - ���� 
		JFrame loginFrame= new JFrame();
		// ���ô�������
		loginFrame.setTitle("QQ");
		loginFrame.setSize(400,400);// W  H
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �رմ���ʱ�˳�����
		loginFrame.setLocationRelativeTo(null);// ������ʾ 
		loginFrame.setResizable(false);// ���ɸı䴰��ߴ�
		// ��ʽ����
		FlowLayout fl = new FlowLayout();
		loginFrame.setLayout(fl);
		
		/**
		 * �����������
		 */
		// ͼƬ - ��ǩ
		ImageIcon  img = new ImageIcon("C:\\Users\\Administrator\\eclipse-workspace\\MyJavaDrawPad\\image\\login.png");
		JLabel  imgJla = new JLabel(img);  // ��ͼƬ������ص���ǩ�� 
		
		// ��ǩ - ���� 
		JLabel nameJla = new JLabel("�˺ţ�");
		JLabel pwdJla = new JLabel("���룺");
		
		// �����
		JTextField nameField = new JTextField();
		JPasswordField pwdField = new JPasswordField();
		
		
		// ��ť
		JButton btn = new JButton("��¼");
		JButton regbtn = new JButton("ע��");
		
		// ��ѡ��
//		JCheckBox 
				
		
		/**
		 * ���������������� 
		 */
		// �ߴ�
		Dimension  dim = new Dimension(310,30);
		nameField.setPreferredSize(dim);  // ������óߴ� 
		pwdField.setPreferredSize(dim);
		
		/**
		 * �����������ص�������
		 */
		loginFrame.add(imgJla);
		
		loginFrame.add(nameJla);
		loginFrame.add(nameField);
		
		loginFrame.add(pwdJla);
		loginFrame.add(pwdField);
		
		loginFrame.add(btn);
		loginFrame.add(regbtn);
		
		// ���ӻ� ������������������֮��
		loginFrame.setVisible(true);// ���ӻ�   ��������ʾ����Ļ�� 
		
		
		// ����ʵ���˶����������ӿڵ���� ���� 
		LoginListener  loginListener = new LoginListener();
				
		// ��ť��Ӷ�������
		btn.addActionListener(loginListener);
		regbtn.addActionListener(loginListener);
		loginListener.nameField  = nameField;
		loginListener.pwdField = pwdField;
		
	}

}
