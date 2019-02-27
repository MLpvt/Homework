package core;

public class Star extends StarSystem{
	public boolean beautiful;
	public String color;
	
	
	public void beautiful() {
		System.out.println("I am beautiful");
	}
	
	public String getColor() {
		return color;
	}

	@Override
	public int sum(int a, int b) {
		
		return a+b;
	}

	@Override
	public int proizv(int a, int b) {
		
		return a*b;
	}

}
