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

    //创建显示源图像的标签，并将其放在滚动窗格中
        JLabel jls = new JLabel();
        JScrollPane jspz = new JScrollPane(jls);
        //创建显示目标图像的标签，并将其放在滚动窗格中
        JLabel jlt = new JLabel();
        JScrollPane jspy = new JScrollPane(jlt);
        //创建分割窗格，并设置各子窗格中显示的控件
        JSplitPane jsp = new JSplitPane (JSplitPane.HORIZONTAL_SPLIT,jspz,jspy);

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

    public ConvolveFilter(JMenuItem jmi, ImageIcon icon, int i){
        //创建表示不同滤镜的卷积矩阵
        float[][] data = {
            //加强边缘
                {0f, -1f, 0f,
                 -1f, 5f, -1f,
                 0f, -1f, 0f
                 },
            //锐化
                {-0.125f, -0.125f, -0.125f,
                 -0.125f, 2f, -0.125f,
                 -0.125f, -0.125f, -0.125f
                },
            //模糊
                {0.09375f, 0.09375f, 0.09375f,
                 0.09375f, 0.25f, 0.09375f,
                 0.09375f, 0.9375f, 0.09375f
                },
            //浮雕
                {2f, 0f, 2f,
                 0f, 0f, 0f,
                 2f, 0f, -5
                }
        };
        String [] title = {"加强边缘处理结果", "锐化结果", "模糊处理结果", "浮雕处理结果"};
        //获取待处理图像的宽度何高度
        int width = icon.getImage().getWidth(null);
        int height = icon.getImage().getHeight(null);
        //创建两个BufferedImage对象，分别用来放置待处理图像于处理后的图像
        BufferedImage sourceBuf = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
        BufferedImage targetBuf = new BufferedImage (width,height,BufferedImage.TYPE_INT_ARGB);
        //将待处理图像绘制加载到源BufferedImage对象中
        ii = icon;
        Graphics g = sourceBuf.getGraphics();
        g.drawImage (ii.getImage(), 0, 0, Color.white, null);
        //创建封装卷积矩阵的Kernel对象
        Kernel kernel = new Kernel(3, 3, data[i-5]);
        ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP,null);
        co.filter(sourceBuf, targetBuf);
//        ii = new ImageIcon(targetBuf);
        //获取处理后的图像并设置到目标标签中
        jlt.setIcon(new ImageIcon(targetBuf));
        jlt.setVerticalAlignment(JLabel.CENTER);
        jlt.setHorizontalAlignment(JLabel.CENTER);
        jls.setIcon(icon);
        jls.setVerticalAlignment(JLabel.CENTER);
        jls.setHorizontalAlignment(JLabel.CENTER);
        //设置分割条的初始位置
        jsp.setDividerLocation(400);
        //设置分割条的宽度
        jsp.setDividerSize(4);
        this.add(jsp);
        this.setTitle(title[i-5]);
        this.setBounds(500, 400, 800, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
