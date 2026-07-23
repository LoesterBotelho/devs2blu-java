package exemplos.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExemploLambda {

    public static void main(String[] args) {

        // Lambda sem parâmetro
        Saudacao saudacao = () -> System.out.println("Olá, mundo!");
        saudacao.executar();

        // Lambda com um parâmetro
        Mensagem mensagem = nome -> System.out.println("Olá " + nome);
        mensagem.exibir("João");

        // Lambda com dois parâmetros
        Soma soma = (a, b) -> a + b;
        System.out.println("Soma: " + soma.calcular(10, 5));

        // Lambda com bloco
        Soma somaCompleta = (a, b) -> {
            System.out.println("Calculando...");
            return a + b;
        };
        System.out.println("Resultado: " + somaCompleta.calcular(20, 10));

        // Predicate -> retorna boolean
        Predicate<Integer> maiorIdade = idade -> idade >= 18;

        System.out.println(maiorIdade.test(20));
        System.out.println(maiorIdade.test(15));

        // Outro Predicate
        Predicate<Integer> numeroPar = n -> n % 2 == 0;

        System.out.println(numeroPar.test(8));
        System.out.println(numeroPar.test(7));

        // Function -> transforma valor
        Function<String, Integer> tamanhoTexto =
                texto -> texto.length();

        System.out.println(tamanhoTexto.apply("Java"));

        // Outra Function
        Function<Double, Double> dobro =
                valor -> valor * 2;

        System.out.println(dobro.apply(15.0));

        // Consumer -> executa ação
        Consumer<String> imprimir =
                texto -> System.out.println(texto);

        imprimir.accept("Usando Consumer");

        // Consumer com formatação
        Consumer<String> caixaAlta =
                texto -> System.out.println(texto.toUpperCase());

        caixaAlta.accept("java");

        // Supplier -> gera valor
        Supplier<String> fornecedor =
                () -> "Valor gerado";

        System.out.println(fornecedor.get());

        // Supplier de número aleatório
        Supplier<Integer> aleatorio =
                () -> (int) (Math.random() * 100);

        System.out.println(aleatorio.get());

        // Lista de nomes
        List<String> nomes =
                Arrays.asList("Ana", "Carlos", "Maria");

        // forEach com lambda
        nomes.forEach(nome -> System.out.println(nome));

        // Method Reference
        nomes.forEach(System.out::println);

        // Lista de números
        List<Integer> numeros =
                Arrays.asList(10, 15, 20, 25, 30);

        // Filter
        numeros.stream()
                .filter(n -> n > 20)
                .forEach(System.out::println);

        // Filtrar pares
        numeros.stream()
                .filter(numeroPar)
                .forEach(System.out::println);

        // Map
        List<String> cursos =
                Arrays.asList("java", "spring", "docker");

        cursos.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Converter para tamanho
        cursos.stream()
                .map(String::length)
                .forEach(System.out::println);

        // Reduce (somatório)
        int total = numeros.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("Total: " + total);

        // Count
        long quantidade = numeros.stream()
                .filter(n -> n > 15)
                .count();

        System.out.println("Quantidade: " + quantidade);

        // AnyMatch
        boolean existeMaior30 = numeros.stream()
                .anyMatch(n -> n > 30);

        System.out.println(existeMaior30);

        // AllMatch
        boolean todosPositivos = numeros.stream()
                .allMatch(n -> n > 0);

        System.out.println(todosPositivos);

        // Ordenação crescente
        List<String> frutas =
                Arrays.asList("Banana", "Maçã", "Abacaxi");

        frutas.sort((f1, f2) -> f1.compareTo(f2));

        frutas.forEach(System.out::println);

        // Ordenação decrescente
        frutas.sort((f1, f2) -> f2.compareTo(f1));

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