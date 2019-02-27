package core;

public class Example {

	public static void main(String[] args) {
		Earth earth1=new Earth("Louna");
		Earth earth2=new Earth("Louna");
		System.out.println(earth1.sum(3, 5));
		System.out.println(earth1.proizv(3,2));
		
		Sun sun1 =new Sun();
		sun1.setLigthLength(1000);
		sun1.setTime(0.02);
		System.out.println(sun1.sum(1, 2));
		System.out.println(sun1.proizv(3, 2));
		
		Mars mars1=new Mars(1700);
		Mars mars2=new Mars(1700, "red");
		System.out.println(mars2.sum(5, 4));
		
		Planet planet=new Planet();
		System.out.println(planet.sum(2, 3));
		System.out.println(planet.proizv(4, 4));
		
		Star star =new Star();
		System.out.println(star.sum(2, 9));
		System.out.println(star.proizv(4, 9));
	}

}
