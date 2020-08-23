package com.zyf0815.interface_listener;


public class UseInerface {
	
	public void usetest(MyInterface mi) {
		mi.test();
	}
	
	public static void main(String[] args) {
		
		UseInerface ui = new UseInerface();
		
		ImInterface imi = new ImInterface();
		
		ui.usetest(imi);
		
	}

}
