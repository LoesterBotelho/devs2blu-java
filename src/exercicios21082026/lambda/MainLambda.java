package exercicios21082026.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

// 1. Interface Funcional Personalizada para o Nível 2
@FunctionalInterface
interface CalculadoraFuncional {
    int calcular(int a, int b);
}

public class MainLambda {
    public static void main(String[] args) {
        System.out.println("------------------------------------------");
        System.out.println("   ESTUDO COMPLETO DE EXPRESSÕES LAMBDA");
        System.out.println("------------------------------------------");

        
        
        // --- NÍVEL 1: Sintaxe Básica ---
        System.out.println("\n\n--- [Nível 1] Sintaxe Básica e Comportamento ---");
        List<String> linguagens = Arrays.asList("Java", "Python", "C++", "JavaScript", "Go");
        
        // Lambda simples com múltiplos parâmetros para ordenação customizada
        linguagens.sort((s1, s2) -> s2.compareTo(s1)); // Ordem decrescente
        System.out.println("Linguagens em ordem decrescente: " + linguagens);

        
        
        // --- NÍVEL 2: Interfaces Funcionais Customizadas ---
        System.out.println("\n\n--- [Nível 2] Interfaces Funcionais Próprias ---");
        CalculadoraFuncional adicao = (a, b) -> a + b;
        CalculadoraFuncional multiplicacao = (a, b) -> a * b;

        System.out.println("Soma (10 + 5): " + adicao.calcular(10, 5));
        System.out.println("Multiplicação (10 * 5): " + multiplicacao.calcular(10, 5));

        
        
        // --- NÍVEL 3: Interfaces Prontas (java.util.function) ---
        System.out.println("\n\n--- [Nível 3] Interfaces Prontas (Predicate, Consumer, etc.) ---");
        
        // Predicate: Filtra números maiores que 5
        List<Integer> numeros = Arrays.asList(2, 4, 6, 8, 10);
        Predicate<Integer> maiorQueCinco = n -> n > 5;
        
        System.out.print("Números maiores que 5: ");
        for (Integer n : numeros) {
            if (maiorQueCinco.test(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();

        // Function: Converte String para o seu tamanho
        Function<String, Integer> conversorTamanho = s -> s.length();
        System.out.println("Tamanho da palavra 'Desenvolvedor': " + conversorTamanho.apply("Desenvolvedor"));

        // Supplier: Fornece um valor padrão
        Supplier<String> tokenSupplier = () -> "TOKEN-XYZ-789456";
        System.out.println("Token gerado: " + tokenSupplier.get());

        
        
        
        // --- NÍVEL 4: Method References ---
        System.out.println("\n\n--- [Nível 4] Method References (Operador ::) ---");
        List<String> nomes = Arrays.asList("ana", "carlos", "beatriz", "joão");

        System.out.println("Imprimindo nomes em maiúsculo usando Method Reference:");
        // Usando referência de método de instância de tipo arbitrário (String::toUpperCase) 
        // em conjunto com Consumer (System.out::println)
        nomes.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);

        System.out.println("\n--- Execução Concluída com Sucesso ---");
    }
}