package core;

import java.util.Scanner;

public class Task1 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Array Size:");
		int size = scan.nextInt();
		int[] mas = new int[size];
		// прямой порядок
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		// обратный порядок
		System.out.println(" ");
		for (int i = size - 1; i >= 0; i--) {
			System.out.print(mas[i] + " ");
		}
	}

}
