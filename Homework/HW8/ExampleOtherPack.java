package core;
import core1.Tester;

public class ExampleOtherPack {

	public static void main(String[] args) {
		Tester tester = new Tester("Ivan", "Ivanov", 5);
			tester.doubledSalary(); // method is private, can be used only inside the class
			tester.experienceInMonth(); //method is friendly, can be used only inside the package
			tester.fullName(); //method is protected, can be used only inside the package and in child classes in other packages
			tester.printAll();
	}

}
