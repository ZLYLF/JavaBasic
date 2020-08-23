package com.zyf0802.jsycode;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.Position.Bias;

public class ImageBoard extends JFrame{
	int[] flag = new int[]{1,0,0};
	String jpg = "img/by1.png";//文件路径
	double times = 1;
	int white = 0;
	
	public void initUI() {
		setTitle("Image");
		setSize(1200,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel jPanel=new JPanel();
		JButton jButton1=new JButton("复原");
		jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag[0]=1;
				flag[1]=0;
				flag[2]=0;
				times=1;
				white=0;
				repaint();
			}
		});
		JButton jButton2=new JButton("缩小");
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag[0]=0;
				flag[1]=1;
				flag[2]=0;
				times*=2;
				repaint();
			}
		});
		JButton jButton3=new JButton("放大");
		jButton3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				flag[0]=0;
				flag[1]=1;
				flag[2]=0;
				times=times/2;
				repaint();
			}
		});
		JButton jButton4=new JButton("美白");
		jButton4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				white+=30;
				repaint();
			}
		});
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		jPanel.add(jButton3);
		jPanel.add(jButton4);
//		jPanel.setLocation(1000, 300);
		add(jPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	/* (non-Javadoc)
	 * @see java.awt.Window#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		BufferedImage bImage = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics graphics = bImage.getGraphics();
		
		int imageindex[][] = getImagePixel(jpg);
		
		if(flag[0]==1) {
			for (int i = 0; i < imageindex.length; i++) {
				for (int j = 0; j < imageindex[i].length; j++) {
					int rgb = imageindex[i][j];
					
					Color color = new Color(rgb);
					int red = (color.getRed()+white)<255?color.getRed()+white:255;
					int green = (color.getGreen()+white)<255?color.getGreen()+white:255;
					int blue = (color.getBlue()+white)<255?color.getBlue()+white:255;
//					System.out.println("  "+rgb+"  " + red+"  " + green+"  " + blue);
					Color color2 = new Color(red,green,blue);
					graphics.setColor(color2);
					graphics.drawLine(i, j, i, j);
				}
			}
		}
		
		
		if(flag[1]==1) {
			int grade = 0;
			if(times>=1) {
				grade=(int)times;
			}else {
				grade=1;
			}
			for (int i = 0; i < imageindex.length; i+=grade) {
//				System.out.println(i);
				for (int j = 0; j < imageindex[i].length; j+=grade) {
//					System.out.println(i+ "        "+j);
					int rgb = imageindex[i][j];
					
					Color color = new Color(rgb);
					int red = (color.getRed()+white)<255?color.getRed()+white:255;
					int green = (color.getGreen()+white)<255?color.getGreen()+white:255;
					int blue = (color.getBlue()+white)<255?color.getBlue()+white:255;
//					System.out.println("  "+rgb+"  " + red+"  " + green+"  " + blue);
					Color color2 = new Color(red,green,blue);
					graphics.setColor(color2);
					graphics.drawLine((int)(i/times), (int)(j/times), (int)(i/times), (int)(j/times));
//					System.out.println((int)(i/times)+" "+(int)(j/times)+" "+ (int)(i/times)+" "+ (int)(j/times));
				}
			}
		}
		
		g.drawImage(bImage, 0, 0, null);
		
	}
	
	// 卷积 
	public void drawJJ(Graphics g) {
		int[][] ia = getImagePixel("imby.jpg");
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageBoard().initUI();
	}
}
