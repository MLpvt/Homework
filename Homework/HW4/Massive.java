package core;

public class Massive {
	public void printMassiveAsLine(int[] massive) {
		for (int i = 0; i < massive.length; i++) {
			System.out.print(massive[i] + " ");
		}
		System.out.println();

	}

	public void printReverseMassiveAsLine(int[] massive) {
		for (int i = massive.length-1; i >=0; i--) {
			System.out.print(massive[i] + " ");
		}
		System.out.println();
	}

	public int getSum(int[] massive) {
		int sum = 0;
		for (int i = 0; i < massive.length; i++) {
			sum = sum + massive[i];
		}
		return sum;
		
	}

	public int[] multiplyBy3(int[] massive) {
		int[] massive2 = massive;
		for (int i = 0; i < massive.length; i++) {
			massive2[i] = massive[i] * 3;
		}
		return massive2;
	}
}
