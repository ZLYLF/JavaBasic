package com.zyf0730.lwh;

public class Manage {
	
	public static void main(String[] args) {
		//��������
		IQIYIUser  iqyuserA = new IQIYIUser();
		// ������ֵ 
		iqyuserA.name="�û�A";
		iqyuserA.age=20;
		// ���÷��� 
		iqyuserA.getVip(60);
		iqyuserA.playVipVideo();
		
		
	}
	

}
