package com.zyf0731.etv1;

public class CaiWenJi extends Hero{

	

	public void ack(Hero dj) {

		dj.hp -= (100 + 1.1 * ap);

		System.out.println(name + "������" + dj.name + "ʹ��ʧȥ��" +(int) (100 + 1.1 * ap) + "������ֵ���仹ʣ��" + dj.hp + "��");

	}

}
