package com.zyf0816.drawpad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class DrawListener implements MouseListener,ActionListener{

	int x1,y1,x2,y2;
	Graphics g;
	String btnstr="";// ��ť���ַ���
	

	@Override
	public void actionPerformed(ActionEvent e) {
		 btnstr = e.getActionCommand();
		 // ���ְ�ť   �����ַ��� 
		 // ���ܰ�ť
		 
		 // ��ɫ��ť 
		 if(btnstr.equals("")) {
			 // ��ȡ��ɫ���ø����� 
			 // ͨ���¼�Դ ��ȡ��� 
			 JButton btn =(JButton) e.getSource();
			Color color =  btn.getBackground();
			g.setColor(color);// ������ɫ 
		 }
			
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("���");
		
		int[] arr = {10 ,8 ,9 ,1 ,3 ,5 ,6 ,4 ,2 ,7 ,0};
		// ����  
		for (int i = 0; i < arr.length; i++) {
			g.fillRect(100+i*40, 100, 35, arr[i]*50);
			g.drawString(arr[i]+"", 100+(i*40)+10, 80);
			System.out.print(arr[i]+"    ");
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x1=e.getX();
		y1=e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x2=e.getX();
		y2=e.getY();
		
		if(btnstr.equals("ֱ��")) {
		g.drawLine(x1, y1, x2, y2);	
		}else if(btnstr.equals("����")) {
			// ���Ͻǵ�����   �� ��
			g.drawRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
		}else if(btnstr.equals("Բ")) {
			// Բ���о��� �� ���Ͻǵ�����   �� ��
			g.drawOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
		}
//		
		
		
//		g.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
		System.out.println("�ͷ�");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("����");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("�뿪");
	}
}
