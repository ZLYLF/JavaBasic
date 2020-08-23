package com.zyf0730.drawpad;
import java.awt.Graphics;
public class MySerbinRecT {
	
	
	public void drawMyRect(Graphics g,int x,int y,int width,int height,int n) {
		if(n<0) {
			return;
		}
		n--;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		g.drawRect(x, y, width, height);
		g.fillRect(x+width/3, y+height/3, width/3, height/3);
		drawMyRect(g,x,y,width/3,height/3,n);
		drawMyRect(g,x+width/3,y,width/3,height/3,n);
		drawMyRect(g,x+2*(width/3),y,width/3,height/3,n);
		
		
	}

}





