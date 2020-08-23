package com.zyf0715.imagec;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSplitPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * �����ֵ���㷨��
 * 1.���Ȼ�ȡÿ�����ص�ĻҶ�ֵ��Ŀǰʹ�ü򵥵ģ�R+G+B��/3
 * 2.Ȼ��ѡ��һ����ֵ
 * 3.��һ�����ص�Ҷ�ֵ������Χ��8���Ҷ�ֵ����ٳ���9��Ȼ�����ֵ�Ƚϡ�������ֵ����Ϊ255��С������Ϊ0
 * @author hadoop002
 *
 */
public class BinaryProcessing extends JFrame implements ChangeListener {

    private BufferedImage targetBuf;
    //ѡ��һ����ֵ
    private int sw;
    private ImageIcon icon;
    //������ʾԴͼ��ı�ǩ����������ڹ���������
    JLabel jls = new JLabel();
    JScrollPane jspz = new JScrollPane(jls);
    //������ʾĿ��ͼ��ı�ǩ����������ڹ���������
    JLabel jlt = new JLabel();
    JScrollPane jspy = new JScrollPane(jlt);
    //�����ָ�񣬲����ø��Ӵ�������ʾ�Ŀؼ�
    JSplitPane jsp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);
    //����һ�����
    JPanel jp = new JPanel();
    //������ֵ��ǩ
    JLabel jl = new JLabel("��ֵ");
    //��������������ֵ�Ļ���
    JSlider js = new JSlider(0, 255);


    public BufferedImage getBuf(){
        return targetBuf;
    }

    public BinaryProcessing(ImageIcon ii){

        icon = ii;
        sw = 78;

        //��ȡ������ͼ��Ŀ�Ⱥθ߶�
        int width = icon.getImage().getWidth(null);
        int height = icon.getImage().getHeight(null);

        //����һ��BufferedImage���󣬷ֱ��������ô�����ͼ��
        BufferedImage sourceBuf = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
        targetBuf = new BufferedImage (width,height,BufferedImage.TYPE_BYTE_BINARY);
        //���������ͼ�����BufferedImage������
        Graphics g = sourceBuf.getGraphics();
        g.drawImage (icon.getImage(), 0, 0, Color.white, null);
        //��ȡָ�������ARGB������ֵ
        //int rgb = sourceBuf.getRGB(0,0);
        //����ÿ�����ص�ĻҶ�ֵ
        int [][] gray = new int[width][height];

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                gray[x][y] = getGray(sourceBuf.getRGB(x, y));
            }
        }


        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                if (getAverageColor(gray,x,y,width,height) > sw){
                    int max = new Color(255,255,255).getRGB();
                    targetBuf.setRGB(x, y, max);
                }else{
                    int min = new Color(0,0,0).getRGB();
                    targetBuf.setRGB(x, y, min);
                }
            }
        }

        jls.setIcon(icon);
        jls.setVerticalAlignment(JLabel.CENTER);
        jls.setHorizontalAlignment(JLabel.CENTER);
        jlt.setVerticalAlignment(JLabel.CENTER);
        jlt.setHorizontalAlignment(JLabel.CENTER);
        //��ȡ������ͼ�����õ�Ŀ���ǩ��
        jlt.setIcon(new ImageIcon(targetBuf));
        //���÷ָ����ĳ�ʼλ��
        jsp.setDividerLocation(400);
        //���÷ָ����Ŀ��
        jsp.setDividerSize(4);
        this.add(jsp);
        //����ǩ�ͻ�����ӽ�����У���Ϊ����ע�������
        jp.add(jl);
        jp.add(js);
        js.addChangeListener(this);
        //�������ӽ�����
        this.add(jp,BorderLayout.SOUTH);

        this.setTitle("��ֵ������");
        this.setBounds(500, 400, 800, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static int getGray(int rgb){
        String str = Integer.toHexString(rgb);
        int r = Integer.parseInt(str.substring(2, 4), 16);
        int g = Integer.parseInt(str.substring(4, 6), 16);
        int b = Integer.parseInt(str.substring(6, 8), 16);
        //����ֱ��newһ��color����
        Color c = new Color(rgb);
        r = c.getRed();
        g = c.getGreen();
        b = c.getBlue();
        int top = (r + g + b) / 3;
        return (int)(top);
    }

    public static int getAverageColor (int[][] gray, int x, int y, int w, int h){
        int rs = gray[x][y]
                                     + (x == 0 ? 255 :gray[x - 1][y])
                                     + (x == 0 || y == 0 ? 255 : gray[x - 1][y - 1])
                                     + (x == 0 || y == h - 1 ? 255 : gray[x - 1][y + 1])
                                     + (y == 0 ? 255 : gray[x][y - 1])
                                     + (y == h - 1 ? 255 : gray[x][y + 1])
                                     + (x == w - 1 ? 255 : gray[x + 1][y])
                                     + (x == w - 1 || y == 0 ? 255 : gray[x + 1][y-1])
                                     + (x == w - 1 || y ==h - 1 ? 255 : gray[x + 1][y + 1]);
        return rs / 9;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        //��ȡ������ͼ��Ŀ�Ⱥθ߶�
                int width = icon.getImage().getWidth(null);
                int height = icon.getImage().getHeight(null);

                //����һ��BufferedImage���󣬷ֱ��������ô�����ͼ��
                BufferedImage sourceBuf = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
                targetBuf = new BufferedImage (width,height,BufferedImage.TYPE_BYTE_BINARY);
                //���������ͼ�����BufferedImage������
                Graphics g = sourceBuf.getGraphics();
                g.drawImage (icon.getImage(), 0, 0, Color.white, null);
                //��ȡָ�������ARGB������ֵ
                //int rgb = sourceBuf.getRGB(0,0);
                //����ÿ�����ص�ĻҶ�ֵ
                int [][] gray = new int[width][height];

                for (int x = 0; x < width; x++){
                    for (int y = 0; y < height; y++){
                        gray[x][y] = getGray(sourceBuf.getRGB(x, y));
                    }
                }

                sw = js.getValue();

                for (int x = 0; x < width; x++){
                    for (int y = 0; y < height; y++){
                        if (getAverageColor(gray,x,y,width,height) > sw){
                            int max = new Color(255,255,255).getRGB();
                            targetBuf.setRGB(x, y, max);
                        }else{
                            int min = new Color(0,0,0).getRGB();
                            targetBuf.setRGB(x, y, min);
                        }
                    }
                }

                //��ȡ������ͼ�����õ�Ŀ���ǩ��
                jlt.setIcon(new ImageIcon(targetBuf));
    }
}
