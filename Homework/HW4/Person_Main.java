package core;

public class Person_Main {

	public static void main(String[] args) {
		Person person1=new Person();
		person1.setName("Masha");
		person1.setSurname("Ivanova");
		person1.setAge(16);
		person1.setPhone(12345);
		person1.printAllInformation();
		person1.printName();
		System.out.println(person1.isAddult());

	}

}
