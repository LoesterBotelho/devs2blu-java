package exemplos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ==========================================================
 * ORDENAÇÃO DE OBJETOS
 * ==========================================================
 */
public class ExemploOrdenacaoObjeto {

    public static void main(String[] args) {

        List<Aluno> alunos = new ArrayList<>();

        alunos.add(new Aluno("Carlos", 30));
        alunos.add(new Aluno("Ana", 20));
        alunos.add(new Aluno("Pedro", 25));
        alunos.add(new Aluno("Bruno", 18));

        System.out.println("Lista original");

        alunos.forEach(System.out::println);

        /*
         * Nome
         */

        alunos.sort(Comparator.comparing(Aluno::getNome));

        System.out.println("\nOrdenado por nome");

        alunos.forEach(System.out::println);

        /*
         * Idade
         */

        alunos.sort(Comparator.comparingInt(Aluno::getIdade));

        System.out.println("\nOrdenado por idade");

        alunos.forEach(System.out::println);

        /*
         * Idade decrescente
         */

        alunos.sort(
                Comparator.comparingInt(Aluno::getIdade)
                          .reversed());

        System.out.println("\nIdade decrescente");

        alunos.forEach(System.out::println);

    }

}

class Aluno {

    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return nome + " (" + idade + ")";
    }

}