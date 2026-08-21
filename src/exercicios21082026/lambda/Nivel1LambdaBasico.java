package exercicios21082026.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Nivel1LambdaBasico {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        nomes.add("Carlos");
        nomes.add("Ana");
        nomes.add("Beatriz");

        // 1. Jeito antigo (Classe Anônima antes do Java 8)
        Collections.sort(nomes, new java.util.Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });

        // 2. Jeito com Lambda (Java 8+)
        // O compilador infere os tipos de (String s1, String s2)
        Collections.sort(nomes, (s1, s2) -> s1.compareTo(s2));
        
        System.out.println(nomes);
    }
}