package com.zyf0801.drawimage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageBoard extends JFrame {

	public static void main(String[] args) {
		new ImageBoard().initUI();
	}

	public void initUI() {
		setTitle("图片");
		setSize(1200, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// 缓冲图片
		BufferedImage bi = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics bgr = bi.getGraphics();

		Random random = new Random();
		// 马赛克 瓷砖
//		for (int i = 0; i < this.getWidth(); i+=10) {
//			for (int j = 0; j < this.getHeight(); j+=10) {
//				int red = random.nextInt(256);
//				int green =random.nextInt(256);
//				int blue= random.nextInt(256);
//				
//				int bw = (red+green+blue)/3;
//				Color bwcolor = new Color(bw,bw,bw);// RGB  -  0-255  
//				Color color = new Color(red,green,blue);// RGB  -  0-255  
//									// 255  190  200
//				bgr.setColor(bwcolor);
//				bgr.fillOval(i, j, 10, 10);
//			}
//		}
		
		int imageindex[][] = getImagePixel("img/hk.jpg");
		
		for (int i = 0; i < imageindex.length; i++) {
			for (int j = 0; j < imageindex[i].length; j++) {
				int rgb = imageindex[i][j];
				
				Color color = new Color(rgb);
				int red = color.getRed();
				int green =color.getGreen();
				int blue= color.getBlue();
				int vc = (red+green+blue)/3;
				Color colort = new Color(vc,vc,vc);
				bgr.setColor(colort);
				bgr.drawLine(i, j, i, j);
			}
		}

		g.drawImage(bi, 0, 0, null);

	}

	// 将图片数据 读到数组中
	public int[][] getImagePixel(String image) {
		BufferedImage bi = null;
		File file = new File(image);

		try {
			bi = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int w = bi.getWidth();
		int h = bi.getHeight();
		int imgindex[][] = new int[w][h];

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int rgb = bi.getRGB(i, j);
				imgindex[i][j] = rgb;
				System.out.print("  " + rgb);
			}
			System.out.println();
		}
		return imgindex;

	}

}
