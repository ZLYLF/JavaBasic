package com.zyf0813.ex;

public class Hero {
	public String name;  // 公共的
	private int id;		// 私有的
	protected int hp;	// 受保护的
	int ad;				// 默认的 
	int ap;
	
	
	public void ack(Hero hero) {
		hero.hp -=ad;
		System.out.println(name+"攻击了"+hero.name+"使其失去了"+ad+"其还剩下"+hero.hp+".");
		
	}

	public void drawModel() {

		System.out.println("绘制模型@原型");

	}

}
