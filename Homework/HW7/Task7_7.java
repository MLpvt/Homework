package core;

import java.util.Arrays;
import java.util.Scanner;

public class Task7_7 {

	public static void main(String[] args) {
		// 7. Ввести n слов с консоли. Найти слово, состоящее только из различных
		// символов. Если таких слов несколько, найти первое из них.
		int n = 3;
		Scanner scan = new Scanner(System.in);
		String[] array = new String[n];
		System.out.println("Enter " + n + " strings");
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextLine();
		}
		scan.close();
		int[] countDistinct = countDistinct(array);
		for (int i = 0; i < countDistinct.length; i++) {
			if (countDistinct[i] == array[i].length()) {
				System.out.println("Word with unique characters " + array[i]);
				break;
			}

		}

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
