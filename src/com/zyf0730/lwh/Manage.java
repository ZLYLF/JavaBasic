package com.zyf0730.lwh;

public class Manage {
	
	public static void main(String[] args) {
		//创建对象　
		IQIYIUser  iqyuserA = new IQIYIUser();
		// 给对象赋值 
		iqyuserA.name="用户A";
		iqyuserA.age=20;
		// 调用方法 
		iqyuserA.getVip(60);
		iqyuserA.playVipVideo();
		
		
	}
	

}
