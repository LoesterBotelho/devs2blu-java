package exercicios20072026parte1.oo.aula1.ex01;

import java.util.ArrayList;

public class MainEx01 {

    public static void main(String[] args) {

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Funcionario("João", 3000));
        pessoas.add(new Funcionario("Maria", 4200));
        pessoas.add(new Gerente("Carlos", 9000));

        for (Pessoa pessoa : pessoas) {

            pessoa.exibirCargo();

            System.out.println(pessoa);

            Bonificacao bonus = (Bonificacao) pessoa;

            System.out.printf("Bônus: %.2f%n", bonus.calcularBonus());

            System.out.println("----------------------");

        }

    }

}