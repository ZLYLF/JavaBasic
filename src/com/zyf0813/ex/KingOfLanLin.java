package com.zyf0813.ex;

public final class KingOfLanLin extends Hero{

	public void  showInfo() {
		// 私有的 不能调用 
		System.out.println(name+hp+ad);
		
	}
	
	// 方法重写 
	public void drawModel() {

		System.out.println("绘制模型@原型");
		System.out.println("绘制模型@原型+皮肤");
	}
}
