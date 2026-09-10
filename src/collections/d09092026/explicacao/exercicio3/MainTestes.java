package collections.d09092026.explicacao.exercicio3;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class MainTestes {
	
	public static final String MSG_QUEBRA = "// --------------------------------------------------------------\n";
	
	public static void main(String[] args) {
		Set<Pessoa> pessoas = new HashSet<>();
		pessoas.add(new Pessoa("123"));
		pessoas.add(new Pessoa("123")); // duplicada

		System.out.println(pessoas.size()); // 1
		
		
		// ---------------------------------------------------------------------------------
		
		// HashSet: mais rápido, não mantém ordem.
		// LinkedHashSet: mantém ordem de inserção.
		// TreeSet: mantém elementos ordenados automaticamente.
		

		// ---------------------------------------------------------------------------------
		
		 // HashSet: não mantém ordem
        Set<Integer> hash = new HashSet<>();

        hash.add(30);
        hash.add(10);
        hash.add(50);
        hash.add(20);
        hash.add(40);

        System.out.println("HashSet");
        System.out.println(hash);

		System.out.println(MSG_QUEBRA);

		// ---------------------------------------------------------------------------------
        
        // LinkedHashSet: mantém ordem de inserção
        Set<Integer> linked = new LinkedHashSet<>();

        linked.add(30);
        linked.add(10);
        linked.add(50);
        linked.add(20);
        linked.add(40);

        System.out.println("LinkedHashSet");
        System.out.println(linked);

		System.out.println(MSG_QUEBRA);

        // TreeSet: ordena automaticamente
        Set<Integer> tree = new TreeSet<>();

        tree.add(30);
        tree.add(10);
        tree.add(50);
        tree.add(20);
        tree.add(40);

        System.out.println("TreeSet");
        System.out.println(tree);
		System.out.println(MSG_QUEBRA);
		
		// ---------------------------------------------------------------------------------
        
    }
}