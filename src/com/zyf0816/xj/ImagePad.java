package com.zyf0816.xj;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;

public class ImagePad extends JFrame{
	
	public static void main(String[] args) {
		new ImagePad();
	}
	
	public ImagePad() {
		setTitle("图像处理");
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭时退出进程 
		setVisible(true);// 可视化 
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		Graphics   图形    绘制工具    显卡 --- 图像显示到屏幕 
		
//		// RGB 
//		Color color = new Color(100,100,100);  // 黑色(0,0,0)  
//		
//		// 设置给Graphics  g
//		g.setColor(color);
//		//  x1 y1 x2 y2 
//		g.drawLine(100, 100, 500, 100);
		
		Random ran = new Random();
		int[][] colorIn= new int[500][500];
		// 马赛克瓷砖  --  像素放大，取 一个区域中某个颜色，然后将这个区域全绘制成这个颜色
//			500*500
		for (int i = 50; i < 550; i+=10) {
			for (int j = 50; j < 550; j+=10) {
				
				// 颜色 				(0  +   255 +  100)/3
				Color color = new Color(ran.nextInt(100),ran.nextInt(256),ran.nextInt(256));
//				colorIn[i][j] = color.getRGB();
				g.setColor(color);
				
				// 灰度  (0  +   255 +  100)/3
				
				
				// 二值化  0    255 
				
				// 油画 随机画大小不一致的圆 
				// 左上角的坐标   w  h 
				g.fillRect(i, j, 10, 10);
				// 矩形的内切圆  
//				g.fillOval(i, j, 10, 10);
//				for (int k = 0; k < 10; k++) {
//					for (int k2 = 0; k2 < 10; k2++) {
//						g.drawLine(i+k, j+k2, i+k, j+k2);
//					}
//					
//				}
				
				
			}
		}
		
		
		
		
		
		// 油画 -- 取 一个区域中某个颜色 随机绘制大小 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
