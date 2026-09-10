package collections.d09092026.explicacao.exercicio2;

public class MainTestes {
	public static void main(String[] args) {
		
		// --------------------------------------------------------------
		
		Money income = new Money(55, "USD");
		Money expenses = new Money(55, "USD");
		boolean balanced = income.equals(expenses);
		
		System.out.println("objetos são iguais ? : " + balanced);

		// --------------------------------------------------------------
		
		
		
		Money m1 = new Money(10, "BRL");
		Money m2 = new Money(20, "BRL");
		Money m3 = new Money(10, "USD");
		
		
		
		Integer v1 = m1.compareTo(m2); // -1
		Integer v2 = m2.compareTo(m1); // 1
		Integer v3 = m1.compareTo(m3); // negativo ("BRL" < "USD")
		
		
		System.out.println("m1.compareTo(m2) = " + v1 );
		System.out.println("m2.compareTo(m1) = " + v2 );
		System.out.println("m1.compareTo(m3) = " + v3 );
		
		// --------------------------------------------------------------
		
	}
}
