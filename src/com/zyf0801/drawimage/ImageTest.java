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
		
		test(g, "��",rgbOfImg.length, rgbOfImg[0].length, rgbOfImg);
//		g.drawImage(new ImageIcon("img/hk.jpg").getImage(), 0, 0, null);
	}
	
	
	public void test(Graphics graphics,String text,int width,int height,int[][] rgbOfImg) {
		int[][] R ,G ,B;
		int size=3;
		//���ڲ�ͬ�Ĺ������ò�ͬ��С�ľ���
//		if(text.equals("��")){size = 5;}	
		//�񻯾����
		double[][] sharpening = {{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
//		float[][] sharpening = { { -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 }, { -1, -1, 25, -1, -1 },
//				{ -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1 } };
		//���濪ʼ�����㷨
		//��ʼ��rgb����
		R = new int[size][size];
		G = new int[size][size];
		B = new int[size][size];
		//��Ӧ3*3�����ظ��ӽ��о������
		for(int x = 0;x < width-size+1;x++){
			for(int y = 0;y < height-size+1;y++){
			//��������ֵ�ֱ�洢r,g,b������ֵ��һ��Ҫ��ѭ���ڲ����г�ʼ��0����������ÿ���в�ͬ��ֵ
				int resultOfR = 0;
				int resultOfG = 0;
				int resultOfB = 0;
				//�����ӵ�rgbֵ��ȡ��������֮��ľ������
				for(int j = 0;j <size;j++){
					for(int i = 0;i < size;i++){
						//���õ��RGB��Ϣȡ�����ŵ������д�����
						int argb = rgbOfImg[x][y];
						//�ֶλ�ȡ��R,G,B��Ϣ
						//int������4λ32�ֽڣ�0λ��Ӧ͸����(A)��1λ��ӦRֵ��2λ��ӦGֵ��3λ��ӦBֵ
						//>>����:�������ƴ��������ƶ�����߿�λ���ݷ��Ų��䣬����Ϊ0������Ϊ1���ұ߳�����Χ��ȫ������
						//&:������λ���������ֻ������������Ӧֵ��Ϊ1ʱ��λ�ŷ���1��0xff��ʾȫΪ1��ʮ��������(11111111),����κ���0xff����λ��Ľ����Ϊ�䱾��
						//����λ��ȡλ����Խ���ֵͬ��Ӧ��λ��Ϣȡ��,λ���������ֻȡ32�ֽڵĺ�8�ֽ�
						R[i][j] = argb>>16 & 0xff;
						G[i][j] = argb>>8  & 0xff;
						B[i][j] = argb     & 0xff;
					}
				}
				if(text.equals("��")){
					//�ֱ��R,G,B���о����������Ӧ��˺������
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
				//���������rgb�Ľ��ޣ�0-255�������䰴�����ֵ����Сֵ����
				if(resultOfR > 255)resultOfR = 255;
				if(resultOfR < 0)resultOfR = 0;
				if(resultOfG > 255)resultOfG = 255;
				if(resultOfG < 0)resultOfG = 0;
				if(resultOfB > 255)resultOfB = 255;
				if(resultOfB < 0)resultOfB = 0;
				//���ݸ�rgbֵ������ɫ����
				Color color = new Color(resultOfR, resultOfG, resultOfB);
				//������ɫ������graphics��ͼ��Ļ�������BufferedImage����Graphics�ࣩ
				graphics.setColor(color);
				//�����ص㣨drawline�������ߣ��������ʼ���յ㶼��ͬһ�㣬��˿������������ص㣩
				//size/2���������ص㸳������Ԫ��
				graphics.drawLine(x+size/2, y+size/2, x+size/2, y+size/2);
				}
		}

	}
	
	// ��ͼƬ���� ����������
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
