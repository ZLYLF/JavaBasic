package com.zyf0715.imagec;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OpenPicture {
    private ImageIcon icon;
    private String name;

    public OpenPicture(JFrame jf, JLabel jl){
        //创建文件选择器
        JFileChooser jfc = new JFileChooser(); 
        //弹出文件选择器
        jfc.showDialog(jf, "请选择要打开的图片");
        //获取图片文件路径
        String path = jfc.getSelectedFile().getAbsolutePath();
        //获取文件名字，不带后缀
        String Imagename = jfc.getSelectedFile().getName();
        String prefix = Imagename.substring(Imagename.lastIndexOf("."));
        int num = prefix.length();                                            //得到后缀名长度
        name = Imagename.substring(0, Imagename.length()-num);                         //得到不带后缀的文件名
        //创建图标对象
         icon = new ImageIcon(path);
        //将图标对象加入标签
        jl.setIcon(icon);
        //设置源图像标签的水平，垂直对齐方式为居中
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setHorizontalAlignment(JLabel.CENTER);
    }

    public ImageIcon getImageIcon(){
        return icon;
    }

    public String getImageName(){
        return name;
    }
}
