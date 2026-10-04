package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EstatisticaService {

    public BigDecimal total(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .map(Transacao::valor)
                .reduce(
                        BigDecimal.ZERO,
                        BigDecimal::add
                );
    }

    public double media(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .mapToDouble(t ->
                        t.valor().doubleValue())
                .average()
                .orElse(0);
    }

    public Optional<Transacao> maior(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .max(
                        Comparator.comparing(
                                Transacao::valor
                        )
                );
    }
}