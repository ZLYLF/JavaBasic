
import javax.swing.*;
import java.awt.*;

public class DrawPad {
	// 主函数
	public static void main(String[] args) {
		DrawPad drawPad = new DrawPad();
		drawPad.initUI();
	}

	// 初始化界面
	public void initUI() {
		// 实例化窗体对象
		JFrame drawFrame = new JFrame();
		drawFrame.setSize(800, 600);
		drawFrame.setLocationRelativeTo(null);// 居中
		drawFrame.setTitle("画图板");
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 关闭窗体时退出程序
		drawFrame.setResizable(true);// 设置是否可以改变大小

		
		// 流式布局器  // 根据添加的顺序  从左至右，从上至下 居中  
		FlowLayout fl = new FlowLayout();
		drawFrame.setLayout(fl); 
		
		//添加按钮
		JButton LineBtn = new JButton("直线");
		JButton RectBtn = new JButton("矩形");
		JButton OvalBtn = new JButton("圆形");
		JButton MyRectBtn = new JButton("谢尔宾斯基地毯");
		JButton MyRectBtn1 = new JButton("谢尔宾斯基三角形");
		JButton ifsbtn1 = new JButton("分形");
		
		//设置尺寸
		LineBtn.setBackground(Color.white);
		RectBtn.setBackground(Color.white);
		OvalBtn.setBackground(Color.white);
		MyRectBtn.setBackground(Color.white);
		MyRectBtn1.setBackground(Color.white);
		
		//加载到容器
		drawFrame.add(LineBtn);
		drawFrame.add(RectBtn);
		drawFrame.add(OvalBtn);
		drawFrame.add(MyRectBtn);
		drawFrame.add(MyRectBtn1);
		drawFrame.add(ifsbtn1);
		
		drawFrame.setVisible(true);// 可视化
		
		
		
		// for (int i = 0; i < 10000; i++) {
		// System.out.println("hello");
		// }

		Graphics g = drawFrame.getGraphics();
		System.out.println("g=" + g);

		// 实心矩形
		// g.fillRect(100, 100, 300, 300);

		// 实例化 鼠标监听类 DrawListener 的对象
		DrawListener dl = new DrawListener();
		// 给界面注册鼠标监听器
		drawFrame.addMouseListener(dl);

		// 按钮加载监听机制
		LineBtn.addActionListener(dl);
		RectBtn.addActionListener(dl);
		OvalBtn.addActionListener(dl);
		MyRectBtn.addActionListener(dl);
		MyRectBtn1.addActionListener(dl);
		ifsbtn1.addActionListener(dl);
		dl.g = g;// 传递到监听对象中


	}

}
