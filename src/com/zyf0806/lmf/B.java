package com.zyf0806.lmf;

public class B {
	String name;
	int ad;
	int hp;
	
	public void ack(A a) {
		int is = (int) (10+ad*1.2);
		a.hp -= is ;
		System.out.println(name+"攻击了"+a.name+"使其失去了"+is+"点生命值,其还剩下"+a.hp+"点HP。");
	}
	
	

}
