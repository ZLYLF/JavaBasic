package com.zyf0811.gyj;

public class Student {
	// ����
	String name;
	int age;
	double score;
	int stuid;
	
	// ����
	public void exam(int stuid) {
		
		if(this.stuid==stuid) {
			// ������ 
			System.out.println("ѧ��У��ɹ������Կ�ʼ���ԣ�");
			score+=5;
		System.out.println("����ͨ�����ɼ���95�֣�ѧ������5�֣����ڵ�ѧ����"+score+"��");
		}else {
			System.out.println("ѧ��У����������ԣ�");
		}
	}
	
	public static void main(String[] args) {
		
		Student stu1= new Student();
		stu1.name="������";
		stu1.score=10;
		stu1.stuid=20190606;
		
		stu1.exam(20190601);
		
		
		Student stu2= new Student();
		stu2.name="����";
		
		System.out.println();
	}
	
	
	
}
