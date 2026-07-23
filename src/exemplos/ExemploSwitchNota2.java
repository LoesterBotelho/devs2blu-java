package exemplos;

public class ExemploSwitchNota2 {

	public static void main(String[] args) {

		int nota = 85;
		char conceito;

		if (nota >= 90) {
			conceito = 'A';
		} else if (nota >= 80) {
			conceito = 'B';
		} else if (nota >= 70) {
			conceito = 'C';
		} else if (nota >= 60) {
			conceito = 'D';
		} else {
			conceito = 'F';
		}

		// byte short int char
		switch (conceito) {
		case 'A':
			System.out.println("Nota: " + nota + " - Excelente");
			break;

		case 'B':
			System.out.println("Nota: " + nota + " - Bom");
			break;

		case 'C':
			System.out.println("Nota: " + nota + " - Regular");
			break;

		case 'D':
			System.out.println("Nota: " + nota + " - Precisa melhorar");
			break;

		case 'F':
			System.out.println("Nota: " + nota + " - Reprovado");
			break;

		default:
			System.out.println("Nota inválida");
		}
	}
}