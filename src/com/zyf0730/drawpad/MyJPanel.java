package com.zyf0730.drawpad;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyJPanel extends JPanel {

	int count = 0;
	Shape[] shapes;

	public MyJPanel(Shape[] shapes) {
		// TODO Auto-generated constructor stub
		this.shapes = shapes;

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		count++;

		System.out.println("paint" + count);
		g.drawRect(100, 100, 100, 100);
		
		// 遍历图形数组
		for (int i = 0; i < shapes.length; i++) {
			Shape shape = shapes[i];
			if(shape!=null) {
				shape.drawShape(g);
			}
		}

	}

}
