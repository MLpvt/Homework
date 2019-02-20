package core;

import java.util.Scanner;

public class Task6 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Array Size:");
		int size = scan.nextInt();
		int[] mas = new int[size];

		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		for (int i = 0; i < size - 1; i = i + 2) {
			int a = mas[i];
			mas[i] = mas[i + 1];
			mas[i + 1] = a;
		}
		System.out.println(" ");
		for (int i = 0; i < size; i++) {
			System.out.print(mas[i] + " ");
		}

	}

}
