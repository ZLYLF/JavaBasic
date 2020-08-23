package com.zyf0731.drawimage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageBoard extends JFrame {
	public void initUI() {
		this.setSize(1100, 700);
		this.setTitle("图像处理");
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}

//重写界面癿绘制方法
	public void paint(Graphics g) {
		super.paint(g);
		
		drawJJ(g);
//		g.drawImage(drawBy(g),0, 30	,this);
//		drawBy(g);
	}
	
	// 马赛克瓷砖
	public  void drawM(Graphics g) {
		Random ran = new Random();
		for (int i = 0; i < this.getWidth(); i++) {
			for (int j = 0; j < this.getHeight(); j++) {
				int ic = ran.nextInt(255);
				Color color = new Color(ic, ic, 0);
				g.setColor(color);
				g.fillOval(i, j, 2, 2);
			}
		}
	}
	
	// 边缘处理
	public BufferedImage drawBy(Graphics g) {
		
		int imgindex[][] = getImagePixel("img/gai.jpg");
		BufferedImage bi=new BufferedImage(imgindex.length, imgindex[0].length, BufferedImage.TYPE_INT_ARGB);
		for (int i = 0; i < imgindex.length-3; i+=10){
			for (int j = 0; j < imgindex[i].length-3; j+=10) {
				
				Color color = new Color(imgindex[i][j]);
				int red = color.getRed();
				int blue = color.getBlue();
				int green = color.getGreen();
				
//				Color color1 = new Color(imgindex[i+3][j]);
//				int red1 = color1.getRed();
//				int blue1 = color1.getBlue();
//				int green1 = color1.getGreen();
//				
//				int cl1=(red1+blue1+green1)/3;
//				int cl=(red+blue+green)/3;
//				
//				if(Math.abs(cl-cl1)>10) {
//				if(cl>10){
//					int bw=(red+blue+green)/3;
////					Color colorCt = new Color(bw,bw,bw);
//					Color colorCt = new Color(red,green,blue);
////					g.setColor(colorCt);
////					g.fillRect(i, j, 3, 3);
////					g.drawLine(i, j, i, j);
//					bi.setRGB(i, j, colorCt.getRGB());
//				}
//				}else {
//					g.setColor(new Color(0,0,0,150));
//					g.drawLine(i, j, i, j);
//					bi.setRGB(i, j, color.getRGB());
				g.setColor(color);
				g.fillRect(i, j, 10, 10);
//			
			}		
			}
		return bi;
	}
	
	// 卷积 
	public void drawJJ(Graphics g) {
		int[][] ia = getImagePixel("img/by.jpg");
		ia = valide(ia, kArray);
		// 在界面上画出ia数组图像，即卷积结果：
		
		for (int i = 0; i < ia.length; i++){
			for (int j = 0; j < ia[i].length; j++) {
				Color color = new Color(ia[i][j]);
				int red = color.getRed();
				int blue = color.getBlue();
				int green = color.getGreen();
				
				Color rgb = new Color(red,blue,green);
				g.setColor(rgb);
				g.drawLine(i, j, i, j);
			}
		}
	}

	// 卷积核癿二维数组：边缘化
	float[][] kArray = { { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, 25, -1, -1 }, { -1, -1, -1, -1, -1 },
			{ -1, -1, -1, -1, -1 } };

	/**
	 * 卷积计算
	 * 
	 * @param src    :图片数组
	 * @param filter :卷积核数组
	 * @return 计算后癿数组
	 */
	public static int[][] valide(int[][] src, float[][] filter) {
		int[][] tem = new int[filter.length][filter[0].length];
		int valideWidth = src[0].length - filter[0].length + 1;
		int valideheight = src.length - filter.length + 1;
		int[][] valide = new int[valideheight][valideWidth];
		
		for (int i = 0; i < valideheight; i += 1) {
			for (int j = 0; j < valideWidth; j += 1) {
				for (int y = 0; y < filter.length; y++) {
					for (int z = 0; z < filter[0].length; z++) {
						tem[y][z] = (int) ((src[i + y][j + z]) * (filter[y][z]));
					}
				}
				int kk = 0;
				for (int y = 0; y < filter.length; y++) {
					for (int z = 0; z < filter[0].length; z++) {
						kk += tem[y][z];
					}
				}
				if (kk < 0)
					kk = 0;
				if (kk > 255)
					kk = 255;
				valide[i][j] = (byte) kk;
			}
		}
		return valide;
	}
	
	// 转化
	public int[][] getImagePixel(String imgstr) {
		BufferedImage bi=null;
		File file = new File(imgstr);
		
		try {
			 bi=ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int w= bi.getWidth();
		int h=bi.getHeight();
		int[][] imgpix = new int[w][h];
//		int r=bi.getRGB(bi.getWidth(), bi.getHeight());
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int rgb=bi.getRGB(i, j);
				imgpix[i][j]=rgb;
			}
		}
		return imgpix;
		
	}

	public static void main(String[] args) {
		ImageBoard lu = new ImageBoard();
		lu.initUI();
	}
}