package com.zyf0806.lmf;

public class A {
	String name;
	int ad;
	int hp;
	
	public void ack(B b) {
		// �˺�����
		int is= (int) (20+ad*0.8);
		b.hp -= is;
		System.out.println(name+"������"+b.name+"ʹ��ʧȥ��"+is+"������ֵ,�仹ʣ��"+b.hp+"��HP��");
	}
	

}
