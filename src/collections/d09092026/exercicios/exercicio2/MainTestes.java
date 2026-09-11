package collections.d09092026.exercicios.exercicio2;

import java.util.ArrayList;

public class MainTestes {

	public static void main(String[] args) {

		ArrayList<Double> precos = new ArrayList<>();

		precos.add(50_000.00);
		precos.add(150_000.00);
		precos.add(450_000.00);
		precos.add(1_000_000.00);
		precos.add(2_100_000.00);
		precos.add(3_000_000.00);

		System.out.println("\nPreços dos produtos:");

		for (Double preco : precos) {

			System.out.println("R$ " + preco);

		}

		System.out.println("\nQuantidade de produtos: " + precos.size());

		//-------------------------------------------------------------------------
		
		precos.set(0, 75_000.00); // obs.: lembra o primeiro começa com 0

		precos.remove(1); // obs.: lembra o 1 é 2 porque começa com 0 1 2 3 4 5 etc..

		//-------------------------------------------------------------------------
		
		double total = 0;

		for (Double preco : precos) {
			total += preco;
		}

		System.out.println("\nValor total: R$ " + total);

		//-------------------------------------------------------------------------
		
		double maiorPreco = Double.MIN_VALUE;
		double menorPreco = Double.MAX_VALUE;

		for (Double preco : precos) {

		    if (preco > maiorPreco) {
		        maiorPreco = preco;
		    }

		    if (preco < menorPreco) {
		        menorPreco = preco;
		    }
		}
		

		System.out.println("\nMaior preço: R$ " + maiorPreco);
		System.out.println("Menor preço: R$ " + menorPreco);

		//-------------------------------------------------------------------------
		
		System.out.println("\nLista após as alterações:");

		for (Double preco : precos) {

			System.out.println("R$ " + preco);

		}

		//-------------------------------------------------------------------------
	}
}


