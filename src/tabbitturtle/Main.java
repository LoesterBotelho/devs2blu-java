package tabbitturtle;

public class Main {

	public static void main(String[] args) {

		Lista lista = new Lista();

		lista.adicionar(10);
		lista.adicionar(20);
		lista.adicionar(30);
		lista.adicionar(40);
		lista.adicionar(50);

		System.out.println("Lista normal:");

		lista.imprimir();

		System.out.println("Possui ciclo? " + lista.possuiCiclo());

		System.out.println("\nCriando ciclo...");

		lista.criarCiclo();

		System.out.println("Possui ciclo? " + lista.possuiCiclo());

	}
}