package com.zyf0806.lmf;

public class B {
	String name;
	int ad;
	int hp;
	
	public void ack(A a) {
		int is = (int) (10+ad*1.2);
		a.hp -= is ;
		System.out.println(name+"������"+a.name+"ʹ��ʧȥ��"+is+"������ֵ,�仹ʣ��"+a.hp+"��HP��");
	}
	
	

}
