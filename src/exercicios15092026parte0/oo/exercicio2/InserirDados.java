package exercicios15092026parte0.oo.exercicio2;

import java.util.List;

public class InserirDados {

    public static List<Funcionario> funcionarios() {

        return List.of(

                new Funcionario(
                        1L,
                        "Carlos Silva",
                        Cargo.DESENVOLVEDOR,
                        Nivel.SENIOR,
                        12000.00
                ),

                new Funcionario(
                        2L,
                        "Ana Souza",
                        Cargo.ANALISTA,
                        Nivel.PLENO,
                        6500.00
                ),

                new Funcionario(
                        3L,
                        "João Santos",
                        Cargo.TESTER,
                        Nivel.JUNIOR,
                        3500.00
                ),

                new Funcionario(
                        4L,
                        "Maria Oliveira",
                        Cargo.DEVOPS,
                        Nivel.SENIOR,
                        11000.00
                ),

                new Funcionario(
                        5L,
                        "Pedro Costa",
                        Cargo.DESENVOLVEDOR,
                        Nivel.PLENO,
                        7000.00
                ),

                new Funcionario(
                        6L,
                        "Juliana Lima",
                        Cargo.GERENTE,
                        Nivel.SENIOR,
                        15000.00
                )

        );
    }

}
