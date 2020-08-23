package com.zyf0815.pad;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePad extends JPanel{
	
	public static void main(String[] args) {
		ImagePad imagePad = new ImagePad();
		imagePad.initUI();
	}
	ImageListener imgListener;
	public void initUI() {
		JFrame jf = new JFrame();
		jf.setSize(1000,700);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);// ������ʾ
		// ������� 
		JPanel drawPanel = new JPanel();
		drawPanel.setBackground(Color.white);
		
		// �������
		JPanel jp_W = new JPanel();
		jp_W.setBackground(Color.DARK_GRAY);
		Dimension dim = new Dimension(100,100);
		jp_W.setPreferredSize(dim);// ���������óߴ�
		
		JButton InputImg=new JButton("����");
		jp_W.add(InputImg);
		JButton btn = new JButton("������");
		jp_W.add(btn);
		JButton border_edit=new JButton("��Ե����");
		jp_W.add(border_edit);
		
		//��������� 
		jf.add(jp_W,BorderLayout.WEST);
		jf.add(drawPanel,BorderLayout.CENTER);
		jf.setVisible(true);
		
		// ��ȡ���ƹ��߶��� 
		Graphics g = drawPanel.getGraphics();
		// ��Ӽ�����
//		load loadListener=new load(jp_W);
		imgListener = new ImageListener(g);
		
		
		// ��ť��Ӷ���������
		btn.addActionListener(imgListener);
		InputImg.addActionListener(imgListener);
		border_edit.addActionListener(imgListener);
		// �������������� 
		drawPanel.addMouseListener(imgListener);
		
		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
//		Image img = new ImageIcon("img/hk.jpg").getImage();
		
		// ����ͼƬ 
		BufferedImage  buffimg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics   bg = buffimg.getGraphics();
		
		bg.drawLine(100, 100, 500, 100);
//		bg.drawImage(img, 0, 0, null);	
		
		// ���� ������ɫ 
//		buffimg.setRGB(i, j, rgb); 
		
		for (int i = 0; i < imgListener.shapes.length; i++) {
			Shape shape =  imgListener.shapes[i];
			
			System.out.println("shape=="+shape);
			if(shape!=null) {
				shape.drawShape(bg);
			}
		}
		
		g.drawImage(buffimg, 0, 0, null);
	}
	
	
	
	
	
	
	

}
