package com.zyf0731.etv1;

import com.zyf0731.etv1.CaiWenJi;

public class DaJi extends com.zyf0731.etv1.Hero{
	
	public void test() {
		
		
	}
	
	public void ack(Hero hero) {
		
		hero.hp -= (200+0.8*ad);
		
		System.out.println(name+"������"+hero.name+"ʹ��ʧȥ��"+(int) (200+0.8*ap)+"������ֵ���仹ʣ��"+hero.hp+"��");
		
	}
	
}
