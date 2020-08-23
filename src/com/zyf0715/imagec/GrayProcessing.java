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

     //创建显示源图像的标签，并将其放在滚动窗格中
    JLabel jls = new JLabel();
    JScrollPane jspz = new JScrollPane(jls);
    //创建显示目标图像的标签，并将其放在滚动窗格中
    JLabel jlt = new JLabel();
    JScrollPane jspy = new JScrollPane(jlt);
    //创建分割窗格，并设置各子窗格中显示的控件
    JSplitPane jsp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);

    public BufferedImage getBuf(){
        BufferedImage targetBuf1 = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //获取表示源图像的BufferedImage对象的画笔
        Graphics g = targetBuf1.getGraphics();
        //将待处理的图像绘制到源图像的BufferedImage对象中
        g.drawImage(ii.getImage(), 0, 0, Color.white,null);
        return targetBuf1;

    }

    //构造器
    public GrayProcessing(ImageIcon icon){
        ii = icon;
        //将图片设置到源标签中
        jls.setIcon(ii);
        //设置源图像标签的水平，垂直对齐方式为居中
        jls.setVerticalAlignment(JLabel.CENTER);
        jls.setHorizontalAlignment(JLabel.CENTER);
        //设置目标图像标签的水平，垂直对齐方式为居中
        jlt.setVerticalAlignment(JLabel.CENTER);
        jlt.setHorizontalAlignment(JLabel.CENTER);
        //获取处理后的图像对应的图标
        ii =this.processGrayImage(ii.getImage());
        //将处理后的图片设置到目标标签中
        jlt.setIcon(ii);
        //设置分割条的初始位置
        jsp.setDividerLocation(350);
        //设置分割条的宽度
        jsp.setDividerSize(4);
        //将分割条添加到窗体
        this.add(jsp);
        //设置窗体的标题，大小，位置以及可见性
        this.setTitle("灰度处理结果");
        this.setBounds(450,350,700,500);
        this.setVisible(true);
        //设置窗体关闭动作
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    //对图片进行灰度处理的方法
        public ImageIcon processGrayImage (Image source){
            //获取图像的宽度和高度
            width = source.getWidth(null);
            height = source.getHeight(null);
            //创建表示源图像的BufferedImage对象
            BufferedImage sourceBuf = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
            //创建表示处理后目标图像的BufferedImage对象
            BufferedImage targetBuf = new BufferedImage(width,height,BufferedImage.TYPE_USHORT_GRAY);
            //获取表示源图像的BufferedImage对象的画笔
            Graphics g = sourceBuf.getGraphics();
            //将待处理的图像绘制到源图像的BufferedImage对象中
            g.drawImage(source, 0, 0, Color.white,null);
            //创建用来进行灰度处理的ColorConvertOp对象
            ColorConvertOp cco = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_sRGB),
                    ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
            //进行灰度处理
            cco.filter(sourceBuf, targetBuf);
            //返回处理后图像对应的图标对象
            return new ImageIcon(targetBuf);
        }
}
