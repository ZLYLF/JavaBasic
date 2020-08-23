package com.zyf0815.interface_listener;

public class ImInterface implements MyInterface{

	@Override
	public void test(int n) {
		// TODO Auto-generated method stub
		System.out.println("n="+n);
		
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println("实现之后的test方法");
		
	}

	
	
	
}
