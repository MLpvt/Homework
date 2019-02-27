package core;

public abstract class StarSystem {
	public int age;
	public String name;
	
	public void printAge(int age) {
		System.out.println(age);
	}
	public void printName(String name) {
		System.out.println(name);
	}
	
	public abstract int sum( int a, int b);
	public abstract int proizv( int a, int b);

}
