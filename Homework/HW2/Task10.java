package core;

import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Eneter massive size: ");
		int size = scan.nextInt();
		int[] mas = new int[size];
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		int count = 0;
		for (int i = 0; i < size - 1; i++) {
			if (mas[i] < mas[i + 1]) {
				count++;
			}
		}
		if (count == size - 1) {
			System.out.println("Последовательность возрастающая");
		} else {
			System.out.println("Последовательность не возрастающая");
		}

	}

}
