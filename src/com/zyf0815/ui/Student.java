package com.zyf0815.ui;

public class Student {
	int age;
	String name;
	int stuid;
	double score;
//	0.1+0.2 =0.3  0.300000000000000000000000004;
	
	public void exam(String name,int stuid) {
		// �Ƚ��ַ��� �Ƿ�һ�� 
		if(this.name.equals(name)&& this.stuid==stuid) {
			System.out.println("������Ϣ��֤�ɹ���");
			System.out.println("���Կ�ʼ��");
			
			score+=5;
			System.out.println(name+"�μ��˿��ԣ�ѧ��������5�֣�����ѧ����"+score);
		}else {
			System.out.println("�����ԣ���");
		}
		
		
	}
	
	
}
