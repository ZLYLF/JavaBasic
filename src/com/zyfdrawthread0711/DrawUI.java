package com.zyfdrawthread0711;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DrawUI extends JFrame{
	
	public DrawUI() {
		setTitle("绘图");
		setSize(800,600);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
		
		System.out.println("必杀技1");
		Image andyimg= new ImageIcon("./img/andy必杀技1.png").getImage();
		
		// 创建双缓冲画布 
		BufferedImage buffimg = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_ARGB);
		// 取到缓冲画笔  画笔画的内容就先画在这张图片上buffimg
		Graphics buffg = buffimg.getGraphics();
		// 所有需要显示出来的东西 都用 缓冲画笔（buffg）先行绘制 
		for(int i=0;i<5;i++) {
			buffg.setColor(Color.black);
			buffg.fillRect(0, 0, getWidth(), getHeight());
			buffg.drawImage(andyimg, 100, 100, 300, 300, 0+192*i, 0, 192+i*192, 120, null);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 最后一个回合下来  每帧刷新一次 
			g.drawImage(buffimg, 0, 0, null);
		}
			
		
	}
	
	public static void main(String[] args) {
		new DrawUI();
	}

}
