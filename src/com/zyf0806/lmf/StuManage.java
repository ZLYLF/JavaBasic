package com.zyf0806.lmf;

public class StuManage {
	
	public static void main(String[] args){
		// �����ӡ��� 
		System.out.print("ѧ������ϵͳ");
		// �������print �����ln
		System.out.println();
		// �������� 
		StudentA  stu1 = new StudentA();
		// ������� 
		stu1.name="���η�";
		stu1.age=19;
		stu1.score=20.5;
		stu1.stuid=2018090123;
		
		// ������÷���
		stu1.exam();
		
	}

}
