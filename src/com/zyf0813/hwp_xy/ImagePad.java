package com.zyf0813.hwp_xy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
// 继承窗体 
public class ImagePad extends JFrame{
	// 主方法 程序入口
	public static void main(String[] args) {
		new ImagePad();
	}
	
	public ImagePad() {
		setTitle("马赛克");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);// 可视化 
	}
	
	// 绘制 
	public void paint(Graphics g) {
		super.paint(g);
		
		// Graphics  图形 	显卡  --  屏幕映射 	 g  可用来绘制 -- 画笔/布
			
		Color color1 = new Color(255,255,255);// 三原色  R G B 0-255
//		g.setColor(color);
//		g.drawLine(100, 100, 500, 100);
		
		int[][] imgindex = getImagePix("img/hk.jpg");
		// 遍历取出数组中的颜色值 画出 
		for (int i = 0; i < imgindex.length; i++) {
			for (int j = 0; j < imgindex[0].length; j++) {
				// 取出颜色 
				int rgb = imgindex[i][j];
				Color color = new Color(rgb);
				// 取出 rgb 三分量  
				int red = color.getRed();
				int green = color.getGreen();
				int blue =color.getBlue();
				
				// 灰度图
				int wb = (red + green + blue)/3; 
				Color newcolor = new Color(wb,wb,wb); // 只要三个值 一样就可以没有颜色 只要黑白灰 
				g.setColor(color);
//				g.drawLine(i, j, i, j);
				
				// 矩形  坐标    宽 高 
//				g.fillRect(i, j, 3, 3);
				g.fillOval(i, j, 1, 1);
			}
		}
		
	}
	// 将图片转化成数组  
	public int[][] getImagePix(String imagepath) {
		// 文件类 
		File file = new File(imagepath);
		// 缓冲图片
		BufferedImage buffimg = null;
		
		try {
			buffimg = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int w = buffimg.getWidth();
		int h = buffimg.getHeight();
		// 创建存储图片像素值 的数组 
		int[][] imgIndex = new int[w][h];
		
		// 遍历图片 取出颜色值 存入数组 
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				imgIndex[i][j] = buffimg.getRGB(i, j);
			}
			
		}
		
		return imgIndex;
		
	}
	
	
	

}
