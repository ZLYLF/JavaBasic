package com.zyf0731.etv1;

public class CaiWenJi extends Hero{

	

	public void ack(Hero dj) {

		dj.hp -= (100 + 1.1 * ap);

		System.out.println(name + "攻击了" + dj.name + "使其失去了" +(int) (100 + 1.1 * ap) + "点生命值，其还剩下" + dj.hp + "。");

	}

}
