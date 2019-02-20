package core;

import java.util.Scanner;

public class ExtraTask {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Array Size:");
		int size = scan.nextInt();
		int[] mas = new int[size];
		showMas(mas);
		reverseMas(mas);
		proizv(mas);
		multiplyBy3(mas);
		countZeroElement(mas);
		getNumberOfZeroElement(mas);
		swapAdjacentElements(mas);
		swapFirstAndLast(mas);
		minMax(mas);
		minMaxNumber(mas);
		isSequence(mas);
		halfSum(mas);
		move(mas);

	}

	// прямой порядок
	public static void showMas(int[] anyMas) {
		System.out.print("Massive:");
		for (int i = 0; i < anyMas.length; i++) {
			anyMas[i] = (int) (Math.random() * 10);
			System.out.print(anyMas[i] + " ");
		}
	}

	// обратный порядок
	public static void reverseMas(int[] anyMas) {
		System.out.println();
		System.out.print("Reverse Massive:");
		for (int i = anyMas.length - 1; i >= 0; i--) {
			System.out.print(anyMas[i] + " ");
		}
	}

	// произведение всех элементов
	public static void proizv(int[] anyMas) {
		System.out.println();
		int proizv = 1;
		for (int i = 0; i < anyMas.length; i++) {
			proizv = proizv * anyMas[i];
		}
		System.out.println("Proizv:" + proizv);
	}

	// умножение каждого третьего эл-та на три
	public static void multiplyBy3(int[] anyMas) {
		for (int i = 0; i < anyMas.length; i++) {
			if (i % 3 == 0) {
				anyMas[i] = anyMas[i] * 3;
			}
		}
		System.out.print("Multiplied third element by 3: ");
		for (int i = 0; i < anyMas.length; i++) {
			System.out.print(anyMas[i] + " ");
		}
	}

//посчитать количество нулевых элементов
	public static void countZeroElement(int[] anyMas) {
		int count = 0;
		for (int i = 0; i < anyMas.length; i++) {
			if (anyMas[i] == 0) {
				count = count + 1;
			}

		}
		System.out.println();
		if (count != 0) {
			System.out.println("Quantity of zero elements:" + count);
		}

		else {
			System.out.println("There is no zero elements");
		}
	}

	// вывести номер нулевых элементов
	public static void getNumberOfZeroElement(int[] anyMas) {
		int count = 0;
		for (int i = 0; i < anyMas.length; i++) {
			if (anyMas[i] == 0) {
				System.out.println("Number of zero element: " + i + " ");
				count++;
			}

		}
		if (count == 0) {
			System.out.println("There is no zero elements");
		}

	}

	// поменять местами соседние элементы
	public static void swapAdjacentElements(int[] anyMas) {
		for (int i = 0; i < anyMas.length - 1; i = i + 2) {
			int a = anyMas[i];
			anyMas[i] = anyMas[i + 1];
			anyMas[i + 1] = a;
		}
		System.out.print("Swapped Massive:");
		for (int i = 0; i < anyMas.length; i++) {
			System.out.print(anyMas[i] + " ");
		}
	}

	// поменять первые с последними
	public static void swapFirstAndLast(int[] anyMas) {
		int size0 = anyMas.length - 1;
		for (int i = 0; i <= size0; i++) {
			int a = anyMas[i];
			anyMas[i] = anyMas[size0];
			anyMas[size0] = a;
			size0--;
		}
		System.out.println();
		System.out.print("Swapped First and Last:");
		for (int i = 0; i < anyMas.length; i++) {
			System.out.print(anyMas[i] + " ");
		}
	}

	// найти мин макс
	public static void minMax(int[] anyMas) {
		int max = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {

			if (anyMas[i] > max) {
				max = anyMas[i];
			}

		}
		int min = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {

			if (anyMas[i] < min) {
				min = anyMas[i];
			}

		}
		System.out.println("");
		System.out.println("Min element is:" + min);
		System.out.println("Max element is:" + max);

	}

	// найти номер минимального-максимального элементов
	public static void minMaxNumber(int[] anyMas) {
		int min_num = 0;
		int min = anyMas[0];
		int max_num = 0;
		int max = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {

			if (anyMas[i] < min) {
				min_num = i;
				min = anyMas[i];
			}
			if (anyMas[i] > max) {
				max = anyMas[i];
				max_num = i;
			}

		}
		System.out.println("Number of min element is:" + min_num);
		System.out.println("Number of max element is:" + max_num);

	}

	// проверить, является ли массив возрастающей последовательностью (каждое
	// следующее число больше предыдущего)
	public static void isSequence(int[] anyMas) {
		int count = 0;
		for (int i = 0; i < anyMas.length - 1; i++) {
			if (anyMas[i] < anyMas[i + 1]) {
				count++;
			}
		}
		if (count == anyMas.length - 1) {
			System.out.println("Последовательность возрастающая");
		} else {
			System.out.println("Последовательность не возрастающая");
		}
	}

	// полусумма
	public static void halfSum(int[] anyMas) {
		float[] mas2 = new float[anyMas.length];
		int i = 0;
		int i_left = i - 1;
		int i_right = i + 1;
		System.out.print("Half sum:");
		for (i = 0; i < anyMas.length; i++) {
			if (i_left < 0) {
				mas2[i] = (float) (anyMas[i_right] / 2);
			} else if (i_right > anyMas.length - 1) {
				mas2[i] = (float) (anyMas[i_left] / 2);
			} else {
				mas2[i] = (float) ((anyMas[i_left] + anyMas[i_right]) / 2);

			}
			i_left++;
			i_right++;
			System.out.print(mas2[i] + " ");
		}
	}

	public static void move(int[] anyMas) {
		System.out.println();
		System.out.println("Moved massive: ");

		int[] mas2 = new int[anyMas.length];

		for (int i = 0; i < anyMas.length; i++) {

			mas2[(i + 2) % anyMas.length] = anyMas[i];
		}
		for (int i = 0; i < anyMas.length; i++) {
			System.out.print(mas2[i] + " ");
		}
	}
}
