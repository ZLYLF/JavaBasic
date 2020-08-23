package com.zyf0730.lwh;

public class IQIYIUser {
	
	String name;
	int age;
	int lv;
	boolean vipflag = false;
	
	//充值 开通vip
	public void getVip(int n) {
		if(n<50) {
			return;
		}
		vipflag=true;
	}
	
	// 观看vip 视频
	public void playVipVideo() {
		if(vipflag) {
			System.out.println("播放VIP视频");
		}else {
			System.out.println("播放失败");
		}
		
	}

}
