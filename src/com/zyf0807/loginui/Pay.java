package com.zyf0807.loginui;

public class Pay {
	
	/**
	 * @param imi  �ӿ����͵Ĳ��� 
	 */
	public void userpay(MyInterface mi) {
		
		mi.pay(0);
		
		
	}
	
	public static void main(String[] args) {
		Pay pay = new Pay();
		// ʵ���˽ӿڵ�ҵ���� 
		ImplementsMyInterface imi= new ImplementsMyInterface();
		FacePay facepay = new FacePay();
		
		pay.userpay(facepay);
		pay.userpay(imi);
		
	}

}
