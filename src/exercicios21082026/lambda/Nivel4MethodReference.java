package exercicios21082026.lambda;

import java.util.List;
import java.util.Arrays;

public class Nivel4MethodReference {
    public static void main(String[] args) {
        List<String> linguagens = Arrays.asList("java", "python", "c++", "javascript");

        // Jeito com Lambda comum
        linguagens.forEach(s -> System.out.println(s));

        // Jeito com Method Reference (Muito mais limpo)
        linguagens.forEach(System.out::println);
        
        // Transformando para maiúsculo usando Method Reference de tipo arbitrário
        linguagens.stream()
                  .map(String::toUpperCase)
                  .forEach(System.out::println);
    }
}