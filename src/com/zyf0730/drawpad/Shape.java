package com.zyf0730.drawpad;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	
	String shapetype;
	int x1,x2,y1,y2;
	Color color;
	
	// ���췽�� 
	/**
	 * ������������һ�� û�з���ֵ 
	 */
	public Shape(String shapetype, int x1, int x2, int y1, int y2, Color color) {
		this.shapetype = shapetype;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.color = color;
	}
	
	public void drawShape(Graphics gr) {
		
		gr.setColor(color);
		
		if(shapetype.equals("ֱ��")) {
			// ��ֱ��
			gr.drawLine(x1, y1, x2, y2);
		}else if(shapetype.equals("����")) {
			// ������ ���Ͻǵ����� �� ��
						gr.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
		}else if(shapetype.equals("Բ")) {
			// ��Բ��
			gr.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
		}
		
	}

	

}
