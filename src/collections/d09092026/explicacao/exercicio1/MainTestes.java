package collections.d09092026.explicacao.exercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainTestes {
	
	public static final String MSG_QUEBRA = "// --------------------------------------------------------------\n";
	public static void main(String[] args) {

		// --------------------------------------------------------------

		List<Integer> numeros = Arrays.asList(5, 2, 8, 1);

		Collections.sort(numeros);
		System.out.println(numeros);

		Collections.sort(numeros, Collections.reverseOrder());
		System.out.println(numeros);
		System.out.println(MSG_QUEBRA);
		
		// --------------------------------------------------------------

		Pessoa heloisa = new Pessoa("Heloisa Moura");
		Pessoa aluno1 = new Pessoa("Loester Botelho");
		Pessoa aluno2 = new Pessoa("Loester Botelho");

		// duplicado
		List<Pessoa> listaDuplicado = new ArrayList<Pessoa>();

		listaDuplicado.add(aluno1);
		listaDuplicado.add(aluno2);
		listaDuplicado.add(heloisa);

		System.out.println("Set duplicado:");
		System.out.println(listaDuplicado);
		
		System.out.println(MSG_QUEBRA);
		
		// só funciona ordenação se ele for list arraylist
		testarOrdenacao(listaDuplicado);

		System.out.println(MSG_QUEBRA);
		// --------------------------------------------------------------

		// sem duplicar, mas sem ordenação
		Set<Pessoa> lista = new HashSet<Pessoa>();
		lista.add(aluno1);
		lista.add(aluno2);
		lista.add(heloisa);

		System.out.println("Set Sem duplicar:");
		System.out.println(lista);
		System.out.println(MSG_QUEBRA);
	}

	public static void testarOrdenacao(List<Pessoa> lista) {

		if (!(lista instanceof ArrayList)) {
			System.out.println("A lista não é um ArrayList.");
			return;
		}

		System.out.println(MSG_QUEBRA);
		System.out.println("Original:");
		System.out.println(lista);

		System.out.println(MSG_QUEBRA);
		Collections.sort(lista);
		System.out.println("Collections.sort():");
		System.out.println(lista);

		System.out.println(MSG_QUEBRA);
		lista.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
		System.out.println("Lambda:");
		System.out.println(lista);

		System.out.println(MSG_QUEBRA);
		lista.sort(Comparator.comparing(Pessoa::getNome));
		System.out.println("Comparator.comparing:");
		System.out.println(lista);

		System.out.println(MSG_QUEBRA);
		lista.sort(Comparator.comparing(Pessoa::getNome).reversed());
		System.out.println("Reversed:");
		System.out.println(lista);
	}

}
