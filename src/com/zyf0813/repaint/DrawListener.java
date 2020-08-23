package com.zyf0813.repaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DrawListener implements MouseListener,ActionListener {
	int x1,y1,x2,y2;
	Graphics g;
	String btnstr;
	int shapeCount=0;
	Shape[] shapes = new Shape[50];
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btnstr = e.getActionCommand();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		System.out.println("点击  -- "+x+"=x  y="+y);
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
		 
		 Shape shape = new Shape(x1, y1, x2, y2, Color.BLUE, "直线");
		 shape.drawShape(g);
		 
		 shapes[shapeCount] = shape;
		 shapeCount++;
		 
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
