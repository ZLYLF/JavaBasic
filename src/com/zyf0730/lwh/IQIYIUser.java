package com.zyf0730.lwh;

public class IQIYIUser {
	
	String name;
	int age;
	int lv;
	boolean vipflag = false;
	
	//��ֵ ��ͨvip
	public void getVip(int n) {
		if(n<50) {
			return;
		}
		vipflag=true;
	}
	
	// �ۿ�vip ��Ƶ
	public void playVipVideo() {
		if(vipflag) {
			System.out.println("����VIP��Ƶ");
		}else {
			System.out.println("����ʧ��");
		}
		
	}

}
