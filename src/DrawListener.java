
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class DrawListener implements MouseListener, ActionListener {
	int x1, y1, x2, y2;
	Graphics g;
	String btnstr;

	public void actionPerformed(ActionEvent e) {
		btnstr = e.getActionCommand();

	}

	/**
	 * Invoked when the mouse button has been clicked (pressed and released) on a
	 * component.
	 */
	public void mouseClicked(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		System.out.println("鐐瑰嚮" + x + " =x  y=" + y);

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 */
	public void mousePressed(MouseEvent e) {

		x1 = e.getX();
		y1 = e.getY();

		System.out.println("鎸変笅" + x1 + " =x  y=" + y1);
	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 */
	public void mouseReleased(MouseEvent e) {

		x2 = e.getX();
		y2 = e.getY();
		// R G B 256 0 - 255
		// 涓変釜鍊� 鍚屾 杩戜技 榛戠櫧椋�

		Color color = new Color(100, 100, 100);

		g.setColor(color);
		// 璧风偣 缁堢偣
		if (btnstr.equals("鐩寸嚎")) {
			g.drawLine(x1, y1, x2, y2);
		}
		// 宸︿笂瑙掔殑鍧愭爣 w h
		if (btnstr.equals("鐭╁舰")) {
			g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
		}

		// 鍦嗗鍒囩煩褰㈢殑 宸︿笂瑙掔殑鍧愭爣 w h
		if (btnstr.equals("鍦嗗舰")) {
			g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2 - x1), Math.abs(y2 - y1));
		}

		if (btnstr.equals("璋㈠皵瀹炬柉鍩哄湴姣�")) {
			drawMyrect(3, 0, 0, 800, 500);
		}

		if (btnstr.equals("璋㈠皵瀹炬柉鍩轰笁瑙掑舰")) {
			drawMyrect1(400, 750, 50, 50, 750, 50, 3);
		} else if (btnstr.equals("分形")) {
			drawMyIfs(x1, y1);

		}
		System.out.println("閲婃斁" + x2 + " =x  y=" + y2);

	}

	void drawMyIfs(int mouseX, int mouseY) {

		double x = 0, y = 0;
		double a = -2, b = -2, c = -1.2, d = 2;
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);

		for (int i = 0; i < 20000; i++) {

			double tempx = Math.sin(a * y) - Math.cos(b * x);
			double tempy = Math.sin(c * x) - Math.cos(d * y);

			x = tempx;
			y = tempy;

			int px = (int) (tempx * 100 + mouseX);
			int py = (int) (tempy * 100 + mouseY);
			g.setColor(new Color(0, i%255, 0));
			g.drawLine(px, py, px, py);
			System.out.println(y + "=y x=" + x);
		}

	}

	public void drawIfsM() {
		Random ran=new Random();
		double a[] = { 0.1400, 0.4300, 0.4500, 0.4900 };
		double b[] = { 0.0100, 0.5200, -0.4900, 0.0000 };
		double c[] = { 0.0000, -0.4500, 0.4700, 0.0000 };
		double d[] = { 0.5100, 0.5000, 0.4700, 0.5100 };
		double e[] = { -0.0800, 1.4900, -1.6200, 0.0200 };
		double f[] = { -1.3100, -0.7500, -0.7400, 1.6200 };
		
		for(int i =0; i<5000; i++) {
			ran.nextInt(4);//0 1 2 3
			
			
		}
	
		

	}

	void drawMyrect(int n) {

		if (n < 0) {
			return;
		}

		n--;
		System.out.print("閫掑綊" + n);
		drawMyrect(n);
		drawMyrect(n);
	}

	// 璋㈠皵瀹炬柉鍩哄湴姣�
	public void drawMyrect(int n, int x, int y, int width, int height) {
		if (n < 0) {
			return;
		}

		// 浼戠湢 100ms 0.1s
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Random random = new Random();
		n--;
		int red = random.nextInt(256);
		int green = random.nextInt(256);
		int blue = random.nextInt(256);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
		Color color = new Color(red, green, blue);
		g.setColor(color);

		g.fillRect(x + width / 3, y + height / 3, width / 3, height / 3);
		System.out.println("閫掑綊" + n);

		drawMyrect(n, x, y, width / 3, height / 3);
		drawMyrect(n, x + width / 3, y, width / 3, height / 3);
		drawMyrect(n, x + 2 * (width / 3), y, width / 3, height / 3);

		drawMyrect(n, x, y + height / 3, width / 3, height / 3);
//		drawMyrect(n,x+width/3,y,width/3,height/3);
		drawMyrect(n, x + 2 * (width / 3), y + height / 3, width / 3, height / 3);

		drawMyrect(n, x, y + 2 * (height / 3), width / 3, height / 3);
		drawMyrect(n, x + width / 3, y + 2 * (height / 3), width / 3, height / 3);
		drawMyrect(n, x + 2 * (width / 3), y + 2 * (height / 3), width / 3, height / 3);
	}

	public void drawMyrect1(int x1, int y1, int x2, int y2, int x3, int y3, int m) {
		if (m > 0) {// 杩唬鏉′欢
			m--;
			g.drawLine(x1, y1, x2, y2);
			g.drawLine(x3, y3, x2, y2);
			g.drawLine(x1, y1, x3, y3);

			int x4 = (int) ((x1 + x3) / 2);
			int y4 = (int) ((y1 + y3) / 2);
			int x5 = (int) ((x1 + x2) / 2);
			int y5 = (int) ((y2 + y1) / 2);
			int x6 = (int) ((x3 + x2) / 2);
			int y6 = (int) ((y3 + y2) / 2);

			g.drawLine(x4, y4, x5, y5);
			g.drawLine(x6, y6, x5, y5);
			g.drawLine(x4, y4, x6, y6);

			// 杩唬
			drawMyrect1(x1, y1, x5, y5, x4, y4, m);
			drawMyrect1(x5, y5, x2, y2, x6, y6, m);
			drawMyrect1(x4, y4, x6, y6, x3, y3, m);
		}
	}

	/**
	 * Invoked when the mouse enters a component.
	 */
	public void mouseEntered(MouseEvent e) {
		System.out.println("杩涘叆");
	}

	/**
	 * Invoked when the mouse exits a component.
	 */
	public void mouseExited(MouseEvent e) {
		System.out.println("绂诲紑");
	}

}
