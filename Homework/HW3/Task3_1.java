package core;

public class Task3_1 {
	// Найти минимальное число из 2 чисел, вернуть минимальное

	public static void main(String[] args) {

		int a = (int) (Math.random() * 10);
		int b = (int) (Math.random() * 10);
		System.out.println(a + " " + b);
		System.out.println(getMin(a, b));
	}

	public static int getMin(int a, int b) {
		return a<b?a:b;
		/*if (a > b) {
			return b;
		} else
			return a;*/
		
		//return Math.min(a,b);

	}

}
