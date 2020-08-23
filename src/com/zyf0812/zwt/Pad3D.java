package com.zyf0812.zwt;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
// ��ϵͳ���е���    swing���  
import javax.swing.JFrame;
// �̳��˴��� �� JFrame 
public class Pad3D extends JFrame{
	public static void main(String[] args) {
		Pad3D pad3d =  new Pad3D();
	}
	public	Pad3D(){
		// ����
		setSize(700,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ر�ʱ�˳����� 
		setVisible(true);// ���ӻ� 	
	}
	
	// ���� 
	// Graphics  ͼ���� // ����       ���������ڽ����ϻ���               �Կ� -  ��ʾ�� Graphics GTX1080
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// ��ɫ 0-255   �Ӱ�����
//		Color color = new Color(255,0,0);  // 	RGB red green blue  
////		g.setColor(color);
//		
//		
//		g.drawLine(100, 100, 500, 100);
//		// ����� 
//		Random ran = new Random();
//		
//		for (int i = 100; i < 400; i+=10) {
//			for (int j = 100; j < 400; j+=10) {
//				int wb = ran.nextInt(256);
//				// ��ɫ 0-255   �Ӱ�����
//				Color color = new Color(wb,wb,wb);  // 	RGB red green blue  
//				g.setColor(color);
//			// ����  ���Ͻ����� 	�� �� 
//				g.fillRect(i, j, 10, 10);
//			}
//		}
		
		int[][] imgdata =  getImagepix("img/hk.jpg");
		for (int i = 0; i < imgdata.length; i++) {
			for (int j = 0; j < imgdata[i].length; j++) {
				Color color = new Color(imgdata[i][j]);
				g.setColor(color);
				g.drawLine(i, j, i, j);
			}
		}
	}
	
	//ת��ͼƬ����  
	public int[][] getImagepix(String imagepath) {
		File file = new File(imagepath);
		// ���廭�� 
		BufferedImage buffimg = null;
		
		try {
			
			buffimg = ImageIO.read(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		int w = buffimg.getWidth();
		int h = buffimg.getHeight();
		
		int[][]  imagedata = new int[w][h];
		
		for (int i = 0; i < imagedata.length; i++) {
			for (int j = 0; j < imagedata[i].length; j++) {
				imagedata[i][j] = buffimg.getRGB(i, j);
			}
		}
		
		return imagedata;
		
	}
	
	

}
