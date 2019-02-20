package core;

import java.util.Scanner;

public class Task2 {
	public static void main(String[] args) {
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Please Enter Array Size:");
		int size = scan1.nextInt();
		int mas[] = new int[size];
		// ввод массива поэлементно с клавиатуры
		for (int i = 0; i < size; i++) {
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Please Enter Element" + " " + (i + 1) + ":");
			mas[i] = scan2.nextInt();

		}
		for (int i = 0; i < size; i++) {
			System.out.print(mas[i] + " ");
		}
		System.out.println();

		int proizv = 1;
		for (int i = 0; i < size; i++) {
			proizv = proizv * mas[i];
		}
		System.out.print("Proizv:" + proizv);
	}
}
