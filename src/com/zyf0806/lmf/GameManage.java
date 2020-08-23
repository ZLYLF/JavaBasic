package com.zyf0806.lmf;

public class GameManage {
	public static void main(String[] args) {
		// 创建 A B 的对象
		A a = new A();
		B b = new B();
		// 给A B 的对象的属性 进行赋值
		a.name = "草稚京";
		a.hp = 300;
		a.ad = 50;

		b.name = "八神庵";
		b.hp = 300;
		b.ad = 50;
		// A B 的对象循环攻击

		a.ack(b);
		b.ack(a);
		
		// 判断胜负 
		
		
	}

}
