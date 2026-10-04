package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransacaoAnalyzer {

    public Map<TipoTransacao, BigDecimal> totalPorTipo(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .collect(
                        Collectors.groupingBy(
                                Transacao::tipo,
                                Collectors.reducing(
                                        BigDecimal.ZERO,
                                        Transacao::valor,
                                        BigDecimal::add
                                )
                        )
                );
    }

    public Map<Cliente, BigDecimal> totalPorCliente(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .collect(
                        Collectors.groupingBy(
                                transacao ->
                                        transacao.conta().getCliente(),
                                Collectors.reducing(
                                        BigDecimal.ZERO,
                                        Transacao::valor,
                                        BigDecimal::add
                                )
                        )
                );
    }
}