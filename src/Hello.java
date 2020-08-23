//类
public class Hello {

	// 程序入口 - 主方法
	public static void main(String[] args) {
		int i = 0;
		i = i + 1;// 1
		i = i + 1;// 2
		for (int j = 0; j < 10; j = j + 1) { // 0+1+1+1+1+1+1+1+1+1+1 10步

			System.out.print("J1=" + j);// 不换行
		}

		for (int j = 10; j > 0; j = j - 1) {
			System.out.println("J2=" + j); // 换行 print后 +ln
		}
	}
}
