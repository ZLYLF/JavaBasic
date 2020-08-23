package com.zyf0811.gyj;

public class Student {
	// 属性
	String name;
	int age;
	double score;
	int stuid;
	
	// 方法
	public void exam(int stuid) {
		
		if(this.stuid==stuid) {
			// 输出语句 
			System.out.println("学号校验成功！可以开始考试！");
			score+=5;
		System.out.println("考试通过！成绩是95分，学分增加5分，现在的学分是"+score+"分");
		}else {
			System.out.println("学号校验错误！请重试！");
		}
	}
	
	public static void main(String[] args) {
		
		Student stu1= new Student();
		stu1.name="高誉静";
		stu1.score=10;
		stu1.stuid=20190606;
		
		stu1.exam(20190601);
		
		
		Student stu2= new Student();
		stu2.name="王俊";
		
		System.out.println();
	}
	
	
	
}
