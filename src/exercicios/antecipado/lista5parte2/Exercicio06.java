package exercicios.antecipado.lista5parte2;

public class Exercicio06 {

	public static void main(String[] args) {

		int numero = 1001;
		int contador = 0;

		while (contador < 5) {

			if (numero % 11 == 5) {
				contador++;
				System.out.println(contador + "º número: " + numero);
			}

			numero++;
		}

	}
}