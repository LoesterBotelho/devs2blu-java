package exercicios24072026.explicacao;
import java.util.ArrayList;
import java.util.List;

class Pessoa {
    String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }
}

public class MainTestes {

    public static void main(String[] args) {

        // =====================================
        // WHILE 1
        // =====================================
        System.out.println("WHILE 1");

        int i = 1;

        while (i <= 5) {
            System.out.println("i = " + i);
            i++;
        }

        // =====================================
        // WHILE 2 COM CONTINUE
        // =====================================
        System.out.println("\nWHILE 2 - CONTINUE");

        int j = 0;

        while (j < 10) {
            j++;

            if (j % 2 == 0) {
                continue; // pula números pares
            }

            System.out.println("Ímpar: " + j);
        }

        // =====================================
        // DO WHILE COM BREAK
        // =====================================
        System.out.println("\nDO WHILE - BREAK");

        int k = 1;

        do {
            System.out.println("k = " + k);

            if (k == 5) {
                break; // interrompe o laço
            }

            k++;

        } while (k <= 10);

        // =====================================
        // FOR COM BREAK E CONTINUE
        // =====================================
        System.out.println("\nFOR");

        for (int x = 1; x <= 10; x++) {

            if (x == 3) {
                continue; // pula o número 3
            }

            if (x == 8) {
                break; // encerra o for
            }

            System.out.println("x = " + x);
        }

        // =====================================
        // FOREACH COM OBJETOS
        // =====================================
        System.out.println("\nFOREACH COM OBJETOS");

        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("Ana"));
        pessoas.add(new Pessoa("Bruno"));
        pessoas.add(new Pessoa("Carlos"));

        for (Pessoa p : pessoas) {
            System.out.println("Nome: " + p.nome);
        }
    }
}