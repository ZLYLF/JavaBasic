package com.zyf0815.pad;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	int x1, y1, x2, y2;
	Color color;
	String shapetype;
	
	
	
	public Shape(int x1, int y1, int x2, int y2, Color color, String shapetype) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.shapetype = shapetype;
	}



	public void drawShape(Graphics g) {
			g.setColor(color);
		if(shapetype.equals("����")) {
			g.drawRect(x1, y1, x2-x1, y2-y1);
		}else if(shapetype.equals("������")) {
			// 
		}else if(shapetype.equals("ֱ��")) {
			g.drawLine(x1, y1, x2, y2);
			
		}
		
		
	}
	
	
	

}
