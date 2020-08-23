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

	// ��ʼ������ķ���
	public void initUI() {
		// ����һ���������
		JFrame loginFrame = new JFrame();
		loginFrame.setTitle("QQ");
		loginFrame.setSize(400, 400);
		loginFrame.setLocationRelativeTo(null);// ������ʾ
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ر�ʱ�˳�����
		// ��ʽ������
		FlowLayout fl = new FlowLayout();
		loginFrame.setLayout(fl);

		/**
		 * �����������
		 */
		// ͼƬ ����ǩ��
		ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\eclipse-workspace\\MyJavaDrawPad\\image\\login.png");

		JLabel imgjla = new JLabel(img);

		// ��ǩ �����֣�
		JLabel namejla = new JLabel("�˺ţ�");
		JLabel pwdjla = new JLabel("���룺");

		// �����
		JTextField nameField = new JTextField();
		JPasswordField pwdField = new JPasswordField();

		// ��ť
		JButton loginbtn = new JButton("��¼");
		
		// ��ѡ��
//		JCheckBox  

		/**
		 * ����������������
		 */
		// �ߴ�
		Dimension dim = new Dimension(310, 30);
		nameField.setPreferredSize(dim);// ������óߴ�
		pwdField.setPreferredSize(dim);
		
		// ������ɫ
		loginbtn.setBackground(Color.BLUE);
		
		
		/**
		 * �����������ص�������
		 */
		loginFrame.add(imgjla);

		loginFrame.add(namejla);
		loginFrame.add(nameField);

		loginFrame.add(pwdjla);
		loginFrame.add(pwdField);

		loginFrame.add(loginbtn);

		loginFrame.setVisible(true);// ���ӻ� ����ļ��ر��������д���֮ǰ

	}

}
