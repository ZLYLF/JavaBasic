package com.zyf0807.loginui;

public class Pay {
	
	/**
	 * @param imi  接口类型的参数 
	 */
	public void userpay(MyInterface mi) {
		
		mi.pay(0);
		
		
	}
	
	public static void main(String[] args) {
		Pay pay = new Pay();
		// 实现了接口的业务类 
		ImplementsMyInterface imi= new ImplementsMyInterface();
		FacePay facepay = new FacePay();
		
		pay.userpay(facepay);
		pay.userpay(imi);
		
	}

}
