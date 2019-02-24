package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task7_2 {
	public static void main(String args[]) {
		int n = (int) (Math.random() * 10);
		Scanner scan = new Scanner(System.in);
		String[] array = new String[n];
		System.out.println("Enter " + n + " strings");
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextLine();
		}
		scan.close();
		System.out.println(Arrays.toString(array));

		String[] sortedAsc = sortAsc(array);
		System.out.println(Arrays.toString(sortedAsc));

		String[] sortedDesc = sortDesc(array);
		System.out.println(Arrays.toString(sortedDesc));

	}

	private static String[] sortAsc(String[] array) {
		String[] strings = Arrays.copyOf(array, array.length);
		for (int j = 0; j < strings.length - 1; j++) {
			for (int i = 1; i < strings.length - j; i++) {
				if (strings[i].length() < strings[i - 1].length()) {
					swap(strings, i, i - 1);
				}
			}
		}
		return strings;
	}

	private static String[] sortDesc(String[] array) {
		String[] strings = Arrays.copyOf(array, array.length);
		for (int j = 0; j < strings.length - 1; j++) {
			for (int i = 1; i < strings.length - j; i++) {
				if (strings[i].length() > strings[i - 1].length()) {
					swap(strings, i, i - 1);
				}
			}
		}
		return strings;
	}

	public static void swap(String[] array, int ind1, int ind2) {
		String tmp = array[ind1];
		array[ind1] = array[ind2];
		array[ind2] = tmp;
	}
}