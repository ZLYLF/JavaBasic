import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageBoard extends JFrame {
	public void initUI() {
		this.setSize(200, 400);
		this.setTitle("ͼ����");
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
//�õ����ͼƬ�m��ά����
		int[][] img = getImagePixel("lenna.jpg");
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img[i].length; j++) {
//�õ���ɫֵ������ÿһ����
				Color c = new Color(img[i][j]);
				g.setColor(c);
				g.fillOval(i, j, 1, 1);
			}
		}
	}

// ��һ��ͼƬת����һ��int�Ͱm��ά����
// @param image ͼƬ�ļ���
// @return ת����m��ά����
	public int[][] getImagePixel(String image) {
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
//�õ�ͼƬ��su�m��͸�
		int w = bi.getWidth();
		int h = bi.getHeight();
		int[][] imIndex = new int[w][h];
		System.out.println("w=" + w + " h=" + h);
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int pixel = bi.getRGB(i, j); // i,jλ�ðmColorֵ
				imIndex[i][j] = pixel; // ÿ�����ص�mcolor��������
			}
		}
		return imIndex;
	}

	public static void main(String[] args) {
		ImageBoard lu = new ImageBoard();
		lu.initUI();
	}
}