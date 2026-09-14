package exercicios13092026parte0.oo.exercicio2;

import java.time.Duration;
import java.time.LocalDateTime;

public record RegistroPonto(
        Long id,
        Funcionario funcionario,
        LocalDateTime entrada,
        LocalDateTime saida
) implements Identifiable<Long> {

    @Override
    public Long getId() {
        return id;
    }

    public double calcularHoras() {
        Duration duracao = Duration.between(entrada, saida);

        return duracao.toMinutes() / 60.0;
    }

}