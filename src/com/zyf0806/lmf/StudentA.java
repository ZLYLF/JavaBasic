package com.zyf0806.lmf;

public class StudentA {
	
	String name;
	int age;
	double score;
	long stuid;
	
	
	// 学生类 共有的方法
	public void exam() {
		score+=5;
		System.out.println(name+"("+stuid+")通过了考试，学分增加5分，现在的学分是"+score);
	}

}
