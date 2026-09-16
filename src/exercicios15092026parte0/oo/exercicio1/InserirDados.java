package exercicios15092026parte0.oo.exercicio1;

import java.time.LocalDateTime;
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

    public static List<RegistroPonto> registrosPonto(
            Funcionario funcionario) {

        return List.of(
                new RegistroPonto(
                        funcionario.id() * 10 + 1,
                        funcionario,
                        LocalDateTime.of(
                                2026,
                                9,
                                15,
                                8,
                                0
                        ),
                        LocalDateTime.of(
                                2026,
                                9,
                                15,
                                18,
                                0
                        )
                ),
                new RegistroPonto(
                        funcionario.id() * 10 + 2,
                        funcionario,
                        LocalDateTime.of(
                                2026,
                                9,
                                16,
                                8,
                                0
                        ),
                        LocalDateTime.of(
                                2026,
                                9,
                                16,
                                17,
                                0
                        )
                )
        );
    }

    public static List<Provento> proventos() {

        return List.of(
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