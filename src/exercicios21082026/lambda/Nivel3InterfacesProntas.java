package exercicios21082026.lambda;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Nivel3InterfacesProntas {
    public static void main(String[] args) {
        // 1. Predicate: Verifica se o número é par
        Predicate<Integer> ehPar = n -> n % 2 == 0;
        System.out.println("4 é par? " + ehPar.test(4)); // true

        // 2. Consumer: Imprime uma string em maiúsculo
        Consumer<String> imprimir = texto -> System.out.println(texto.toUpperCase());
        imprimir.accept("olá mundo lambda"); // OLÁ MUNDO LAMBDA

        // 3. Function: Converte String para o seu tamanho (Integer)
        Function<String, Integer> tamanhoString = s -> s.length();
        System.out.println("Tamanho de 'Java': " + tamanhoString.apply("Java")); // 4

        // 4. Supplier: Fornece uma nova String padrão
        Supplier<String> fabrciadorDeTexto = () -> "Conexão Estabelecida";
        System.out.println(fabrciadorDeTexto.get()); // Conexão Estabelecida
    }
}