package com.zyf0715.imagec;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

public class ConvolveFilter extends JFrame {
    private ImageIcon ii;

    //������ʾԴͼ��ı�ǩ����������ڹ���������
        JLabel jls = new JLabel();
        JScrollPane jspz = new JScrollPane(jls);
        //������ʾĿ��ͼ��ı�ǩ����������ڹ���������
        JLabel jlt = new JLabel();
        JScrollPane jspy = new JScrollPane(jlt);
        //�����ָ�񣬲����ø��Ӵ�������ʾ�Ŀؼ�
        JSplitPane jsp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);

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

    public ConvolveFilter(JMenuItem jmi, ImageIcon icon, int i){
        //������ʾ��ͬ�˾��ľ������
        float[][] data = {
            //��ǿ��Ե
                {0f, -1f, 0f,
                 -1f, 5f, -1f,
                 0f, -1f, 0f
                 },
            //��
                {-0.125f, -0.125f, -0.125f,
                 -0.125f, 2f, -0.125f,
                 -0.125f, -0.125f, -0.125f
                },
            //ģ��
                {0.09375f, 0.09375f, 0.09375f,
                 0.09375f, 0.25f, 0.09375f,
                 0.09375f, 0.9375f, 0.09375f
                },
            //����
                {2f, 0f, 2f,
                 0f, 0f, 0f,
                 2f, 0f, -5
                }
        };
        String [] title = {"��ǿ��Ե������", "�񻯽��", "ģ��������", "��������"};
        //��ȡ������ͼ��Ŀ�Ⱥθ߶�
        int width = icon.getImage().getWidth(null);
        int height = icon.getImage().getHeight(null);
        //��������BufferedImage���󣬷ֱ��������ô�����ͼ���ڴ�����ͼ��
        BufferedImage sourceBuf = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
        BufferedImage targetBuf = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
        //��������ͼ����Ƽ��ص�ԴBufferedImage������
        ii = icon;
        Graphics g = sourceBuf.getGraphics();
        g.drawImage (ii.getImage(), 0, 0, Color.white, null);
        //������װ��������Kernel����
        Kernel kernel = new Kernel(3, 3, data[i-5]);
        ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,null);
        co.filter(sourceBuf, targetBuf);
//        ii = new ImageIcon(targetBuf);
        //��ȡ������ͼ�����õ�Ŀ���ǩ��
        jlt.setIcon(new ImageIcon(targetBuf));
        jlt.setVerticalAlignment(JLabel.CENTER);
        jlt.setHorizontalAlignment(JLabel.CENTER);
        jls.setIcon(icon);
        jls.setVerticalAlignment(JLabel.CENTER);
        jls.setHorizontalAlignment(JLabel.CENTER);
        //���÷ָ����ĳ�ʼλ��
        jsp.setDividerLocation(400);
        //���÷ָ����Ŀ��
        jsp.setDividerSize(4);
        this.add(jsp);
        this.setTitle(title[i-5]);
        this.setBounds(500, 400, 800, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
