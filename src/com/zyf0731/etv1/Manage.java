package com.zyf0731.etv1;

public class Manage {
public static void main(String[] args) {
	DaJi daji = new DaJi();
	daji.name="Êßº∫£®lwh£©";
	daji.hp=3456;
	daji.ad=50;
	daji.ap=498;
	
	Hero daji1 = new DaJi();
//	daji1.test();  
	daji.test();
	
	CaiWenJi cwj = new CaiWenJi();
	cwj.name="≤ÃŒƒºß£®wed£©";
	cwj.hp=3456;
	cwj.ad=50;
	cwj.ap=498;
	
	
	
	daji.ack(cwj);
	cwj.ack(daji);
	
	DiRenJIe  drj = new DiRenJIe();
	drj.name="µ“» Ω‹£®xed£©";
	drj.hp=3456;
	drj.ad=50;
	drj.ap=498;
	drj.ack(cwj);
	drj.ack(daji);
	
	
	daji.ack(cwj);
	
}
}
