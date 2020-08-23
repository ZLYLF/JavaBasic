package com.zyf0812.drawpad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class DrawListener implements MouseListener, ActionListener {
	int x1, y1, x2, y2, x3, y3, x4, y4, x5, y5;
	Graphics g;
	String btnstr;

	@Override
	public void actionPerformed(ActionEvent e) {

		btnstr = e.getActionCommand();
		if (btnstr.equals("")) {
			// 得到事件发生时的对象
			JButton btn = (JButton) e.getSource();
			Color btncolor = btn.getBackground();
			g.setColor(btncolor);

		}

	}

	int count = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			System.out.println("鼠标按键："+e.getButton());
		if (count == 0) {
			x3 = e.getX();
			y3 = e.getY();
			g.drawOval(x3-3, y3-3, 6, 6);
			count++;
		} else if (count == 1) {
			x4 = e.getX();
			y4 = e.getY();
			g.drawOval(x4-3, y4-3, 6, 6);
			g.drawLine(x3, y3, x4, y4);
			count++;
		} else if (count == 2) {
			x5 = e.getX();
			y5 = e.getY();
			g.drawOval(x5-3, y5-3, 6, 6);
			g.drawLine(x3, y3, x5, y5);
			g.drawLine(x5, y5, x4, y4);
			count=0;
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		y1 = e.getY();
		System.out.println("按下--");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		y2 = e.getY();
		System.out.println("释放--");
		if (btnstr.equals("直线")) {

			g.drawLine(x1, y1, x2, y2);

		} else if (btnstr.equals("矩形")) {
			// 矩形 左上角坐标 宽 高
			g.drawRect(x1, y1, Math.abs(x2 - x1), Math.abs(y2 - y1));
		}

		// 圆形 外切矩形 左上角坐标 宽 高
//		g.drawOval(x, y, width, height);

		// 实心
//		g.fillRect(x, y, width, height);
//		g.fillOval(x, y, width, height);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("进入");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("离开");
	}

}
