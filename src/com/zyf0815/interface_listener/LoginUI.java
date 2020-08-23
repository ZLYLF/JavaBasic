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

	// ��ʼ������ķ���
	public void initUI() {
		// �����������
		javax.swing.JFrame lf = new javax.swing.JFrame();
		// ���ô�����������
		lf.setTitle("��¼");
		lf.setSize(400, 400); // �� �� ���Ͻ���ԭ��   ��������ר��
		lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ر�ʱ�˳�����
		lf.setLocationRelativeTo(null);// ������ʾ
		// ����һ����ʽ����������
		FlowLayout fl = new FlowLayout();
		// ������ʽ������
		lf.setLayout(fl);

		/**
		 * �����������
		 */
		// ��ǩ ��ͼƬ�� ����  ·�� 
		ImageIcon image = new ImageIcon("./image/login.png");
		JLabel imgJla = new JLabel(image);
		
		// ��ǩ������
		JLabel nameJla = new JLabel("�˺ţ�");
		JLabel pwdJla = new JLabel("���룺");
		
		// �����   �ı�   /   ���� 
		JTextField   namein = new JTextField();
		JPasswordField pwdin = new JPasswordField();
		
		
		
		// ��ס����  ��ѡ��
//		JCheckBox  
		
		// ��ť
		JButton loginBtn = new JButton("��¼");
		JButton registBtn = new JButton("ע��");

		/**
		 * ����������������
		 */
//		R G  B 0-255  256λ * 256 *256 ARGB
//		Color color = new Color(0,0,0);// ��ɫ
//		Color color = new Color(255,255,255);// ��ɫ
		Color color = new Color(255,255,255);
		loginBtn.setBackground(color);
		
		// �ߴ�
		Dimension btndim = new Dimension(80,30);
		loginBtn.setPreferredSize(btndim);// ���ר��
		
		// �����ߴ�
		
		Dimension indim = new Dimension(300,30);
		namein.setPreferredSize(indim);
		pwdin.setPreferredSize(indim);
		/**
		 * �����������ص�������
		 */
		lf.add(imgJla);
		lf.add(nameJla);
		lf.add(namein);
		lf.add(pwdJla);
		lf.add(pwdin);
		lf.add(loginBtn);
		lf.add(registBtn); 

		// ���������
		lf.setVisible(true);// ��ʾ����Ļ�� ����Ҫ ���û�г��򲻻�ִ��
		
		// ��ť��Ӷ��������� 
		LoginListener loginlitener = new LoginListener();
		loginBtn.addActionListener(loginlitener);
		registBtn.addActionListener(loginlitener);
		
		// ������������ ������������ 
		loginlitener.namein = namein;
		loginlitener.pwdin = pwdin;
		
	}

}
