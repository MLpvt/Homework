package core;

import java.util.Scanner;

public class ExtraTask1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter massive length: ");
		int length = scan.nextInt();
		System.out.println("Enter massive width: ");
		int width = scan.nextInt();
		int[][] mas = new int[length][width];
		// прямой порядок
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				mas[i][j] = (int) (Math.random() * 10);
				System.out.print(mas[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		// обратный порядок
		for (int i = length - 1; i >= 0; i--) {
			for (int j = width - 1; j >= 0; j--) {
				System.out.print(mas[i][j] + " ");
			}
			System.out.println();
		}

		// min max
		int max = mas[0][0];
		int min = mas[0][0];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < width; j++) {
				if (mas[i][j] > max) {
					max = mas[i][j];
				}
				if (mas[i][j] < min) {
					min = mas[i][j];
				}

			}

		}
		System.out.println("Min:" + min + ", Max:" + max);

	}
}
