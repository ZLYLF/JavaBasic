package com.zyf0801.drawimage;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Snippet {

	public void drawJJ(Graphics g) {
		int[][] ia = getImagePixel("tly.jpg");
		ia = valide(ia, kArray);
		// 在界面上画出ia数组图像，即卷积结果：
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
	
	public int[][] getImagePixel(String image) {
		BufferedImage bufferedImage = null;
		File file = new File(image);
		
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int w = bufferedImage.getWidth();
		int h  = bufferedImage.getHeight();
		int imageIndex[][] = new int [w][h];
		
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int rgb = bufferedImage.getRGB(i, j);
				imageIndex[i][j] = rgb;
//				System.out.print("  " + rgb);
			}
//			System.out.println();
		}
		
		return imageIndex;
	}
}
