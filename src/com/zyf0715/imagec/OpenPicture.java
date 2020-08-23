package com.zyf0715.imagec;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class OpenPicture {
    private ImageIcon icon;
    private String name;

    public OpenPicture(JFrame jf, JLabel jl){
        //�����ļ�ѡ����
        JFileChooser jfc = new JFileChooser(); 
        //�����ļ�ѡ����
        jfc.showDialog(jf, "��ѡ��Ҫ�򿪵�ͼƬ");
        //��ȡͼƬ�ļ�·��
        String path = jfc.getSelectedFile().getAbsolutePath();
        //��ȡ�ļ����֣�������׺
        String Imagename = jfc.getSelectedFile().getName();
        String prefix = Imagename.substring(Imagename.lastIndexOf("."));
        int num = prefix.length();                                            //�õ���׺������
        name = Imagename.substring(0, Imagename.length()-num);                         //�õ�������׺���ļ���
        //����ͼ�����
         icon = new ImageIcon(path);
        //��ͼ���������ǩ
        jl.setIcon(icon);
        //����Դͼ���ǩ��ˮƽ����ֱ���뷽ʽΪ����
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
