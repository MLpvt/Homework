package core;

import java.util.Scanner;

public class Task7_5 {

	public static void main(String[] args) {
		// 5. Ввести n слов с консоли. Найти количество слов, содержащих только символы
		// латинского алфавита, а среди них – количество слов с равным числом гласных и
		// согласных букв.
		int n = 3;
		Scanner scan = new Scanner(System.in);
		String[] array = new String[n];
		System.out.println("Enter " + n + " strings");
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextLine();
		}
		scan.close();
		int countLatin = 0;
		int consonantsEqualVowels = 0;
		for (int i = 0; i < n; i++) {
			if (array[i].matches("[a-zA-Z]+")) {
				countLatin++;
				if (isConsonantsEqualVowels(array[i])) {
					consonantsEqualVowels++;
				}
			}
		}
		System.out.println("Number of Latin: " + countLatin);
		System.out.println("Number of consonantsEqualVowels: " + consonantsEqualVowels);

	}

	public static int countVowel(String str) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if ("AEIOUaeiou".indexOf(str.charAt(i)) != -1) {
				count++;
			}
		}
		return count;

	}

	public static boolean isConsonantsEqualVowels(String str) {
		int numVowel = countVowel(str);
		return str.length() - numVowel == numVowel;
	}

}
