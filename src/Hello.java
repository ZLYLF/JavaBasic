//��
public class Hello {

	// ������� - ������
	public static void main(String[] args) {
		int i = 0;
		i = i + 1;// 1
		i = i + 1;// 2
		for (int j = 0; j < 10; j = j + 1) { // 0+1+1+1+1+1+1+1+1+1+1 10��

			System.out.print("J1=" + j);// ������
		}

		for (int j = 10; j > 0; j = j - 1) {
			System.out.println("J2=" + j); // ���� print�� +ln
		}
	}
}
