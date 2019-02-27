package core;

public class Sun extends Star{
	public int ligthLength;
	public double time;
	
	public double ligthSpeed(int ligthLength, double time) {
		double lightSpeed=ligthLength/time;
		return lightSpeed;
	}
	
	public void printClassName() {
		System.out.println(getClass());
	}

	int getLigthLength() {
		return ligthLength;
	}

	void setLigthLength(int ligthLength) {
		this.ligthLength = ligthLength;
	}

	double getTime() {
		return time;
	}

	void setTime(double time) {
		this.time = time;
	}
	
	
	
	
	
	

}
