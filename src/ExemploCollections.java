import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe de exemplo para demonstrar o uso de:
 * - List
 * - ArrayList
 * - Collections
 */
public class ExemploCollections {

    public static void main(String[] args) {

        /*
         * List é uma interface da Collection Framework.
         * ArrayList é uma implementação dessa interface.
         *
         * Utilizamos a interface List na declaração porque
         * isso torna o código mais flexível e desacoplado.
         */
        List<String> nomes = new ArrayList<>();

        // Adicionando elementos na lista
        nomes.add("Carlos");
        nomes.add("Ana");
        nomes.add("Pedro");
        nomes.add("Mariana");
        nomes.add("João");

        // Exibindo a lista original
        System.out.println("Lista original:");
        System.out.println(nomes);

        /*
         * size()
         * Retorna a quantidade de elementos da lista.
         */
        System.out.println("\nQuantidade de elementos: " + nomes.size());

        /*
         * get(index)
         * Retorna o elemento de uma posição específica.
         */
        System.out.println("Elemento na posição 2: " + nomes.get(2));

        /*
         * contains()
         * Verifica se um elemento existe na lista.
         */
        if (nomes.contains("Ana")) {
            System.out.println("Ana está na lista.");
        }

        /*
         * remove()
         * Remove um elemento específico.
         */
        nomes.remove("Pedro");

        System.out.println("\nLista após remover Pedro:");
        System.out.println(nomes);

        /*
         * Collections.sort()
         * Ordena os elementos em ordem crescente.
         */
        Collections.sort(nomes);

        System.out.println("\nLista ordenada:");
        System.out.println(nomes);

        /*
         * Collections.reverse()
         * Inverte a ordem dos elementos.
         */
        Collections.reverse(nomes);

        System.out.println("\nLista invertida:");
        System.out.println(nomes);

        /*
         * Collections.shuffle()
         * Embaralha os elementos aleatoriamente.
         */
        Collections.shuffle(nomes);

        System.out.println("\nLista embaralhada:");
        System.out.println(nomes);

        /*
         * Percorrendo a lista com foreach.
         */
        System.out.println("\nPercorrendo a lista:");

        for (String nome : nomes) {
            System.out.println(nome);
        }

        /*
         * isEmpty()
         * Verifica se a lista está vazia.
         */
        System.out.println("\nA lista está vazia? " + nomes.isEmpty());

        /*
         * clear()
         * Remove todos os elementos da lista.
         */
        nomes.clear();

        System.out.println("Lista após clear(): " + nomes);

        System.out.println("A lista está vazia agora? " + nomes.isEmpty());
    }
}