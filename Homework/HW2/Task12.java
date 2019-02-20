package core;

import java.util.Scanner;

public class Task12 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter massive size: ");
		int size = scan.nextInt();
		int[] mas = new int[size];
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		System.out.println();

		int[] mas2 = new int[size];

		for (int i = 0; i < size; i++) {
//			int newi = i + 2;
//			if (newi >= size) {
//				newi = newi % size;
//			}
//			mas2[newi] = mas[i];
			mas2[(i + 2) % size] = mas[i];
		}
		for (int i = 0; i < size; i++) {
			System.out.print(mas2[i] + " ");
		}
	}

}
