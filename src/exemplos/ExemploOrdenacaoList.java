package exemplos;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ==========================================================
 * ORDENAÇÃO DE LIST
 * ==========================================================
 */
public class ExemploOrdenacaoList {

    public static void main(String[] args) {

        List<String> alunos = new ArrayList<>();

        alunos.add("Carlos");
        alunos.add("Ana");
        alunos.add("Pedro");
        alunos.add("Bruno");
        alunos.add("Lucas");

        System.out.println("Lista original");

        System.out.println(alunos);

        /*
         * Crescente
         */

        alunos.sort(String::compareTo);

        System.out.println("\nCrescente");

        System.out.println(alunos);

        /*
         * Decrescente
         */

        alunos.sort((a, b) -> b.compareTo(a));

        System.out.println("\nDecrescente");

        System.out.println(alunos);

        /*
         * Pelo tamanho da palavra
         */

        alunos.sort(Comparator.comparingInt(String::length));

        System.out.println("\nPor tamanho");

        System.out.println(alunos);

    }

}