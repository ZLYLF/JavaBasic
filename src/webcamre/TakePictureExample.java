package webcamre;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;

import com.github.sarxos.webcam.Webcam;


/**	
 * 
 * Example of how to take single picture.
 * @author Bartosz Firyn (SarXos) 
 * 
 * 
 */



public class TakePictureExample extends JFrame{
	// get default webcam and open it
	Webcam webcam = Webcam.getDefault();
	BufferedImage image;	
	
	public TakePictureExample() {
		webcam.open();
		image = webcam.getImage();
	}

	public static void main(String[] args) throws IOException {
		new TakePictureExample().initUI();
	}
	
	public void initUI() throws IOException {
		//JFrame jf = new JFrame();
		setDefaultCloseOperation(3);
		setSize(1000,800);
		setLayout(new FlowLayout());
	JButton btn= new JButton("≈ƒ’’");
	btn.addActionListener(new ActionListener() {
		int n=0;
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					ImageIO.write(image, "PNG", new File("img/test"+n+".png"));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		add(btn);
		setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		// get image
//		while(true) {
			 image = webcam.getImage();
			 g.drawImage(image, 100, 100,720,480, null);
//		}
		
	}
}