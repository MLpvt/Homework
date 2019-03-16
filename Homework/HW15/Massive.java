package core;

public class Massive {
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

	public double[] arrayDivisionBy(int divider) {
		double[] newArray = new double[anyMas.length];
		for (int i = 0; i < anyMas.length; i++) {
			newArray[i] = anyMas[i] / divider;
		}
		return newArray;

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

	public int maxElement() {
		int max = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {

			if (anyMas[i] > max) {
				max = anyMas[i];
			}
		}
		return max;

	}

	public int minNumber() {
		int min_num = 0;
		int min = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {

			if (anyMas[i] < min) {
				min_num = i;
				min = anyMas[i];
			}
		}
		return min_num;

	}

	public int maxNumber() {
		int max_num = 0;
		int max = anyMas[0];
		for (int i = 0; i < anyMas.length; i++) {
			if (anyMas[i] > max) {
				max = anyMas[i];
				max_num = i;
			}

		}
		return max_num;
	}

	public int countZeroElement() {
		int count = 0;
		for (int i = 0; i < anyMas.length; i++) {
			if (anyMas[i] == 0) {
				count = count + 1;
			}

		}
		return count;
	}

}
