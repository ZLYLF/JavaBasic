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
    //获取源图片图标对象
    //private ImageIcon icon =null;
    ImageIcon ii = null;
     //创建显示源图像的标签，并将其放在滚动窗格中
    JLabel jls = new JLabel();
    JScrollPane jspz = new JScrollPane(jls);
    //创建显示目标图像的标签，并将其放在滚动窗格中
    JLabel jlt = new JLabel();
    JScrollPane jspy = new JScrollPane(jlt);
    //创建分割窗格，并设置各子窗格中显示的控件
    JSplitPane jsp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);
    //创建表示通道的标签数组
    JLabel[] jl = {new JLabel("红色"),
                           new JLabel("绿色"),
                           new JLabel("蓝色")
    };
    //创建三个用来控制各通道颜色分量的滑块
    JSlider[] js = {new JSlider(-255,255),
                             new JSlider(-255,255),
                             new JSlider(-255,255)
    };
    //创建一个面板
    JPanel jp = new JPanel();
    //创建自定义的过滤器对象
    MyColorFilter mcf = new MyColorFilter(js[0].getValue(), js[1].getValue(), js[2].getValue());

    public BufferedImage getBuf(){
        int width = ii.getImage().getWidth(null);
        int height = ii.getImage().getHeight(null);
        BufferedImage targetBuf1 = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //获取表示源图像的BufferedImage对象的画笔
        Graphics g = targetBuf1.getGraphics();
        //将待处理的图像绘制到源图像的BufferedImage对象中
        g.drawImage(ii.getImage(), 0, 0, Color.white,null);
        return targetBuf1;

    }

    //构造器
    public RGBFilter(ImageIcon icon){

        jls.setIcon(icon);
        jls.setVerticalAlignment(JLabel.CENTER);
        jls.setHorizontalAlignment(JLabel.CENTER);
        jlt.setVerticalAlignment(JLabel.CENTER);
        jlt.setHorizontalAlignment(JLabel.CENTER);
        //将处理后的图片设置到目标标签中
         ii = icon;
        jlt.setIcon(ii);
        jsp.setDividerLocation(500);
        jsp.setDividerSize(4);
        this.add(jsp, BorderLayout.CENTER);
        //将标签以及滑块添加道面板中，并为滑块注册监听器
        for (int i = 0; i < js.length; i++){
            jp.add(jl[i]);
            jp.add(js[i]);
            js[i].addChangeListener(this);
    }
        //将面板添加进窗体
        this.add(jp,BorderLayout.SOUTH);
        //设置窗体的标题，大小，位置以及可见性
        this.setTitle("RGB滤波");
        this.setBounds(300,300,1000,500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        //设置三个分量的值
        mcf.setRGBValue(js[0].getValue(),js[1].getValue(),js[2].getValue());
        //获取过滤后的图像显示到目标标签中
        Image tempImg = createImage(new FilteredImageSource(ii.getImage().getSource(),mcf));
        jlt.setIcon(new ImageIcon(tempImg));
    }   

    }

//自定义的RGB色彩通道过滤器类
        class MyColorFilter extends RGBImageFilter{
            //RGB色彩通道各自的调整值
            int rc,gc,bc;
            public MyColorFilter(int rc, int gc, int bc){
                this.rc = rc;
                this.gc = gc;
                this.bc = bc;
            }

            //设置各个色彩通道的调整值
            public void setRGBValue(int rc, int gc, int bc){
                this.rc = rc;
                this.gc = gc;
                this.bc = bc;
            }

            @Override
            public int filterRGB(int x, int y, int rgb) {
                // TODO Auto-generated method stub
                //取出红色通道中的数值
                int tempRed = (rgb&0x00ff0000) >> 16;
                //对红色通道值进行处理
                tempRed += rc;
                //判断处理后的数值是否越位
                tempRed = (tempRed < 255) ? ((tempRed > 0) ? tempRed : 0) : 255;
                //将处理后的值移回指定位
                tempRed = tempRed << 16;

                //取出绿色通道中的数值
                int tempGreen = (rgb&0x0000ff00) >> 8;
                //对绿色通道值进行处理
                tempGreen += gc;
                //判断处理后的数值是否越位
                tempGreen = (tempGreen < 255) ? ((tempGreen > 0) ? tempGreen : 0) : 255;
                //将处理后的值移回指定位
                tempGreen = tempGreen << 8;

                //取出蓝色通道中的数值
                int tempBlue = (rgb&0x000000ff);
                //对蓝色通道值进行处理
                tempBlue += bc;
                //判断处理后的数值是否越位
                tempBlue = (tempBlue < 255) ? ((tempBlue > 0) ? tempBlue : 0) : 255;
                //将红，绿，蓝三色通道的值与颜色本身中高8位用来控制透明度的值进行按位或运算并返回
                return (rgb&0xff000000) | tempRed |tempGreen | tempBlue;
            }

}