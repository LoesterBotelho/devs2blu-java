package exercicios29082026parte0.oo.exercicio0;

public class TesteEnviaExcecaoTry {
	public static void main(String[] args) {
		
		String frase = null;
		String novaFrase = null;
		
		try {
			novaFrase = frase.toUpperCase();
		} catch (NullPointerException e) {
			frase = "Frase vazia";
			novaFrase = frase.toUpperCase();
		}
		
		System.out.println("Frase antiga: " + frase);
		System.out.println("Frase nova: " + novaFrase);

	}
}
