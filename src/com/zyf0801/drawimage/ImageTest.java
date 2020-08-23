package com.zyf0801.drawimage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ImageTest extends JFrame{
	
	public static void main(String[] args) {
		new ImageTest();
	}
	public ImageTest() {
		
		setSize(1000,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int[][]  rgbOfImg=getImagePixel("img/rh.png");
		
		test(g, "锐化",rgbOfImg.length, rgbOfImg[0].length, rgbOfImg);
//		g.drawImage(new ImageIcon("img/hk.jpg").getImage(), 0, 0, null);
	}
	
	
	public void test(Graphics graphics,String text,int width,int height,int[][] rgbOfImg) {
		int[][] R ,G ,B;
		int size=3;
		//对于不同的功能设置不同大小的矩阵
//		if(text.equals("锐化")){size = 5;}	
		//锐化卷积核
		double[][] sharpening = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
//		float[][] sharpening = { { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, 25, -1, -1 },
//				{ -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 } };
		//下面开始搞卷积算法
		//初始化rgb数组
		R = new int[size][size];
		G = new int[size][size];
		B = new int[size][size];
		//对应3*3的像素格子进行卷积计算
		for(int x = 0;x < width-size+1;x++){
			for(int y = 0;y < height-size+1;y++){
			//设置三个值分别存储r,g,b的特征值，一定要在循环内部进行初始化0，这样才能每次有不同的值
				int resultOfR = 0;
				int resultOfG = 0;
				int resultOfB = 0;
				//将格子的rgb值都取出，便于之后的卷积操作
				for(int j = 0;j <size;j++){
					for(int i = 0;i < size;i++){
						//将该点的RGB信息取出，放到变量中待操作
						int argb = rgbOfImg[x][y];
						//分段获取其R,G,B信息
						//int变量共4位32字节，0位对应透明度(A)，1位对应R值，2位对应G值，3位对应B值
						//>>操作:将二进制代码向右移动，左边空位根据符号补充，正号为0，负号为1，右边超过范围的全部舍弃
						//&:二进制位与运算符，只有两个变量对应值均为1时该位才返回1，0xff表示全为1的十六进制数(11111111),因此任何与0xff进行位与的结果均为其本身
						//先移位后取位与可以将不同值对应的位信息取出,位与的意义是只取32字节的后8字节
						R[i][j] = argb>>16 & 0xff;
						G[i][j] = argb>>8  & 0xff;
						B[i][j] = argb     & 0xff;
					}
				}
				if(text.equals("锐化")){
					//分别对R,G,B进行卷积操作，对应相乘后加起来
					for(int j = 0;j < size;j++){
						for(int i = 0;i < size;i++){
							resultOfR += (int)(sharpening[i][j]*R[i][j]);
						}	
					}
					for(int i = 0;i < size;i++){
						for(int j = 0;j < size;j++){
							resultOfG += (int)(sharpening[i][j]*G[i][j]);
		
						}
					}				
					for(int i = 0;i < size;i++){
						for(int j = 0;j < size;j++){
							resultOfB += (int)(sharpening[i][j]*B[i][j]);
						}
					}
				}
				//如果超过了rgb的界限（0-255），将其按照最大值或最小值处理
				if(resultOfR > 255)resultOfR = 255;
				if(resultOfR < 0)resultOfR = 0;
				if(resultOfG > 255)resultOfG = 255;
				if(resultOfG < 0)resultOfG = 0;
				if(resultOfB > 255)resultOfB = 255;
				if(resultOfB < 0)resultOfB = 0;
				//根据该rgb值创建颜色对象
				Color color = new Color(resultOfR, resultOfG, resultOfB);
				//设置颜色，其中graphics是图像的画布（见BufferedImage类与Graphics类）
				graphics.setColor(color);
				//画像素点（drawline用来画线，这里的起始与终点都是同一点，因此可以用来画像素点）
				//size/2用来将像素点赋到中心元上
				graphics.drawLine(x+size/2, y+size/2, x+size/2, y+size/2);
				}
		}

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
