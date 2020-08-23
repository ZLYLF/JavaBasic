package com.zyf0730.drawpad;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	
	String shapetype;
	int x1,x2,y1,y2;
	Color color;
	
	// 构造方法 
	/**
	 * 方法名与类名一致 没有返回值 
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
		
		if(shapetype.equals("直线")) {
			// 画直线
			gr.drawLine(x1, y1, x2, y2);
		}else if(shapetype.equals("矩形")) {
			// 画矩形 左上角的坐标 宽 高
						gr.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
		}else if(shapetype.equals("圆")) {
			// 画圆形
			gr.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
		}
		
	}

	

}
