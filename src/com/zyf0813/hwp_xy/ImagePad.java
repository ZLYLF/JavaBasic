package com.zyf0813.hwp_xy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
// �̳д��� 
public class ImagePad extends JFrame{
	// ������ �������
	public static void main(String[] args) {
		new ImagePad();
	}
	
	public ImagePad() {
		setTitle("������");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);// ���ӻ� 
	}
	
	// ���� 
	public void paint(Graphics g) {
		super.paint(g);
		
		// Graphics  ͼ�� 	�Կ�  --  ��Ļӳ�� 	 g  ���������� -- ����/��
			
		Color color1 = new Color(255,255,255);// ��ԭɫ  R G B 0-255
//		g.setColor(color);
//		g.drawLine(100, 100, 500, 100);
		
		int[][] imgindex = getImagePix("img/hk.jpg");
		// ����ȡ�������е���ɫֵ ���� 
		for (int i = 0; i < imgindex.length; i++) {
			for (int j = 0; j < imgindex[0].length; j++) {
				// ȡ����ɫ 
				int rgb = imgindex[i][j];
				Color color = new Color(rgb);
				// ȡ�� rgb ������  
				int red = color.getRed();
				int green = color.getGreen();
				int blue =color.getBlue();
				
				// �Ҷ�ͼ
				int wb = (red + green + blue)/3; 
				Color newcolor = new Color(wb,wb,wb); // ֻҪ����ֵ һ���Ϳ���û����ɫ ֻҪ�ڰ׻� 
				g.setColor(color);
//				g.drawLine(i, j, i, j);
				
				// ����  ����    �� �� 
//				g.fillRect(i, j, 3, 3);
				g.fillOval(i, j, 1, 1);
			}
		}
		
	}
	// ��ͼƬת��������  
	public int[][] getImagePix(String imagepath) {
		// �ļ��� 
		File file = new File(imagepath);
		// ����ͼƬ
		BufferedImage buffimg = null;
		
		try {
			buffimg = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int w = buffimg.getWidth();
		int h = buffimg.getHeight();
		// �����洢ͼƬ����ֵ ������ 
		int[][] imgIndex = new int[w][h];
		
		// ����ͼƬ ȡ����ɫֵ �������� 
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				imgIndex[i][j] = buffimg.getRGB(i, j);
			}
			
		}
		
		return imgIndex;
		
	}
	
	
	

}
