package core1;

public class Tester {
	public String name;
	private String surname;
	protected int experienceInYears;
	String englishLevel;
	public double salary;

	// private constructor
	private Tester(String name) {
		this.name = name;
	}

	protected Tester(String name, String surname) {
		this(name);
		this.surname = surname;
	}

	public Tester(String name, String surname, int experienceInYears) {
		this(name, surname);
		this.experienceInYears = experienceInYears;
	}

	// extratask
	public static Tester createNewTester(String name) {
		Tester newTester = new Tester(name);
		return newTester;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getSurname() {
		return surname;
	}

	void setSurname(String surname) {
		this.surname = surname;
	}

	int getExperienceInYears() {
		return experienceInYears;
	}

	void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}

	String getEnglishLevel() {
		return englishLevel;
	}

	void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	double getSalary() {
		return salary;
	}

	void setSalary(double salary) {
		this.salary = salary;
	}

	private double doubledSalary() {
		return salary * 2;
	}

	int experienceInMonth() {
		return experienceInYears * 12;
	}

	protected void fullName() {
		System.out.println("Full Name: " + name + " " + surname);
	}

	public void printAll() {
		System.out.println(name + " " + surname + " " + experienceInYears + " " + englishLevel + " " + salary);
	}

}
