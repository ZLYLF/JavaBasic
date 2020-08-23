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
 * 具体二值花算法：
 * 1.首先获取每个像素点的灰度值。目前使用简单的（R+G+B）/3
 * 2.然后选定一个阈值
 * 3.将一个像素点灰度值和它周围的8个灰度值相加再除以9，然后和阈值比较。大于阈值则置为255，小于则置为0
 * @author hadoop002
 *
 */
public class BinaryProcessing extends JFrame implements ChangeListener {

    private BufferedImage targetBuf;
    //选定一个阈值
    private int sw;
    private ImageIcon icon;
    //创建显示源图像的标签，并将其放在滚动窗格中
    JLabel jls = new JLabel();
    JScrollPane jspz = new JScrollPane(jls);
    //创建显示目标图像的标签，并将其放在滚动窗格中
    JLabel jlt = new JLabel();
    JScrollPane jspy = new JScrollPane(jlt);
    //创建分割窗格，并设置各子窗格中显示的控件
    JSplitPane jsp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);
    //创建一个面板
    JPanel jp = new JPanel();
    //创建阈值标签
    JLabel jl = new JLabel("阈值");
    //创建用来控制阈值的滑块
    JSlider js = new JSlider(0, 255);


    public BufferedImage getBuf(){
        return targetBuf;
    }

    public BinaryProcessing(ImageIcon ii){

        icon = ii;
        sw = 78;

        //获取待处理图像的宽度何高度
        int width = icon.getImage().getWidth(null);
        int height = icon.getImage().getHeight(null);

        //创建一个BufferedImage对象，分别用来放置待处理图像
        BufferedImage sourceBuf = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
        targetBuf = new BufferedImage (width,height,BufferedImage.TYPE_BYTE_BINARY);
        //将待处理的图像放入BufferedImage对象中
        Graphics g = sourceBuf.getGraphics();
        g.drawImage (icon.getImage(), 0, 0, Color.white, null);
        //获取指定坐标的ARGB的像素值
        //int rgb = sourceBuf.getRGB(0,0);
        //定义每个像素点的灰度值
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
        //获取处理后的图像并设置到目标标签中
        jlt.setIcon(new ImageIcon(targetBuf));
        //设置分割条的初始位置
        jsp.setDividerLocation(400);
        //设置分割条的宽度
        jsp.setDividerSize(4);
        this.add(jsp);
        //将标签和滑块添加进面板中，并为滑块注册监听器
        jp.add(jl);
        jp.add(js);
        js.addChangeListener(this);
        //将面板添加进窗体
        this.add(jp,BorderLayout.SOUTH);

        this.setTitle("二值化处理");
        this.setBounds(500, 400, 800, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static int getGray(int rgb){
        String str = Integer.toHexString(rgb);
        int r = Integer.parseInt(str.substring(2, 4), 16);
        int g = Integer.parseInt(str.substring(4, 6), 16);
        int b = Integer.parseInt(str.substring(6, 8), 16);
        //或者直接new一个color对象
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
        //获取待处理图像的宽度何高度
                int width = icon.getImage().getWidth(null);
                int height = icon.getImage().getHeight(null);

                //创建一个BufferedImage对象，分别用来放置待处理图像
                BufferedImage sourceBuf = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
                targetBuf = new BufferedImage (width,height,BufferedImage.TYPE_BYTE_BINARY);
                //将待处理的图像放入BufferedImage对象中
                Graphics g = sourceBuf.getGraphics();
                g.drawImage (icon.getImage(), 0, 0, Color.white, null);
                //获取指定坐标的ARGB的像素值
                //int rgb = sourceBuf.getRGB(0,0);
                //定义每个像素点的灰度值
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

                //获取处理后的图像并设置到目标标签中
                jlt.setIcon(new ImageIcon(targetBuf));
    }
}
