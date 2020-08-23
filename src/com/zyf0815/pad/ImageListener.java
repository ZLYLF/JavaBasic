package com.zyf0815.pad;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ImageListener implements ActionListener,MouseListener{
	String path;
	Graphics g;
	JFileChooser c_img;
	File img;
	int x1, y1, x2, y2;
	public final static int light=5;
	public final static int normal=10;
	public final static int heavy=40;
	public final static double [][] karry={{-1,-1,-1},{-1,9,-1},{-1,-1,-1}};
	public int [] [] fla={};
	public int shapeCount;
	Shape[] shapes = new Shape[50];
	
	
	// 
	public ImageListener(Graphics g) {
		this.g=g;
	}
	
	public void actionPerformed(ActionEvent e) {
		// 事件源对象  e 
		// 得到按钮上字符串
		String btnstr = e.getActionCommand();
//		e.get
		if(btnstr.equals("马赛克")) {
			
			paint(g,light);
			System.out.println("马赛克");
			
		}
		else if(btnstr.equals("导入")){
			c_img=new JFileChooser(new File("C:/Users/沭柘/Pictures"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			c_img.setFileFilter(filter);
			
			c_img.showOpenDialog(null);
			try{
			img=c_img.getSelectedFile();
			path=img.getPath();
			paint(g);}
			catch(Exception err){
				err.printStackTrace();
			}
		}
		else if(btnstr.equals("边缘处理")){
			paint(g,"6");
		}
		
	}
	
	public void paint(Graphics g) {
		
//		
//		g.drawLine(100, 100, 500, 100);
//		
//		
//		
//		g.setColor(Color.BLUE);
//		g.fillRect(100, 100, 150, 300);
//		
//		Color color = new Color(0,190,0,10);
//		g.setColor(color);
//		g.fillRect(100, 100, 300, 300);
		
		
		int[][] imagein = getImagePixel(path);
		
			for (int i = 0; i < imagein.length; i=i+1) {
				for (int j = 0; j < imagein[i].length; j=j+1) {
					int rgb = imagein[i][j];
					Color color1 = new Color(rgb);
					g.setColor(color1);
					g.drawLine(i, j, i, j);
//					Image img = new ImageIcon(p).getImage();
//					// 缓冲图片 
//					BufferedImage  buffimg = new BufferedImage(this., this.getHeight(), BufferedImage.TYPE_INT_ARGB);
//					Graphics   bg = buffimg.getGraphics();
//					bg.drawLine(100, 100, 500, 100);
//					bg.drawImage(img, 0, 0, null);
//					for (int i = 0; i < dl.shapes.length; i++) {
//						Shape shape =  dl.shapes[i];
//						if(shape!=null) {
//							shape.drawShape(bg);
//						}
//					}
//					
//					
//					
//					g.drawImage(buffimg, 0, 0, null);
//							
//				
				}
			}
		
	}
	
    public void paint(Graphics g,String type) {
		
//		
//		g.drawLine(100, 100, 500, 100);
//		
//		
//		
//		g.setColor(Color.BLUE);
//		g.fillRect(100, 100, 150, 300);
//		
//		Color color = new Color(0,190,0,10);
//		g.setColor(color);
//		g.fillRect(100, 100, 300, 300);
	    
		
		int[][] imagein = getImagePixel(path);
		int height=imagein[0].length;
		int [] [] fla=new int[imagein.length][height];
			for (int i = 0; i < imagein.length; i=i+1) {
				for (int j = 0; j < imagein[i].length; j=j+1) {
//					int rgb = imagein[i][j];
//					Color color1 = new Color(rgb);
//					g.setColor(color1);
//					g.drawLine(i, j, i, j);
					int count=0;
					for(int n=0;n<3;n++)
					{
						for(int m=0;m<3;m++)
						{
							if(i+m<imagein.length&&j+n<imagein[i].length){
							int imgdata=(int)(karry[m][n]*imagein[i+m][j+n]);
							count=count+imgdata;
							}
						}
					}		
					if(count>255 ){
						count=255;
					}
					if(count<0){
						count=0;
					}			
				   fla[i][j]=count;
				   
				}
			}
			for (int i = 0; i < fla.length; i=i+1) {
				for (int j = 0; j < fla[i].length; j=j+1) {
					int rgb = fla[i][j];
					Color color1 = new Color(rgb,rgb,rgb);
					g.setColor(color1);
					g.drawLine(i, j, i, j);
							
							
				
				}
			}
	}
	
    public void paint(Graphics g, int ma) {
		
//		
//		g.drawLine(100, 100, 500, 100);
//		
//		
//		
//		g.setColor(Color.BLUE);
//		g.fillRect(100, 100, 150, 300);
//		
//		Color color = new Color(0,190,0,10);
//		g.setColor(color);
//		g.fillRect(100, 100, 300, 300);
		
		
		int[][] imagein = getImagePixel(path);
		
			for (int i = 0; i < imagein.length; i=i+ma) {
				for (int j = 0; j < imagein[i].length; j=j+ma) {
					int rgb = imagein[i][j];
					Color color1 = new Color(rgb);
					for(int n=0;n<ma;n++)
					{
						for(int m=0;m<ma;m++)
						{
							g.setColor(color1);
							g.drawLine(i+m, j+n, i+m, j+n);
						}
					}
							
							
				
				}
			}
		
	}
	
	public static int[][] getImagePixel(String image) {
		// 缓冲图片 
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
			}
		}
		return imgindex;

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		
		// 练习  --  
			
		
		
		
		
		drawMyRect(0, 0, 600, 600,3);
		
		
		
		
		System.out.println("点击  -- "+x+"=x  y="+y);
	}
	
	public void drawMyRect(int x, int y,int width,int height,int count) {
		if(count<0) {
			return;
		}
		count--;
//		g.drawRect(x, y, width, height);
		g.fillRect(x+width/3, y+height/3, width/3, height/3);// 九宫格的中间 
		drawMyRect(x, y, width/3, height/3,count);
		
		drawMyRect(x+width/3, y, width/3, height/3,count);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x1 = e.getX();
		 y1 = e.getY();
		System.out.println("按下--");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		x2 = e.getX();
		 y2 = e.getY();
		 
		 Shape shape = new Shape(x1, y1, x2, y2, Color.BLUE, "直线");
		 shape.drawShape(g);
		 
		 shapes[shapeCount] = shape;
		 shapeCount++;
		 
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("进入");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("离开");
	}
}
