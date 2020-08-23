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

    //�����˵�����
     JMenu[] jm = {new JMenu("�ļ�"), new JMenu("����"), new JMenu("����˾�")};
    //������ͨ�˵�������
     JMenuItem[] jmi = new JMenuItem[]{new JMenuItem("��"), new JMenuItem("����"), 
            new JMenuItem("�Ҷȴ���"), new JMenuItem("RGBɫ��ͨ������"), new JMenuItem("��ֵ��"),new JMenuItem("��ǿ��Ե"),
            new JMenuItem("��"), new JMenuItem("ģ��"), new JMenuItem("����")};
    //�����˵���
     JMenuBar jmb = new JMenuBar();

     JLabel jl1 = new JLabel();
     JScrollPane jlf = new JScrollPane(jl1);
    //������ʾԴͼ��ı�ǩ
    JLabel jls = new JLabel();
    //����ʾԴͼ��ı�ǩ���ڹ���������
     JScrollPane jspz = new JScrollPane(jls);
    //������ʾĿ��ͼ��ı�ǩ
     JLabel jlt = new JLabel();
    //����ʾĿ��ͼ��ı�ǩ���ڹ���������
     JScrollPane jspy = new JScrollPane(jlt);
    //�������
    JPanel jp = new JPanel();
    String[] str = {"��ǿ��Ե","��","ģ��","����"};


    //������
    public ImageProcessing(){
        //���ļ��˵���ӽ��˵���
        jmb.add(jm[0]);
        //���򿪣�����˵�����ӽ��ļ��˵�����ע�������
        for (int i = 0; i < 2; i++){
            jm[0].add(jmi[i]);
            jmi[i].addActionListener(this);
        }
        //�������˵���ӽ��˵���
        jmb.add(jm[1]);
        //���Ҷȴ���RGBɫ��ͨ��������ӽ������˵�����ע�������
        for (int i = 2; i < 5; i++){
            jm[1].add(jmi[i]);
            jmi[i].addActionListener(this);
        }
        //������˵���ӽ��˵���
        jmb.add(jm[2]);
        //����ǿ��Ե���񻯣�ģ����������ӽ�����˾��˵�����ע�������
                for (int i = 5; i < jmi.length; i++){
                    jm[2].add(jmi[i]);
                    jmi[i].addActionListener(this);
                }
        //����ֵ���˵���ӽ��˵���
        //jmb.add(jm[3]);
        //jm[3].addActionListener(this);
        //���˵�����ӽ�����
        this.setJMenuBar(jmb);
        //�����й��������ı�����ӽ�����
        this.add(jlf);
        this.add(jp, BorderLayout.SOUTH);

        //���ô��ڵĹرն��������⣬��С��λ�ã��Լ��ɼ���
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("ͼ������");
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
        //��ֵ����������������ͼƬ����
        if (e.getSource() == jmi[4]){
            BinaryProcessing bp = new BinaryProcessing(icon);
            try {
                ImageIO.write(bp.getBuf(), "jpg", new File(System.getProperty("user.dir")+"/src/images/"+name+"_bp.jpg"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        //ѡ�д򿪲˵���
        else if (e.getSource() == jmi[0]){
            OpenPicture op = new OpenPicture(this,jl1);
            icon = op.getImageIcon();
            name = op.getImageName();

        }
        //ѡ�б���˵���
        else if (e.getSource() == jmi[1]){
            //jta.append("�����ļ�");
        }
        //ѡ�лҶȴ���˵���������������ͼƬ����
        else if (e.getSource() == jmi[2]){
            GrayProcessing gp = new GrayProcessing(icon);
            try {
                ImageIO.write(gp.getBuf(), "jpg", new File(System.getProperty("user.dir")+"/src/images/"+name+"_gp.jpg"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        //ѡ��RGBɫ��ͨ�����ˣ�����������ͼƬ����
        else if (e.getSource() == jmi[3]){
            RGBFilter rgbf = new RGBFilter(icon);
            try {
                ImageIO.write(rgbf.getBuf(), "jpg", new File(System.getProperty("user.dir")+"/src/images/"+name+"_rgbf.jpg"));
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

        //ѡ�о���˾�
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
