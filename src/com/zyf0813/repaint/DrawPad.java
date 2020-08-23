package com.zyf0813.repaint;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DrawPad extends JFrame{
	public static void main(String[] args) {
		DrawPad drawpad = new DrawPad();
		drawpad.initUI();
		
	}
	// 界面添加鼠标监听器 
	DrawListener dl = new DrawListener();
	public void initUI() {
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);// 可视化 
		
		
		// 画笔 / 画布  在可视化之后获取  
		Graphics g = getGraphics();
		System.out.println("g="+g);
		
		this.addMouseListener(dl);
		dl.g = g;// 传值   右 -> 左 
		
	}
	// 重写父类的方法  进行功能扩展 
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Image img = new ImageIcon("img/hk.jpg").getImage();
		// 缓冲图片 
		BufferedImage  buffimg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics   bg = buffimg.getGraphics();
		bg.drawLine(100, 100, 500, 100);
		bg.drawImage(img, 0, 0, null);
		for (int i = 0; i < dl.shapes.length; i++) {
			Shape shape =  dl.shapes[i];
			if(shape!=null) {
				shape.drawShape(bg);
			}
		}
		
		
		
		g.drawImage(buffimg, 0, 0, null);
	}

}
