package com.zyf0715.imagec;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class GrayProcessing extends JFrame {
    public int width;
    public int height;
    private ImageIcon ii = null;

     //������ʾԴͼ��ı�ǩ����������ڹ���������
    JLabel jls = new JLabel();
    JScrollPane jspz = new JScrollPane(jls);
    //������ʾĿ��ͼ��ı�ǩ����������ڹ���������
    JLabel jlt = new JLabel();
    JScrollPane jspy = new JScrollPane(jlt);
    //�����ָ�񣬲����ø��Ӵ�������ʾ�Ŀؼ�
    JSplitPane jsp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);

    public BufferedImage getBuf(){
        BufferedImage targetBuf1 = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //��ȡ��ʾԴͼ���BufferedImage����Ļ���
        Graphics g = targetBuf1.getGraphics();
        //���������ͼ����Ƶ�Դͼ���BufferedImage������
        g.drawImage(ii.getImage(), 0, 0, Color.white,null);
        return targetBuf1;

    }

    //������
    public GrayProcessing(ImageIcon icon){
        ii = icon;
        //��ͼƬ���õ�Դ��ǩ��
        jls.setIcon(ii);
        //����Դͼ���ǩ��ˮƽ����ֱ���뷽ʽΪ����
        jls.setVerticalAlignment(JLabel.CENTER);
        jls.setHorizontalAlignment(JLabel.CENTER);
        //����Ŀ��ͼ���ǩ��ˮƽ����ֱ���뷽ʽΪ����
        jlt.setVerticalAlignment(JLabel.CENTER);
        jlt.setHorizontalAlignment(JLabel.CENTER);
        //��ȡ������ͼ���Ӧ��ͼ��
        ii =this.processGrayImage(ii.getImage());
        //��������ͼƬ���õ�Ŀ���ǩ��
        jlt.setIcon(ii);
        //���÷ָ����ĳ�ʼλ��
        jsp.setDividerLocation(350);
        //���÷ָ����Ŀ��
        jsp.setDividerSize(4);
        //���ָ�����ӵ�����
        this.add(jsp);
        //���ô���ı��⣬��С��λ���Լ��ɼ���
        this.setTitle("�Ҷȴ�����");
        this.setBounds(450,350,700,500);
        this.setVisible(true);
        //���ô���رն���
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //��ͼƬ���лҶȴ���ķ���
        public ImageIcon processGrayImage (Image source){
            //��ȡͼ��Ŀ�Ⱥ͸߶�
            width = source.getWidth(null);
            height = source.getHeight(null);
            //������ʾԴͼ���BufferedImage����
            BufferedImage sourceBuf = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            //������ʾ�����Ŀ��ͼ���BufferedImage����
            BufferedImage targetBuf = new BufferedImage(width,height,BufferedImage.TYPE_USHORT_GRAY);
            //��ȡ��ʾԴͼ���BufferedImage����Ļ���
            Graphics g = sourceBuf.getGraphics();
            //���������ͼ����Ƶ�Դͼ���BufferedImage������
            g.drawImage(source, 0, 0, Color.white,null);
            //�����������лҶȴ����ColorConvertOp����
            ColorConvertOp cco = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_sRGB),
                    ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
            //���лҶȴ���
            cco.filter(sourceBuf, targetBuf);
            //���ش����ͼ���Ӧ��ͼ�����
            return new ImageIcon(targetBuf);
        }
}
