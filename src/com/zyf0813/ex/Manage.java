package com.zyf0813.ex;

public class Manage {
	public static void main(String[] args) {
		Hero kol = new KingOfLanLin();
		kol.name="À¼ÁêÍõ";
		kol.ad=15;
		kol.hp=100;
		kol.drawModel();
		
		SunWuKong swk = new SunWuKong();
		swk.name = "ËïÎò¿Õ";
		swk.ad=15;
		swk.hp=100;
		
//		kol.test();
		
		
		kol.ack(swk);
		swk.ack(kol);
	}
	
	
			

}
