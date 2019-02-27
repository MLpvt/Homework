package core;

public class Planet extends StarSystem{
	public int radius;
	public double speed;
	
	public int getRadius(int radius) {
		return radius;
	}
	public double getSpeed (double speed) {
		return speed;
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
