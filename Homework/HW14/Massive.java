package core;

public class Massive {
	private int size;
	private String name;
	private int[] anyMas;

	public Massive(int[] anyMas) {
		this.anyMas = anyMas;
	}

	public int sum() {
		int sum = 0;
		for (int i = 0; i < anyMas.length; i++) {
			sum = sum + anyMas[i];
		}

		return sum;
	}

	public int proizv() {
		int proizv = 1;
		for (int i = 0; i < anyMas.length; i++) {
			proizv = proizv * anyMas[i];
		}

		return proizv;

	}

	public int zeroDivision() {

		return 2 / 0;

	}

	public int[] reverseArray() {
		int[] reverseArray = new int[anyMas.length];
		for (int i = 0; i < anyMas.length; i++) {
			reverseArray[i] = anyMas[anyMas.length - 1 - i];
		}
		return reverseArray;
	}

	public int minElement() {
		int min = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {

			if (anyMas[i] < min) {
				min = anyMas[i];
			}

		}
		return min;

	}

}
