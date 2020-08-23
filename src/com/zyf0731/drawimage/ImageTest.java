package com.zyf0731.drawimage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageTest extends JFrame {

	public static void main(String[] args) {
		new ImageTest();
		
	}

	public ImageTest() {
		setSize(1000, 600);
		setDefaultCloseOperation(3);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		test(g);
	}

	public void test(Graphics g) {

		int[][] imgindex = getImagePixel("img/hk.jpg");
		float[][] kArray = { { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, 25, -1, -1 },
				{ -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 } };
		float[][] ka = { { -1, -1, -1 }, { -1, 9, -1 }, { -1, -1, -1 } };
		float[][] ka1= {{1,-1},{-1,1}};
		BufferedImage bi = new BufferedImage(imgindex.length, imgindex[0].length, BufferedImage.TYPE_INT_ARGB);

		int[][] newimgeindex = test1(imgindex, kArray);
		for (int i = 0; i < newimgeindex.length; i++) {
			for (int j = 0; j < newimgeindex[i].length; j++) {
				Color color = new Color(newimgeindex[i][j]);
				color.getBlue();
				color.getRed();
				color.getGreen();
				int c = (color.getBlue() + color.getRed() + color.getGreen()) / 3;
				bi.setRGB(i, j, color.getRGB());
			}
		}
		
		g.drawImage(bi, 0, 0, null);

	}

	public int[][] test1(int[][] src, float[][] imageh) {
		int imgindex[][] = new int[src.length][src[0].length];

		for (int i1 = 0; i1 < src.length - 5; i1++) {
			for (int j1 = 0; j1 < src[0].length - 5; j1++) {
				int countimg = 0;
				for (int i = 0; i < imageh.length; i++) {
					for (int j = 0; j < imageh[0].length; j++) {
						int srcindex = src[i1 + i][j1 + j];
//						int blue = (srcindex >> 0) & 0xFF;
//						int green = (srcindex >> 8) & 0xFF;
//						int red = (srcindex >> 16) & 0xFF;
						float imghindex = imageh[i][j];
//						int redCon = (int) (red * imghindex);
//						int greenCon = (int) (green * imghindex);
//						int blueCon = (int) (blue * imghindex);
//						
//							if(redCon<0)
//								redCon=Math.abs(redCon);
//							if(redCon>=255)
//								redCon=255;
//							if(greenCon<0)
//								greenCon=Math.abs(greenCon);
//							if(greenCon>255)
//								greenCon=255;
//							if(blueCon>255)
//								blueCon=255;
//							if(blueCon<0)
//								blueCon=Math.abs(blueCon);
							
//						int img =((0xFF << 24)|(redCon << 16)|(greenCon << 8)|blueCon);
////						int img =((redCon & 0xFF) << 16) | 
////								((greenCon & 0xFF) << 8) | 
////								((blueCon & 0xFF) << 0);
						int img = (int) (srcindex * imghindex);
						countimg += img;
					}
				}
				
//				if (countimg < 0) {
////					System.out.println("小  "+countimg);
//					countimg = 0;
//				} else if (countimg > 255) {
////					System.out.println(" 大 "+countimg);
//					countimg = 255;
//				}
//				System.out.println(" 正 "+countimg);
				imgindex[i1][j1] = countimg;
			}
		}
		return imgindex;

	}

	// 转化
	public int[][] getImagePixel(String imgstr) {
		BufferedImage bi = null;
		File file = new File(imgstr);

		try {
			bi = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		int w = bi.getWidth();
		int h = bi.getHeight();
		int[][] imgpix = new int[w][h];
//			int r=bi.getRGB(bi.getWidth(), bi.getHeight());
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int rgb = bi.getRGB(i, j);
				imgpix[i][j] = rgb;
//				System.out.print("r   "+rgb);
			}
//			System.out.println();
		}
		return imgpix;

	}

}
