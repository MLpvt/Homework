package core;

import java.util.Scanner;

public class Task7_6 {

	public static void main(String[] args) {
		// 6. Ввести n слов с консоли. Найти слово, символы в котором идут в строгом
		// порядке возрастания их кодов. Если таких слов несколько, найти первое из них.
		int n = 3;
		Scanner scan = new Scanner(System.in);
		String[] array = new String[n];
		System.out.println("Enter " + n + " strings");
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextLine();
		}
		scan.close();
		for (int i = 0; i < array.length; i++) {
			if (isAscendingChars(array[i])) {
				System.out.println("Word with acsending order of characters " + array[i]);
				break;
			}

		}

	}

	private static boolean isAscendingChars(String str) {
		char chars[] = str.toCharArray();
		int count = 0;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i - 1] < chars[i]) {
				count++;
			}
		}
		return (count == chars.length - 1);
	}

}
