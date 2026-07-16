package test;

public class Person {
	public static void main(String[] args){
		
	int ageYears = 33;
	int ageDays = ageYears * 365;
	long ageSeconds = ageYears * 365 * 24L * 60 * 60;
	
	System.out.println("Você já tem " + ageDays + " dias de idade.");
	System.out.println("Você já tem " + ageSeconds + " segundos de idade.");
	}
}
