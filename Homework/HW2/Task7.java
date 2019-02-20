package core;

import java.util.Scanner;

public class Task7 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Array Size:");
		int size = scan.nextInt();
		int[] mas = new int[size];

		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		int size0 = size - 1;
		for (int i = 0; i <= size0; i++) {
			int a = mas[i];
			mas[i] = mas[size0];
			mas[size0] = a;
			size0--;
		}
		System.out.println(" ");
		for (int i = 0; i < size; i++) {
			System.out.print(mas[i] + " ");
		}

	}

}
