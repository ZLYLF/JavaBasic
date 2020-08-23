package com.zyf0731.xyl;

public class Student {
	String name;
	int age;
	int sex;
	double score;
	
	// 行为
	public void study(int t) {
		
		score+=t;
		System.out.println(name+"学习了"+t+"小时！学分增加了"+t+"分。"+"现在的学分是"+score);
		
	}
	
	// 主方法 
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
