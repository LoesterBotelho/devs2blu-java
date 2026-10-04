package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RankingService {

    public List<Map.Entry<Cliente, BigDecimal>> ranking(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .collect(
                        Collectors.groupingBy(
                                t -> t.conta().getCliente(),
                                Collectors.reducing(
                                        BigDecimal.ZERO,
                                        Transacao::valor,
                                        BigDecimal::add
                                )
                        )
                )
                .entrySet()
                .stream()
                .sorted(
                        Map.Entry.<Cliente, BigDecimal>
                                comparingByValue()
                                .reversed()
                )
                .toList();
    }
}