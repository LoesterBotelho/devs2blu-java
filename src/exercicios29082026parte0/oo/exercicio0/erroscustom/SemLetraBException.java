package exercicios29082026parte0.oo.exercicio0.erroscustom;

public class SemLetraBException extends Exception {
	@Override
	public String getMessage() {
		return "Não existe a letra B na frase.";
	}
}
