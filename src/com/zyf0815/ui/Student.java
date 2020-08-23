package com.zyf0815.ui;

public class Student {
	int age;
	String name;
	int stuid;
	double score;
//	0.1+0.2 =0.3  0.300000000000000000000000004;
	
	public void exam(String name,int stuid) {
		// 比较字符串 是否一致 
		if(this.name.equals(name)&& this.stuid==stuid) {
			System.out.println("考生信息验证成功！");
			System.out.println("考试开始！");
			
			score+=5;
			System.out.println(name+"参加了考试，学分增加了5分，现在学分是"+score);
		}else {
			System.out.println("请重试！！");
		}
		
		
	}
	
	
}
