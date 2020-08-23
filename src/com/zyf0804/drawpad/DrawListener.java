package com.zyf0804.drawpad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DrawListener implements MouseListener {
	Graphics g;
	int x1, y1, x2, y2;

	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a
	 * component.
	 */
	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");
	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {
		x1 = e.getX();
		y1 = e.getY();

		System.out.println("按下");
	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();


		System.out.println("释放");
		double x = 0, y = 0, a = -1.8, b = -2.0, c = -0.5, d = -0.9;

		for (int i = 0; i < 500000; i++) {
			
			// 计算出下一次的X 
			double nextx = Math.sin(a * y) + c * Math.cos(a * x);
			double nexty = Math.sin(b * x) + d * Math.cos(b * y);
			// 将算出来的下一次 替换给公式中用到的x 
			x = nextx;
			y = nexty;
			
			System.out.println(nextx+"=nextX  nextY="+nexty);
			
			// 放大这个数 强制转型 int 
			int px = (int) (nextx * 100 + 300);
			int py = (int) (nexty * 100 + 300);
			// 画出放大的点 
			g.setColor(Color.BLUE);
			g.drawLine(px, py, px, py);
			

		}
	}

	/**
	 * Invoked when the mouse enters a component.
	 */
	public void mouseEntered(MouseEvent e) {
		System.out.println("进入");
	}

	/**
	 * Invoked when the mouse exits a component.
	 */
	public void mouseExited(MouseEvent e) {
		System.out.println("离开");
	}

}
