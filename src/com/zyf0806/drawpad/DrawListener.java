package com.zyf0806.drawpad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawListener implements MouseListener, ActionListener {
	Graphics g;

	int x1, y1, x2, y2;
	String btnstr;

	public void actionPerformed(ActionEvent e) {
		btnstr = e.getActionCommand(); // 取到按钮上的字符串
	}

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

		double x = 0, y = 0;
		double a = -1.8, b = -2.0, c = -0.5, d = -0.9;
		
		Color color = new Color(0,255,0,160);
		g.setColor(color);
		
		for (int i = 0; i < 10000; i++) {
		double tempx = Math.sin(a * y) + c * Math.cos(a * x);
		double tempy = Math.sin(b * x) + d * Math.cos(b * y);
		x = tempx;
		y = tempy;
		int px = (int) (tempx * 100 + x1);
		int py = (int) (tempy * 100 + y1);
		
		g.drawLine(px, py, px, py);
//		g.fillOval(px, py, 3, 3);
		
		}
	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	public void mouseReleased(MouseEvent e) {
		x2 = e.getX();
		y2 = e.getY();
		if (btnstr.equals("直线")) {
			g.drawLine(x1, y1, x2, y2);

		} else if (btnstr.equals("矩形")) {
			// 左上角 坐标 宽 高
			g.drawRect(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
		}

		// 圆 外切矩形 左上角坐标 宽 高
//		g.drawOval(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
		System.out.println("释放");

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
