package exercicios29082026parte0.oo.exercicio0;

public class TesteTryThrows {

	public static String aumentarLetras(String frase) throws NullPointerException {
		return frase.toUpperCase();
	}

	public static void main(String[] args) {
		try {
			System.out.println( aumentarLetras(null) );
		} catch (NullPointerException e) {
			System.out.println("A frase não pode ser nula.");
		}
	}

}
