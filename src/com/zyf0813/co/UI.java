package com.zyf0813.co;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class UI {
	
	public static void main(String[] args) {
		UI  ui = new UI();
		ui.initUI();
	}
	
	// ��ʼ������
	public void initUI() {
		// ����������� 
		JFrame jf = new JFrame();
		jf.setTitle("��ͼ��");
		jf.setSize(500,600);// W  H 
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ر�ʱ�˳�����
		jf.setLocationRelativeTo(null);// ������ʾ
		// ���� 
//		FlowLayout fl = new FlowLayout();
//		jf.setLayout(fl);
		
		
//		���� 
//		jf.setLayout(null);
//		jpn.setBounds(100, 100, 200, 200);
		
		
		// ���   Ĭ�ϲ��� - ��ʽ���� 
		JPanel jpn = new JPanel();
		jpn.setBackground(Color.CYAN);
		
		JPanel jpw = new JPanel();
		jpw.setBackground(Color.GRAY);
		
		JPanel jpc = new JPanel();
		jpc.setBackground(Color.WHITE);
		
		// ���óߴ�
		Dimension dim = new Dimension(100,100);
		jpn.setPreferredSize(dim);
		jpw.setPreferredSize(dim);
		
		/**
		 * ����������� 
		 */
		// ͼƬ - ��ǩ 
		ImageIcon img = new ImageIcon("image/login.png");
		JLabel imgjla = new JLabel(img);
		
		// ���ֱ�ǩ 
		JLabel nameJla = new JLabel("�˺ţ�");
		JLabel pwdJla = new JLabel("���룺");
		
		
		// �����
		JTextField  nameField = new JTextField();
		JPasswordField pwdField = new JPasswordField();
		
		// ��ѡ��
//		JCheckBox  repwd = new JCheckBox();
//		html
		
		// ������ ��ǩ 
		JLabel   aJla = new JLabel("<html><a href='https://www.baidu.com'>�ٶ�</a></html>");
		
		
		//��ť 
		
		JButton loginBtn = new JButton("��¼");
		
		
		JButton  btn1 = new JButton("������");
		JButton  btn2 = new JButton("��˹ģ��");
		JButton  btn3 = new JButton("�Ҷ�");
		
		
		
		
		/**
		 * �������������
		 * 
		 */
		Dimension fielddim = new Dimension(300,30);
		nameField.setPreferredSize(fielddim);
		pwdField.setPreferredSize(fielddim);
		
		/**
		 * ��������ص���Ӧ������
		 */
		
		jpw.add(btn1);// �ӵ������
		jpw.add(btn2);
		jpw.add(btn3);
		
		
		// ���ص��м�����ϵ���� 
		jpc.add(imgjla);
		jpc.add(nameJla);
		jpc.add(nameField);
		jpc.add(pwdJla);
		jpc.add(pwdField);
		jpc.add(loginBtn);
		jpc.add(aJla);
		
		
		
		// ������� ��� 
		jf.add(jpn,BorderLayout.NORTH);
		jf.add(jpw,BorderLayout.WEST);
		jf.add(jpc);
		
		jf.setVisible(true);// ���ӻ�   �������֮�� 
		
		
	}

}
