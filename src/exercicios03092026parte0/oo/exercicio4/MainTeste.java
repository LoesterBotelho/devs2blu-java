package exercicios03092026parte0.oo.exercicio4;

public class MainTeste {

	public static void main(String[] args) {

		Codigo<String, Integer> cod1 = new Codigo<>("LP", 15);
		Codigo<String, Integer> cod2 = new Codigo<>("CPU", 50);

		ValorM preco1 = new ValorM(15000.00, "R$");
		ValorM preco2 = new ValorM(50000.00, "R$");

		ProdutoG2<Codigo<String, Integer>, String, ValorM> produto1 = 
				new ProdutoG2<>(cod1, "Laptop", preco1);

		ProdutoG2<Codigo<String, Integer>, String, ValorM> produto2 = 
				new ProdutoG2<>(cod2, "Computer Workstation", preco2);

		System.out.println(produto1);
		System.out.println(produto2);
	}

}