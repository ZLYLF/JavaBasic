package com.zyfdrawthread0711;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class DrawUI extends JFrame{
	
	public DrawUI() {
		setTitle("��ͼ");
		setSize(800,600);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
		
		System.out.println("��ɱ��1");
		Image andyimg= new ImageIcon("./img/andy��ɱ��1.png").getImage();
		
		// ����˫���廭�� 
		BufferedImage buffimg = new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_ARGB);
		// ȡ�����廭��  ���ʻ������ݾ��Ȼ�������ͼƬ��buffimg
		Graphics buffg = buffimg.getGraphics();
		// ������Ҫ��ʾ�����Ķ��� ���� ���廭�ʣ�buffg�����л��� 
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
			// ���һ���غ�����  ÿ֡ˢ��һ�� 
			g.drawImage(buffimg, 0, 0, null);
		}
			
		
	}
	
	public static void main(String[] args) {
		new DrawUI();
	}

}
