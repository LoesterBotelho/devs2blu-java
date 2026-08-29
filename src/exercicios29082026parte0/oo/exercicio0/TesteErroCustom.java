package exercicios29082026parte0.oo.exercicio0;

import exercicios29082026parte0.oo.exercicio0.erroscustom.SemLetraBException;

public class TesteErroCustom {
	public static void verificarFrase(String frase) throws SemLetraBException {
		
		if (!frase.toLowerCase().contains("b")) {
			throw new SemLetraBException();
		}
		
	}

	public static void main(String[] args) {
		
		try {
			verificarFrase("Java");
		} catch (SemLetraBException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
