package exercicios13092026parte0.oo.exercicio2;

import java.util.List;

public class InserirDados {

    public static List<Funcionario> funcionarios() {

        return List.of(
                new Funcionario(
                        1L,
                        "Carlos Silva",
                        3500.00
                ),
                new Funcionario(
                        2L,
                        "Ana Souza",
                        4200.00
                ),
                new Funcionario(
                        3L,
                        "João Santos",
                        2800.00
                )
        );
    }

    public static List<Provento> proventos() {

        return List.of(
                new Provento(
                        "Horas extras",
                        750.00
                ),
                new Provento(
                        "Bonificação",
                        500.00
                ),
                new Provento(
                        "Adicional",
                        250.00
                )
        );
    }

    public static List<Desconto> descontos() {

        return List.of(
                new Desconto(
                        "INSS",
                        350.00
                ),
                new Desconto(
                        "Vale transporte",
                        150.00
                ),
                new Desconto(
                        "Plano de saúde",
                        120.00
                )
        );
    }

}