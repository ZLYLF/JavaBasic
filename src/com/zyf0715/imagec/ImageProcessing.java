package com.zyf0715.imagec;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class ImageProcessing extends JFrame implements ActionListener {
    private ImageIcon icon =null;
    private String name;

    //创建菜单数组
     JMenu[] jm = {new JMenu("文件"), new JMenu("操作"), new JMenu("卷积滤镜")};
    //创建普通菜单项数组
     JMenuItem[] jmi = new JMenuItem[]{new JMenuItem("打开"), new JMenuItem("保存"), 
            new JMenuItem("灰度处理"), new JMenuItem("RGB色彩通道过滤"), new JMenuItem("二值化"),new JMenuItem("加强边缘"),
            new JMenuItem("锐化"), new JMenuItem("模糊"), new JMenuItem("浮雕")};
    //创建菜单栏
     JMenuBar jmb = new JMenuBar();

     JLabel jl1 = new JLabel();
     JScrollPane jlf = new JScrollPane(jl1);
    //创建显示源图像的标签
    JLabel jls = new JLabel();
    //将显示源图像的标签放在滚动窗格中
     JScrollPane jspz = new JScrollPane(jls);
    //创建显示目标图像的标签
     JLabel jlt = new JLabel();
    //将显示目标图像的标签放在滚动窗格中
     JScrollPane jspy = new JScrollPane(jlt);
    //创建面板
    JPanel jp = new JPanel();
    String[] str = {"加强边缘","锐化","模糊","浮雕"};


    //构造器
    public ImageProcessing(){
        //将文件菜单添加进菜单栏
        jmb.add(jm[0]);
        //将打开，保存菜单项添加进文件菜单，并注册监听器
        for (int i = 0; i < 2; i++){
            jm[0].add(jmi[i]);
            jmi[i].addActionListener(this);
        }
        //将操作菜单添加进菜单栏
        jmb.add(jm[1]);
        //将灰度处理，RGB色彩通道过滤添加进操作菜单，并注册监听器
        for (int i = 2; i < 5; i++){
            jm[1].add(jmi[i]);
            jmi[i].addActionListener(this);
        }
        //将卷积菜单添加进菜单栏
        jmb.add(jm[2]);
        //将加强边缘，锐化，模糊，浮雕添加进卷积滤镜菜单，并注册监听器
                for (int i = 5; i < jmi.length; i++){
                    jm[2].add(jmi[i]);
                    jmi[i].addActionListener(this);
                }
        //将二值化菜单添加进菜单栏
        //jmb.add(jm[3]);
        //jm[3].addActionListener(this);
        //将菜单栏添加进窗体
        this.setJMenuBar(jmb);
        //将带有滚动条的文本区添加进窗体
        this.add(jlf);
        this.add(jp, BorderLayout.SOUTH);

        //设置窗口的关闭动作，标题，大小，位置，以及可见性
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("图像处理编程");
        this.setBounds(400, 300, 700, 500);
        this.setVisible(true);

    }


    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
       new ImageProcessing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //二值化处理，并将处理后的图片保存
        if (e.getSource() == jmi[4]){
            BinaryProcessing bp = new BinaryProcessing(icon);
            try {
                ImageIO.write(bp.getBuf(), "jpg", new File(System.getProperty("user.dir")+"/src/images/"+name+"_bp.jpg"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        //选中打开菜单项
        else if (e.getSource() == jmi[0]){
            OpenPicture op = new OpenPicture(this,jl1);
            icon = op.getImageIcon();
            name = op.getImageName();

        }
        //选中保存菜单栏
        else if (e.getSource() == jmi[1]){
            //jta.append("保存文件");
        }
        //选中灰度处理菜单栏，并将处理后的图片保存
        else if (e.getSource() == jmi[2]){
            GrayProcessing gp = new GrayProcessing(icon);
            try {
                ImageIO.write(gp.getBuf(), "jpg", new File(System.getProperty("user.dir")+"/src/images/"+name+"_gp.jpg"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        //选中RGB色彩通道过滤，并将处理后的图片保存
        else if (e.getSource() == jmi[3]){
            RGBFilter rgbf = new RGBFilter(icon);
            try {
                ImageIO.write(rgbf.getBuf(), "jpg", new File(System.getProperty("user.dir")+"/src/images/"+name+"_rgbf.jpg"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        //选中卷积滤镜
        else{
            for (int i = 5; i < jmi.length; i++){
                if (e.getSource() == jmi[i]){
                ConvolveFilter cf = new ConvolveFilter(jmi[i],icon,i);
                try {
                    ImageIO.write(cf.getBuf(), "jpg", new File(System.getProperty("user.dir")+"/src/images/"+name+"_cf_"+str[i-5]+".jpg"));
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                }
            }
        }
    }

}
