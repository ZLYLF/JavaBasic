package com.zyf0715.imagec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.RGBImageFilter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class RGBFilter extends JFrame implements ChangeListener {
    //��ȡԴͼƬͼ�����
    //private ImageIcon icon =null;
    ImageIcon ii = null;
     //������ʾԴͼ��ı�ǩ����������ڹ���������
    JLabel jls = new JLabel();
    JScrollPane jspz = new JScrollPane(jls);
    //������ʾĿ��ͼ��ı�ǩ����������ڹ���������
    JLabel jlt = new JLabel();
    JScrollPane jspy = new JScrollPane(jlt);
    //�����ָ�񣬲����ø��Ӵ�������ʾ�Ŀؼ�
    JSplitPane jsp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);
    //������ʾͨ���ı�ǩ����
    JLabel[] jl = {new JLabel("��ɫ"),
                           new JLabel("��ɫ"),
                           new JLabel("��ɫ")
    };
    //���������������Ƹ�ͨ����ɫ�����Ļ���
    JSlider[] js = {new JSlider(-255,255),
                             new JSlider(-255,255),
                             new JSlider(-255,255)
    };
    //����һ�����
    JPanel jp = new JPanel();
    //�����Զ���Ĺ���������
    MyColorFilter mcf = new MyColorFilter(js[0].getValue(), js[1].getValue(), js[2].getValue());

    public BufferedImage getBuf(){
        int width = ii.getImage().getWidth(null);
        int height = ii.getImage().getHeight(null);
        BufferedImage targetBuf1 = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //��ȡ��ʾԴͼ���BufferedImage����Ļ���
        Graphics g = targetBuf1.getGraphics();
        //���������ͼ����Ƶ�Դͼ���BufferedImage������
        g.drawImage(ii.getImage(), 0, 0, Color.white,null);
        return targetBuf1;

    }

    //������
    public RGBFilter(ImageIcon icon){

        jls.setIcon(icon);
        jls.setVerticalAlignment(JLabel.CENTER);
        jls.setHorizontalAlignment(JLabel.CENTER);
        jlt.setVerticalAlignment(JLabel.CENTER);
        jlt.setHorizontalAlignment(JLabel.CENTER);
        //��������ͼƬ���õ�Ŀ���ǩ��
         ii = icon;
        jlt.setIcon(ii);
        jsp.setDividerLocation(500);
        jsp.setDividerSize(4);
        this.add(jsp, BorderLayout.CENTER);
        //����ǩ�Լ�������ӵ�����У���Ϊ����ע�������
        for (int i = 0; i < js.length; i++){
            jp.add(jl[i]);
            jp.add(js[i]);
            js[i].addChangeListener(this);
    }
        //�������ӽ�����
        this.add(jp,BorderLayout.SOUTH);
        //���ô���ı��⣬��С��λ���Լ��ɼ���
        this.setTitle("RGB�˲�");
        this.setBounds(300,300,1000,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        //��������������ֵ
        mcf.setRGBValue(js[0].getValue(),js[1].getValue(),js[2].getValue());
        //��ȡ���˺��ͼ����ʾ��Ŀ���ǩ��
        Image tempImg = createImage(new FilteredImageSource(ii.getImage().getSource(),mcf));
        jlt.setIcon(new ImageIcon(tempImg));
    }   

    }

//�Զ����RGBɫ��ͨ����������
        class MyColorFilter extends RGBImageFilter{
            //RGBɫ��ͨ�����Եĵ���ֵ
            int rc,gc,bc;
            public MyColorFilter(int rc, int gc, int bc){
                this.rc = rc;
                this.gc = gc;
                this.bc = bc;
            }

            //���ø���ɫ��ͨ���ĵ���ֵ
            public void setRGBValue(int rc, int gc, int bc){
                this.rc = rc;
                this.gc = gc;
                this.bc = bc;
            }

            @Override
            public int filterRGB(int x, int y, int rgb) {
                // TODO Auto-generated method stub
                //ȡ����ɫͨ���е���ֵ
                int tempRed = (rgb&0x00ff0000) >> 16;
                //�Ժ�ɫͨ��ֵ���д���
                tempRed += rc;
                //�жϴ�������ֵ�Ƿ�Խλ
                tempRed = (tempRed < 255) ? ((tempRed > 0) ? tempRed : 0) : 255;
                //��������ֵ�ƻ�ָ��λ
                tempRed = tempRed << 16;

                //ȡ����ɫͨ���е���ֵ
                int tempGreen = (rgb&0x0000ff00) >> 8;
                //����ɫͨ��ֵ���д���
                tempGreen += gc;
                //�жϴ�������ֵ�Ƿ�Խλ
                tempGreen = (tempGreen < 255) ? ((tempGreen > 0) ? tempGreen : 0) : 255;
                //��������ֵ�ƻ�ָ��λ
                tempGreen = tempGreen << 8;

                //ȡ����ɫͨ���е���ֵ
                int tempBlue = (rgb&0x000000ff);
                //����ɫͨ��ֵ���д���
                tempBlue += bc;
                //�жϴ�������ֵ�Ƿ�Խλ
                tempBlue = (tempBlue < 255) ? ((tempBlue > 0) ? tempBlue : 0) : 255;
                //���죬�̣�����ɫͨ����ֵ����ɫ�����и�8λ��������͸���ȵ�ֵ���а�λ�����㲢����
                return (rgb&0xff000000) | tempRed |tempGreen | tempBlue;
            }

}