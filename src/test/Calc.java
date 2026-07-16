package test;

public class Calc {
	public static void main(String[] args) {
		
		int x = 10 +20 +30 / 3;   //x=40
		int y = 10 +20 +(30 / 3); //x=40
		int z = (10 +20 +30) / 3; //x=20
		
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);

		int alpha = 25 - 5 * 4 / 2 - 10 + 4;
		System.out.println("alpha = " + alpha);
		
		int omega = (((25 - ((5 * 4) / 2 )) - 10) + 4);
		System.out.println("omega = " + omega);
		
		int beta = (((25 - 5) * 4) / (2 - 10)) + 4;
		System.out.println("beta = " + beta);
		
		
	}
	

	
}