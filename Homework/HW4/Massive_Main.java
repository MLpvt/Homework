package core;

public class Massive_Main {

	public static void main(String[] args) {
		int size=(int)(Math.random()*10);
		int[] array=new int[size];
		for (int i=0;i<array.length;i++) {
			array[i]=(int)(Math.random()*10);
		}
		Massive massive1=new Massive();
		massive1.printMassiveAsLine(array);
		massive1.printReverseMassiveAsLine(array);
		System.out.println(massive1.getSum(array));
		int[] arrayMultipliedBy3=massive1.multiplyBy3(array);
		massive1.printMassiveAsLine(arrayMultipliedBy3);
		massive1.printReverseMassiveAsLine(arrayMultipliedBy3);
		

	}

}
