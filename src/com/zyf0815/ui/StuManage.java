package com.zyf0815.ui;

public class StuManage {
	public static void main(String[] args) {
		// 创建对象  构造对象 
		Student stu1 = new Student();
		stu1.name="hwp";
		stu1.age=20;
		stu1.stuid=20190606;
		stu1.score=48.5;
		
		stu1.exam("hwp", 20190606);
		
	}
}
