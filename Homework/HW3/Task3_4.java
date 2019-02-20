package core;

public class Task3_4 {
//- Возвести число в куб, вернуть результат возведения
	public static void main(String[] args) {
		int a = (int) (Math.random() * 10);
		System.out.println(a);
		System.out.println("Куб=" + Pow3(a));

	}

	public static int Pow3(int a) {
		int pow = (int) Math.pow(a, 3);
		return pow;
	}
}
