package com.zyf0730.drawpad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class DrawListener implements MouseListener ,ActionListener{
	int x1, y1, x2, y2;
	int x3, y3, x4, y4, x5, y5;

	Graphics gr;
	String shapetype;
	Color color;
	Shape[] shapes;
	
	
	public DrawListener(Shape[] shapes) {
		this.shapes=shapes;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String btnstr = e.getActionCommand();
		if("".equals(btnstr)) {
			JButton btn =(JButton)e.getSource();
			color = btn.getBackground();
			
		}else {
			shapetype = btnstr;
		}
		
	}
	
	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a
	 * component.
	 */
	int count = 0;
	public void mouseClicked(MouseEvent e) {
		
		if(shapetype.equals("������")) {
		// �����λ��� ��λ�� 
		gr.drawOval(e.getX()-16/2, e.getY()-16/2, 16,16);
		if (count == 0) {// ��һ�ε��
			x3 = e.getX();
			y3 = e.getY();
			count++;
		} else if (count == 1) {// �ڶ��ε�� 
			x4 = e.getX();
			y4 = e.getY();
			count++;
			gr.drawLine(x3, y3, x4, y4);
		}else if(count == 2) {// �����ε�� 
			x5 =e.getX();
			y5 = e.getY();
			count=0;
			gr.drawLine(x3, y3, x5, y5);
			gr.drawLine(x4, y4, x5, y5);
		}
		
		}
		System.out.println("��� ");

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();

		System.out.println("����" + x2 + " =x2  y2=" + y2);

	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	int index=0;
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		
		Shape shape= new Shape(shapetype, x1, x2, y1, y2, color);
		shape.drawShape(gr);
		shapes[index]=shape;
		index++;
	}

	/**
	 * Invoked when the mouse enters a component.
	 */
	public void mouseEntered(MouseEvent e) {
		System.out.println("����");
	}

	/**
	 * Invoked when the mouse exits a component.
	 */
	public void mouseExited(MouseEvent e) {
		System.out.println("�뿪 ");
	}

	
}
