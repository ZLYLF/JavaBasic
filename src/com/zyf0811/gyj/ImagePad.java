package com.zyf0811.gyj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

// 继承一个窗体类  
public class ImagePad extends JFrame{
	
	public static void main(String[] args) {
			
		ImagePad  imagepad = new ImagePad();
		imagepad.initUI();
		
	}
	
	public void initUI() {
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭时退出 
		setVisible(true);
	}
	
	// Graphics  图形  
	// 绘制基本的图形 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 3D 图形 
		for (int i = 0; i < 255; i++) {
		// 颜色  R G B 0-255  (256*256*256) 0-255 暗到亮 
		Color color = new Color(i,0,0);
		// 设置颜色 
		g.setColor(color);
		// 实心矩形 左上角的坐标 
//		g.fillRect(100+i/3, 100+i/2, 255-i, 255-i);
		// 矩形的内切圆 
		g.fillOval(100+i/2, 100+i/2, 255-i, 255-i);
		}
		
		// 马赛克 
		//随机数类 
		Random ran = new Random();
		
		// 每隔十个像素点 设置一次颜色 
		for (int i = 0; i < 500; i+=10) {
			for (int j = 0; j < 500; j+=10) {
				// 随机颜色 
				Color color = new Color(ran.nextInt(256),ran.nextInt(256),ran.nextInt(256),50);
				//将这个颜色 画出一个10*10实心矩形 
				g.setColor(color);
				g.fillRect(i, j, 10, 10);
			}
		}
		
	}
	

}
