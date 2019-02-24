package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task7_4 {
//4. Ввести n слов с консоли. Найти слово, в котором число различных символов минимально. Если таких слов несколько, найти первое из них.
	public static void main(String args[]) {
		int n = 3;
		Scanner scan = new Scanner(System.in);
		String[] array = new String[n];
		System.out.println("Enter " + n + " strings");
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextLine();
		}
		scan.close();
		int[] distinctElementsArray = countDistinct(array);
		int min = distinctElementsArray[0];
		int minIndex = 0;
		for (int i = 0; i < array.length; i++) {
			if (distinctElementsArray[i] < min) {
				min = distinctElementsArray[i];
				minIndex = i;
			}
		}

		System.out.println("Word with min number of distinct symbols: " + array[minIndex]);

	}

	public static String[] sortAsc(String[] array) {
		char[] chars = null;
		String[] sorted = new String[array.length];
		for (int i = 0; i < array.length; i++) {
			chars = array[i].toCharArray();
			Arrays.sort(chars);
			sorted[i] = String.valueOf(chars);
		}
		return sorted;
	}

	public static int countDistinct(String str) {
		if (str.length() == 1 || str.length() == 0) {
			return str.length();
		}
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) != str.charAt(i - 1)) {
				count++;
			}
		}

		return count;
	}

	public static int[] countDistinct(String[] array) {
		array = sortAsc(array);
		int[] count = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			count[i] = countDistinct(array[i]);
		}
		return count;
	}

}
