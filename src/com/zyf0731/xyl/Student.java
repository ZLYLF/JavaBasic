package com.zyf0731.xyl;

public class Student {
	String name;
	int age;
	int sex;
	double score;
	
	// ��Ϊ
	public void study(int t) {
		
		score+=t;
		System.out.println(name+"ѧϰ��"+t+"Сʱ��ѧ��������"+t+"�֡�"+"���ڵ�ѧ����"+score);
		
	}
	
	// ������ 
	public static void main(String[] args) {
		Student stuA = new Student();
		stuA.name="xyl";
		stuA.age=21;
		stuA.score=20;
		
		stuA.study(1);
		
		Student stuB= new Student();
		stuB.study(10);
		
	}

}
