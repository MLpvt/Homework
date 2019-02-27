package core;

public class Earth extends Planet{

	public String sputnic;
	public int water;
	
	public Earth (String sputnic) {
		this.sputnic=sputnic;
	}
	public Earth (String sputnic, int water) {
		this(sputnic);
		this.water=water;
	}
	
	public boolean isWater(int water) {
		return (water>0);
	}
	public void sputnic(String sputnic) {
		System.out.println(sputnic);
	}
	
}
