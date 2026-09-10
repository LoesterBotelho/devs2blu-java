package collections.d09092026.explicacao.exercicio4;

import java.util.Hashtable;

public class Main {
	public static void main(String[] args) {

		Hashtable<Integer, String> tabela = new Hashtable<>();

		tabela.put(1, "Ana");
		tabela.put(2, "Bruno");
		tabela.put(3, "Carlos");

		System.out.println(tabela);

		String nome = tabela.get(2);

		System.out.println(nome); // Bruno

		tabela.containsKey(1);

		tabela.containsValue("Ana");

		for (Integer chave : tabela.keySet()) {
			System.out.println(chave + " = " + tabela.get(chave));
		}

		tabela.forEach((chave, valor) -> System.out.println(chave + " = " + valor));
		
		
		/*
		Hashtable<Integer, String> tabela = new Hashtable<>();
		tabela.put(null, "Teste"); // Exception		
		tabela.put(1, null); // Exception
		*/

	}
}