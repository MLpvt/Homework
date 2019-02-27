package core;

public class Mars extends Planet{
	public double temperature;
	public String color;
	
	public Mars(double temperature) {
		this.temperature=temperature;
	}
	public Mars(double temperature, String color) {
		this.temperature=temperature;
		this.color=color;
	}
	
	public void printTempeature() {
		System.out.println(temperature);
	}
	public void printColor() {
		System.out.println(color);
	}

}
