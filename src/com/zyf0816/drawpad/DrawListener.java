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
	String btnstr="";// 按钮上字符串
	

	@Override
	public void actionPerformed(ActionEvent e) {
		 btnstr = e.getActionCommand();
		 // 两种按钮   有无字符串 
		 // 功能按钮
		 
		 // 颜色按钮 
		 if(btnstr.equals("")) {
			 // 获取颜色设置给画笔 
			 // 通过事件源 获取组件 
			 JButton btn =(JButton) e.getSource();
			Color color =  btn.getBackground();
			g.setColor(color);// 设置颜色 
		 }
			
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");
		
		int[] arr = {10 ,8 ,9 ,1 ,3 ,5 ,6 ,4 ,2 ,7 ,0};
		// 排序  
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
		
		if(btnstr.equals("直线")) {
		g.drawLine(x1, y1, x2, y2);	
		}else if(btnstr.equals("矩形")) {
			// 左上角的坐标   宽 高
			g.drawRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
		}else if(btnstr.equals("圆")) {
			// 圆外切矩形 的 左上角的坐标   宽 高
			g.drawOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
		}
//		
		
		
//		g.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
		System.out.println("释放");
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("进入");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("离开");
	}
}
