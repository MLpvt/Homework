package core;

import java.util.Scanner;

public class Task9 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Array Size:");
		int size = scan.nextInt();
		int[] mas = new int[size];

		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		int min_num = 0;
		int min = mas[0];
		int max_num = 0;
		int max = mas[0];
		for (int i = 0; i < size; i++) {

			if (mas[i] < min) {
				min_num = i;
				min = mas[i];
			}
			if (mas[i] > max) {
				max = mas[i];
				max_num = i;
			}

		}
		System.out.println("");
		System.out.println("Number of min element is:" + min_num);
		System.out.println("");
		System.out.println("Number of max element is:" + max_num);

	}
}
