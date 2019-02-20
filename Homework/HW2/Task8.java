package core;

import java.util.Scanner;

public class Task8 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Array Size:");
		int size = scan.nextInt();
		int[] mas = new int[size];

		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		int max = mas[0];
		for (int i = 0; i < size; i++) {

			if (mas[i] > max) {
				max = mas[i];
			}

		}
		int min = mas[0];
		for (int i = 0; i < size; i++) {

			if (mas[i] < min) {
				min = mas[i];
			}

		}
		System.out.println("");
		System.out.println("Min element is:" + min);
		System.out.println("Max element is:" + max);

	}

}
