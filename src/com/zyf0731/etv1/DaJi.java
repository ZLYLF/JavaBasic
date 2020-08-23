package com.zyf0731.etv1;

import com.zyf0731.etv1.CaiWenJi;

public class DaJi extends com.zyf0731.etv1.Hero{
	
	public void test() {
		
		
	}
	
	public void ack(Hero hero) {
		
		hero.hp -= (200+0.8*ad);
		
		System.out.println(name+"攻击了"+hero.name+"使其失去了"+(int) (200+0.8*ap)+"点生命值，其还剩下"+hero.hp+"。");
		
	}
	
}
