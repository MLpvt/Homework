package core;

import java.util.Scanner;

public class Task11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Eneter massive size: ");
		int size = scan.nextInt();
		int[] mas = new int[size];
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		System.out.println();

		float[] mas2 = new float[size];
		int i = 0;
		int i_left = i - 1;
		int i_right = i + 1;
		for (i = 0; i < size; i++) {
			if (i_left < 0) {
				mas2[i] = (float) (mas[i_right] / 2);
			} else if (i_right > size - 1) {
				mas2[i] = (float) (mas[i_left] / 2);
			} else {
				mas2[i] = (float) ((mas[i_left] + mas[i_right]) / 2);

			}
			i_left++;
			i_right++;
			System.out.print(mas2[i] + " ");
		}

	}

}
