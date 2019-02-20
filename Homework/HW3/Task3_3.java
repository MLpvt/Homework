package core;

public class Task3_3 {
// - Возвести число в квадрат, вернуть результат возведения
	public static void main(String[] args) {
		int a = (int) (Math.random() * 10);
		System.out.println(a);
		System.out.println("Квадрат=" + Pow2(a));

	}

	public static int Pow2(int a) {
		int pow = (int) Math.pow(a, 2);
		return pow;
	}

}
