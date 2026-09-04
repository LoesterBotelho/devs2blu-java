package exercicios03092026parte0.oo.exercicio2;

public class MainTeste {
	public static void main(String[] args) {

		
        Codigo cod1 = new Codigo("LP", 15);
        Codigo cod2 = new Codigo("CPU", 50);


        ProdutoG<Codigo, String, Double> produto1 = new ProdutoG<>(cod1, "Laptop", 15000.00);
        ProdutoG<Codigo, String, Double> produto2 = new ProdutoG<>(cod2, "Computer Workstation", 50000.00);


        System.out.println(produto1);
        System.out.println(produto2);
        
        
    }
}