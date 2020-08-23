package com.zyf0813.ex2;

import com.zyf0813.ex.Hero;

public class HouYi extends Hero{

	public void  showInfo() {
		// 私有的和默认的   - -  不能调用 
		System.out.println(name+id+hp+ad);
		
	}
	
	public static void main(String[] args) {
		HouYi hy = new HouYi();
		hy.name = ""; // 公共的
//		hy.h
	}
}
