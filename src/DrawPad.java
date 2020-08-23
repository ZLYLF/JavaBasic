
import javax.swing.*;
import java.awt.*;

public class DrawPad {
	// ������
	public static void main(String[] args) {
		DrawPad drawPad = new DrawPad();
		drawPad.initUI();
	}

	// ��ʼ������
	public void initUI() {
		// ʵ�����������
		JFrame drawFrame = new JFrame();
		drawFrame.setSize(800, 600);
		drawFrame.setLocationRelativeTo(null);// ����
		drawFrame.setTitle("��ͼ��");
		drawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �رմ���ʱ�˳�����
		drawFrame.setResizable(true);// �����Ƿ���Ըı��С

		
		// ��ʽ������  // ������ӵ�˳��  �������ң��������� ����  
		FlowLayout fl = new FlowLayout();
		drawFrame.setLayout(fl); 
		
		//��Ӱ�ť
		JButton LineBtn = new JButton("ֱ��");
		JButton RectBtn = new JButton("����");
		JButton OvalBtn = new JButton("Բ��");
		JButton MyRectBtn = new JButton("л����˹����̺");
		JButton MyRectBtn1 = new JButton("л����˹��������");
		JButton ifsbtn1 = new JButton("����");
		
		//���óߴ�
		LineBtn.setBackground(Color.white);
		RectBtn.setBackground(Color.white);
		OvalBtn.setBackground(Color.white);
		MyRectBtn.setBackground(Color.white);
		MyRectBtn1.setBackground(Color.white);
		
		//���ص�����
		drawFrame.add(LineBtn);
		drawFrame.add(RectBtn);
		drawFrame.add(OvalBtn);
		drawFrame.add(MyRectBtn);
		drawFrame.add(MyRectBtn1);
		drawFrame.add(ifsbtn1);
		
		drawFrame.setVisible(true);// ���ӻ�
		
		
		
		// for (int i = 0; i < 10000; i++) {
		// System.out.println("hello");
		// }

		Graphics g = drawFrame.getGraphics();
		System.out.println("g=" + g);

		// ʵ�ľ���
		// g.fillRect(100, 100, 300, 300);

		// ʵ���� �������� DrawListener �Ķ���
		DrawListener dl = new DrawListener();
		// ������ע����������
		drawFrame.addMouseListener(dl);

		// ��ť���ؼ�������
		LineBtn.addActionListener(dl);
		RectBtn.addActionListener(dl);
		OvalBtn.addActionListener(dl);
		MyRectBtn.addActionListener(dl);
		MyRectBtn1.addActionListener(dl);
		ifsbtn1.addActionListener(dl);
		dl.g = g;// ���ݵ�����������


	}

}
