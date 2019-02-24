package core;

import java.util.Scanner;

public class Task7_8 {

	public static void main(String[] args) {
		// 8. Ввести n слов с консоли. Среди слов, состоящих только из цифр, найти
		// слово-палиндром. Если таких слов больше одного, найти второе из них.
		int n = 3;
		Scanner scan = new Scanner(System.in);
		String[] array = new String[n];
		System.out.println("Enter " + n + " strings");
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextLine();
		}
		scan.close();
		for (int i = 0; i < array.length; i++) {
			if (array[i].matches("[0-9]+") && isPalindrome(array[i])) {
				{
					System.out.println("Palindrom:" + array[i]);
					break;
				}
			}
		}

	}

	public static boolean isPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}

		}
		return true;

	}
}
