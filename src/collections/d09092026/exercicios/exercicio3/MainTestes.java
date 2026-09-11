package collections.d09092026.exercicios.exercicio3;

import java.util.ArrayList;

public class MainTestes {

	public static void main(String[] args) {

		ArrayList<String> listaCompras = new ArrayList<>();

		// --------------------------------------------------------
		
		listaCompras.add("Arroz");
		listaCompras.add("Feijão Preto");
		listaCompras.add("Leite Ninho Original");
		listaCompras.add("Café 3 Coração");
		listaCompras.add("Pão Integral");
		listaCompras.add("Ovos C/ 30");
		listaCompras.add("Açúcar Refinado Cristal");
		listaCompras.add("Doritos XD");

		// --------------------------------------------------------
		
		System.out.println("\nLista de compras:");

		for (String produto : listaCompras) {
			System.out.println(produto);
		}
		
		// --------------------------------------------------------
		
		if (listaCompras.contains("Arroz")) {
			System.out.println("\nArroz está na lista.");
		} else {
			System.out.println("\nArroz não está na lista.");
		}

		// --------------------------------------------------------
		
		System.out.println("\nPosição do Leite: " + listaCompras.indexOf("Leite"));

		// --------------------------------------------------------
		
		listaCompras.set(5, "Queijo");

		// --------------------------------------------------------
		
		listaCompras.remove(6);

		// --------------------------------------------------------
		
		System.out.println("\nQuantidade restante: " + listaCompras.size());

		// --------------------------------------------------------
		
		System.out.println("\nLista de compras após as alterações:");

		for (String produto : listaCompras) {

			System.out.println(produto);

		}

		// --------------------------------------------------------

		// tem café ?
		
		if (listaCompras.contains("Café")) {
			listaCompras.remove("Café");
			System.out.println("\nCafé foi removido da lista. :( | Eu volto depois só para comprar café mais barato XD");
		}
		
		// --------------------------------------------------------
		
	}

}

