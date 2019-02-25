package core1;

public class Example {

	public static void main(String[] args) {
		Tester tester = new Tester("Ivan", "Ivanov", 5);
	//	tester.doubledSalary(); // method is private, can be used only inside of class
		tester.experienceInMonth();
		tester.fullName();
		tester.printAll();

	}

}
