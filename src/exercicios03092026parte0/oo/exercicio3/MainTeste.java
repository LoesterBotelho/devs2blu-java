package exercicios03092026parte0.oo.exercicio3;

public class MainTeste {
	public static void main(String[] args) {

		
		Codigo<String, Integer> cod1 = new Codigo<>("LP", 15);
		Codigo<Character, Integer> cod2 = new Codigo<>('C', 50);


		ProdutoG<Codigo<String, Integer>, String, Double> produto1 = new ProdutoG<>(cod1, "Laptop", 15000.00);
		ProdutoG<Codigo<Character, Integer>, String, Double> produto2 = new ProdutoG<>(cod2, "Computer Workstation", 50000.00);

		
		System.out.println(produto1);
		System.out.println(produto2);
		
		
	}
}