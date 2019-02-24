package core;

import java.util.Scanner;

public class Task7_3 {
	public static void main(String args[]) {

		int n = (int) (Math.random() * 10);
		Scanner scan = new Scanner(System.in);
		String[] array = new String[n];
		System.out.println("Enter " + n + " strings");
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextLine();
		}
		scan.close();
		System.out.println("Average length = " + getAverageLength(array));
		print(array);

	}

	public static double getAverageLength(String[] anyMas) {
		int sum = 0;
		for (int i = 0; i < anyMas.length; i++) {
			sum = sum + anyMas[i].length();
		}
		double averageLength = (double) sum / anyMas.length;
		return averageLength;

	}

	public static void print(String[] anyMas) {
		System.out.println("Strings longer than average:");
		for (int i = 0; i < anyMas.length; i++) {
			if (anyMas[i].length() > getAverageLength(anyMas)) {
				System.out.println(anyMas[i] + ", " + "Length=" + anyMas[i].length());
			}
		}
		System.out.println("Strings shorter than average:");
		for (int i = 0; i < anyMas.length; i++) {
			if (anyMas[i].length() < getAverageLength(anyMas)) {
				System.out.println(anyMas[i] + ", " + "Length=" + anyMas[i].length());
			}
		}

	}

}
