package core;

import java.util.Scanner;

public class Task7_1 {

	public static void main(String[] args) {

		int n = (int) (Math.random() * 10);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter " + n + " row");
		String[] str = new String[n];
		for (int i = 0; i < n; i++) {
			str[i] = scanner.nextLine();
		}
		scanner.close();
		System.out.println("The shortest string: " + minStr(str) + ". Length:" + minStr(str).length());
		System.out.println("The longest string: " + maxStr(str) + ". Length:" + maxStr(str).length());

	}

	public static String minStr(String anyMas[]) {
		int min_length = anyMas[0].length();
		String min_str = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {
			if (anyMas[i].length() < min_length) {
				min_str = anyMas[i];
				min_length = anyMas[i].length();
			}
		}
		return min_str;
	}

	public static String maxStr(String anyMas[]) {
		int max_length = anyMas[0].length();
		String max_str = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {
			if (anyMas[i].length() > max_length) {
				max_str = anyMas[i];
				max_length = anyMas[i].length();
			}
		}
		return max_str;
	}

}
