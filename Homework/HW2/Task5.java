package core;

import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Array Size");
		int size = scan.nextInt();
		int mas[] = new int[size];
		int i = 0;
		while (i < size) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
			i++;
		}
		System.out.println(" ");
		int count = 0;
		for (i = 0; i < size; i++) {
			if (mas[i] == 0) {
				System.out.print(i + " ");
				count++;
			}

		}
		if (count == 0) {
			System.out.println("There is no zero elements");
		}

	}
}
