package exemplos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExemploLambda {

    public static void main(String[] args) {

        // 1. Lambda sem parâmetro
        Saudacao saudacao = () -> System.out.println("Olá, mundo!");
        saudacao.executar();
        
        // 2. Lambda com um parâmetro
        Mensagem msg = nome -> System.out.println("Olá " + nome);
        msg.exibir("João");

        // 3. Lambda com dois parâmetros
        Soma soma = (a, b) -> a + b;
        System.out.println("Soma: " + soma.calcular(10, 5));

        // 4. Lambda com bloco de código
        Soma somaCompleta = (a, b) -> {
            System.out.println("Calculando...");
            return a + b;
        };
        System.out.println("Resultado: " + somaCompleta.calcular(20, 10));

        // 5. Predicate -> retorna boolean
        Predicate<Integer> maiorIdade = idade -> idade >= 18;

        System.out.println(maiorIdade.test(20));
        System.out.println(maiorIdade.test(15));

        // 6. Function -> recebe e retorna valor
        Function<String, Integer> tamanhoTexto =
                texto -> texto.length();

        System.out.println(
                tamanhoTexto.apply("Java")
        );

        // 7. Consumer -> consome um valor
        Consumer<String> imprimir =
                texto -> System.out.println(texto);

        imprimir.accept("Usando Consumer");

        // 8. Supplier -> fornece um valor
        Supplier<String> fornecedor =
                () -> "Valor gerado";

        System.out.println(fornecedor.get());

        // 9. forEach com lambda
        List<String> nomes =
                Arrays.asList("Ana", "Carlos", "Maria");

        nomes.forEach(nome ->
                System.out.println(nome));

        // 10. Filtrando com Predicate
        List<Integer> numeros =
                Arrays.asList(10, 15, 20, 25, 30);

        numeros.stream()
                .filter(n -> n > 20)
                .forEach(System.out::println);

        // 11. Convertendo valores com map
        List<String> cursos =
                Arrays.asList("java", "spring", "docker");

        cursos.stream()
                .map(curso -> curso.toUpperCase())
                .forEach(System.out::println);

        // 12. Ordenação usando Lambda
        List<String> frutas =
                Arrays.asList("Banana", "Maçã", "Abacaxi");

        frutas.sort((f1, f2) ->
                f1.compareTo(f2));

        frutas.forEach(System.out::println);

        // 13. Method Reference
        frutas.forEach(System.out::println);
    }
}

/* Interfaces Funcionais */

@FunctionalInterface
interface Saudacao {
    void executar();
}

@FunctionalInterface
interface Mensagem {
    void exibir(String nome);
}

@FunctionalInterface
interface Soma {
    int calcular(int a, int b);
}