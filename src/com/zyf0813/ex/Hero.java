package com.zyf0813.ex;

public class Hero {
	public String name;  // ������
	private int id;		// ˽�е�
	protected int hp;	// �ܱ�����
	int ad;				// Ĭ�ϵ� 
	int ap;
	
	
	public void ack(Hero hero) {
		hero.hp -=ad;
		System.out.println(name+"������"+hero.name+"ʹ��ʧȥ��"+ad+"�仹ʣ��"+hero.hp+".");
		
	}

	public void drawModel() {

		System.out.println("����ģ��@ԭ��");

	}

}
