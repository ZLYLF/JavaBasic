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
	
	
	// ��ʼ������ķ���
	public void initUI() {
		JFrame lf = new JFrame();
		// ���ô�������
		lf.setTitle("XX��¼");
		lf.setSize(500,500);// �� ��   ��λ������ 
		lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ر�ʱ�˳�����
		lf.setLocationRelativeTo(null);// ������ʾ 
		
		// ���ò��� 
		// ��ʽ���� 
		FlowLayout fl = new FlowLayout();
		lf.setLayout(fl);
		
			
		
		/**
		 * ����������� 
		 */
		// ͼƬ - ��ǩ 
		ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\Desktop\\hklogin.jpg");
		JLabel imgjla = new JLabel(img);
		
		
		//���� ��ǩ
		JLabel namejla = new JLabel("�˺ţ�");
		JLabel pwdjla = new JLabel("���룺");
		
		// ����� 
		JTextField nameField = new JTextField();
		JPasswordField pwdField = new JPasswordField();
		
		// ��ѡ��
//		JCheckBox 
		
		// ��ť 
		JButton btn = new JButton("��¼");
		
		/**
		 * ����������������
		 */
		btn.setBackground(Color.BLUE);
		// �ߴ�
		Dimension dim = new Dimension(400,30);
		nameField.setPreferredSize(dim);
		pwdField.setPreferredSize(dim);
		
		/**
		 * ���ص�������
		 */
		
		lf.add(imgjla);
		lf.add(namejla);
		lf.add(nameField);
		lf.add(pwdjla);
		lf.add(pwdField);
		
		lf.add(btn);
		
		
		lf.setVisible(true);// ���ӻ� ��������ʾ����Ļ��  ��Ҫ���������������֮�� 
	}
	
	
	
	
	
	
	

}
