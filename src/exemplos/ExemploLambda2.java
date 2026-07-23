package exemplos;
import java.util.Arrays;
import java.util.List;

public class ExemploLambda2 {

    public static void main(String[] args) {

        /*
         * Criando uma lista de nomes utilizando Arrays.asList()
         */
        List<String> nomes = Arrays.asList(
                "Carlos",
                "Ana",
                "Pedro",
                "Mariana",
                "João"
        );

        System.out.println("=== Lista Original ===");

        /*
         * Lambda substituindo uma implementação anônima.
         *
         * nome -> parâmetro recebido
         * System.out.println(nome) -> ação executada
         */
        nomes.forEach(nome -> System.out.println(nome));

        System.out.println("\n=== Nomes com mais de 5 letras ===");

        /*
         * filter()
         * Filtra somente os elementos que atendem à condição.
         */
        nomes.stream()
                .filter(nome -> nome.length() > 5)
                .forEach(nome -> System.out.println(nome));

        System.out.println("\n=== Nomes em Maiúsculo ===");

        /*
         * map()
         * Transforma cada elemento da coleção.
         */
        nomes.stream()
                .map(nome -> nome.toUpperCase())
                .forEach(nome -> System.out.println(nome));

        System.out.println("\n=== Ordenação Alfabética ===");

        /*
         * sorted()
         * Ordena utilizando expressão lambda.
         */
        nomes.stream()
                .sorted((n1, n2) -> n1.compareTo(n2))
                .forEach(System.out::println);

        /*
         * count()
         * Conta quantos elementos existem na stream.
         */
        long quantidade = nomes.stream()
                               .count();

        System.out.println("\nQuantidade de nomes: " + quantidade);
    }
}