package com.zyf0805.uilayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DrawPad {
	
	ArrayList<Component> btnlist= new ArrayList();
	
	public static void main(String[] args) {
		DrawPad drawpad = new DrawPad();
		drawpad.initUI();
	}

	// ��ʼ������
	public void initUI() {
		JFrame jf = new JFrame("��ͼ��");
		jf.setSize(600, 500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �˵���
		JMenuBar jmb = new JMenuBar();
		
		// �˵�
		JMenu jm1 = new JMenu("File");

		jmb.add(jm1);
		
		// �˵���
		JMenuItem jmitem = new JMenuItem("run");
		jm1.add(jmitem);
		btnlist.add(jmitem);
		JMenu jm2 = new JMenu("Edit");
		jm1.add(jm2);

		JMenuItem jmitem2 = new JMenuItem("open");
		jm2.add(jmitem2);
		btnlist.add(jmitem2);
		

		// ��Ӳ˵���
		jf.setJMenuBar(jmb);
		// �߿򲼾�
		// �����ϱ� ��
		// ���
		JPanel jpn = new JPanel();
		jpn.setBackground(Color.WHITE);
		
		jpn.setPreferredSize(new Dimension(0, 80));
		
		// ��ť
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton("TestBtn" + i);
			btn.setRolloverEnabled(true); 
//			���� rolloverEnabled���ԣ������� true���ܷ�����תЧ����  
			btn.setPreferredSize(new Dimension(40,40));
			btn.setRolloverIcon(new ImageIcon("img/by1.jpg")); 
			
			btn.setIcon(new ImageIcon("img/by3.jpg"));
			jpn.add(btn);
			btnlist.add(btn);
		}
			
		// ��ɫ���
		JPanel jpcolor = new JPanel();
		jpcolor.setBackground(Color.WHITE);
		jpcolor.setPreferredSize(new Dimension(0, 80));
		Random random = new Random();
		// ��ť
		for (int i = 0; i < 10; i++) {
			JButton btn = new JButton("TestBtn" + i);
			btn.setBackground(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
			jpcolor.add(btn);
			btnlist.add(btn);
		}
		// ������ӱ������
//		jf.add(jpn, BorderLayout.NORTH);

		// �������
		JPanel jpc = new JPanel();
		jpc.setBackground(Color.CYAN);
//		jpc.setPreferredSize(new Dimension(0, 80));
		jpc.setLayout(null); //����null���� 
		
//		����Զ���λ�õİ�ť
		JButton btn = new JButton("�Զ���λ��");
		btn.setBounds(100, 100, 150, 100);
		btn.setRolloverEnabled(true); 
//		���� rolloverEnabled���ԣ������� true���ܷ�����תЧ����  
		btn.setRolloverIcon(new ImageIcon("img/by1.png")); 
		
		btn.setIcon(new ImageIcon("img/by3.jpg"));
		jpc.add(btn);
		jf.add(jpc, BorderLayout.CENTER);

		
		//ѡ� 
		JTabbedPane jtabpanel = new JTabbedPane();
		// ѡ����ѡ����� 
		jtabpanel.addTab("ͼ��", jpn);
		jtabpanel.addTab("��ɫ", jpcolor);
		
		// �߿򲼾����� �����λ 
		jf.add(jtabpanel, BorderLayout.NORTH);
		

		jf.setVisible(true);

	}

}
