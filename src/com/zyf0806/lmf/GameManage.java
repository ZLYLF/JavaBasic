package com.zyf0806.lmf;

public class GameManage {
	public static void main(String[] args) {
		// ���� A B �Ķ���
		A a = new A();
		B b = new B();
		// ��A B �Ķ�������� ���и�ֵ
		a.name = "���ɾ�";
		a.hp = 300;
		a.ad = 50;

		b.name = "������";
		b.hp = 300;
		b.ad = 50;
		// A B �Ķ���ѭ������

		a.ack(b);
		b.ack(a);
		
		// �ж�ʤ�� 
		
		
	}

}
