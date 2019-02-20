package core;

import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter Array Size:");
		int size = scan.nextInt();
		int mas[] = new int[size];
		for (int i = 0; i < size; i++) {
			mas[i] = (int) (Math.random() * 10);
			System.out.print(mas[i] + " ");
		}
		System.out.println();
		// способ 1
		/*
		 * for(int i=0;i<size;i=i+3) { mas[i]=mas[i]*3;
		 * 
		 * } System.out.println(); for(int i=0;i<size;i++) {
		 * System.out.print(mas[i]+" "); }
		 */

		// способ 2
		for (int i = 0; i < size; i++) {
			if (i % 3 == 0) {
				mas[i] = mas[i] * 3;
			}
		}
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(mas[i] + " ");
		}
	}
}
