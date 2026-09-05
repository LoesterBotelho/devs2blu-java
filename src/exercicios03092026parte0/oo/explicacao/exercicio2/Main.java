package exercicios03092026parte0.oo.explicacao.exercicio2;

public class Main {

	public static void main(String[] args) {

		Dado dado = new Dado("Hello World!");
		String texto = dado.getDado();
		
		System.out.println(texto);
		
		// ------------------------------------------------
		
		Dado2<String> d = new Dado2<>("Ola");
		String x = d.getDado();
		
		System.out.println("X = " + x);
		
		// ------------------------------------------------
		
		Dado2<Pessoa> d2 = new Dado2<Pessoa>(new Pessoa("Loester", 20));
		Pessoa x2 = d2.getDado();
		
		System.out.println("X2 = " + x2.toString() );
		

	}

}
