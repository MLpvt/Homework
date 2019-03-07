package core;

public class Example {

	public static void main(String[] args) {
		int[] array = { 1, 3, 4, 5 };
		Massive massive = new Massive(array);
		massive.sum(array);
		massive.proizv(array);
		massive.halfSum(array);
		massive.printArray(array);
		massive.printFileData("1.txt");
	}

}
