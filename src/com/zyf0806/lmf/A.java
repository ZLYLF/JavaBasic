package com.zyf0806.lmf;

public class A {
	String name;
	int ad;
	int hp;
	
	public void ack(B b) {
		// 伤害计算
		int is= (int) (20+ad*0.8);
		b.hp -= is;
		System.out.println(name+"攻击了"+b.name+"使其失去了"+is+"点生命值,其还剩下"+b.hp+"点HP。");
	}
	

}
