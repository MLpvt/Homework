package core;

import java.io.FileInputStream;
import java.io.IOException;

public class Massive {
	private int size;
	private String name;
	private String type;
	private int[] anyMas;
//	 классе написать как минимум 4 метода, в каждом методе добавить проверку на исключительные ситуации, используя: 
//		 1. try- catch
//		 2. try-catch, где catch будет несколько
//		 3. try -catch, с использованием multi-catch
//		 4. try-catch-finally
//		 продемонстрировать обработку исключительных ситуаций на примерах.

	public Massive(int[] anyMas) {
		this.anyMas = anyMas;
	}

	public int sum(int[] anyMas) {
		int sum = 0;
		for (int i = 0; i < anyMas.length; i++) {
			sum = sum + anyMas[i];
		}
		try {
			anyMas[anyMas.length] = 5;
		} catch (ArrayIndexOutOfBoundsException ex1) {
			System.out.println("Array is out of bounds");
		}
		return sum;
	}

	public int proizv(int[] anyMas) {
		int proizv = 1;
		for (int i = 0; i < anyMas.length; i++) {
			proizv = proizv * anyMas[i];
		}

		try {
			anyMas[anyMas.length] = 5;
			int result = 5 / 0;
		} catch (ArrayIndexOutOfBoundsException ex1) {
			System.out.println("Array is out of bounds");
		} catch (ArithmeticException ex2) {
			System.out.println("You are trying to devide by zero");
		}
		return proizv;

	}

	public int halfSum(int[] anyMas) {
		try {
			int result = 5 / 0;
			anyMas[anyMas.length] = 5;

		} catch (ArrayIndexOutOfBoundsException | ArithmeticException ex1) {
			ex1.printStackTrace();
		}
		return sum(anyMas) / 2;
	}

	public void printArray(int[] anyMas) {
		for (int i = 0; i < size; i++) {

			System.out.print(anyMas[i] + " ");
		}
		try {
			anyMas[anyMas.length] = 5;
		} catch (ArrayIndexOutOfBoundsException ex1) {
			System.out.println("Array is out of bounds");
		} finally {
			System.out.println("The End");
		}
	}

	public void printFileData(String filename) {
		try (FileInputStream in = new FileInputStream(filename)) {

			System.out.println("Data: " + (char) in.read());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
