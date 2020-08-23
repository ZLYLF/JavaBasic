import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class ImageBoard extends JFrame {
	public void initUI() {
		this.setSize(200, 400);
		this.setTitle("图像处理");
		this.setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);
//得到组成图片癿二维数组
		int[][] img = getImagePixel("lenna.jpg");
		for (int i = 0; i < img.length; i++) {
			for (int j = 0; j < img[i].length; j++) {
//得到颜色值，画出每一个点
				Color c = new Color(img[i][j]);
				g.setColor(c);
				g.fillOval(i, j, 1, 1);
			}
		}
	}

// 将一张图片转化成一个int型癿二维数组
// @param image 图片文件名
// @return 转化后癿二维数组
	public int[][] getImagePixel(String image) {
		File file = new File(image);
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
//得到图片像su癿宽和高
		int w = bi.getWidth();
		int h = bi.getHeight();
		int[][] imIndex = new int[w][h];
		System.out.println("w=" + w + " h=" + h);
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				int pixel = bi.getRGB(i, j); // i,j位置癿Color值
				imIndex[i][j] = pixel; // 每个像素点癿color存入数组
			}
		}
		return imIndex;
	}

	public static void main(String[] args) {
		ImageBoard lu = new ImageBoard();
		lu.initUI();
	}
}