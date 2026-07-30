package tabbitturtle;

public class Lista {

	private Node inicio;

	public void adicionar(int valor) {

		Node novo = new Node(valor);

		if (inicio == null) {
			inicio = novo;
			return;
		}

		Node atual = inicio;

		while (atual.proximo != null) {
			atual = atual.proximo;
		}

		atual.proximo = novo;
	}

	// Cria um ciclo manualmente
	public void criarCiclo() {

		Node ultimo = inicio;
		Node segundo = inicio.proximo;

		while (ultimo.proximo != null) {
			ultimo = ultimo.proximo;
		}

		// último aponta para o segundo nó
		ultimo.proximo = segundo;
	}

	// Algoritmo Floyd Rabbit/Turtle
	public boolean possuiCiclo() {

		Node turtle = inicio;
		Node rabbit = inicio;

		while (rabbit != null && rabbit.proximo != null) {

			turtle = turtle.proximo;

			rabbit = rabbit.proximo.proximo;

			if (turtle == rabbit) {

				return true;
			}
		}

		return false;
	}

	public void imprimir() {

		Node atual = inicio;

		int contador = 0;

		while (atual != null && contador < 10) {

			System.out.print(atual.valor + " -> ");

			atual = atual.proximo;

			contador++;
		}

		System.out.println("...");
	}
}