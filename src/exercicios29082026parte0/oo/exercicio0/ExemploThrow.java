package exercicios29082026parte0.oo.exercicio0;

public class ExemploThrow {
	public static void main(String[] args) {
		int idade = 15;
		if (idade < 18) {
			throw new IllegalArgumentException("Idade mínima não atingida.");
		}
	}
}
