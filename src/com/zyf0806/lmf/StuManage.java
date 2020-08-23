package com.zyf0806.lmf;

public class StuManage {
	
	public static void main(String[] args){
		// 输出打印语句 
		System.out.print("学生管理系统");
		// 换行输出print 后加上ln
		System.out.println();
		// 创建对象 
		StudentA  stu1 = new StudentA();
		// 构造对象 
		stu1.name="刘梦帆";
		stu1.age=19;
		stu1.score=20.5;
		stu1.stuid=2018090123;
		
		// 对象调用方法
		stu1.exam();
		
	}

}
