package core;

public class Task3_2 {
//	- Проверить четное число или нечетное, вернуть boolean результат
	public static void main(String[] args) {

		int a = (int) (Math.random() * 10);
		System.out.println(a);
		if (isEven(a) == true) {
			System.out.println("число четное");
		} else
			System.out.println("число нечетное");
	}

	public static boolean isEven(int a) {
		return a % 2 == 0;
		
	}
}
