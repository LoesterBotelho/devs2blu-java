package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.List;

public class RiskAnalyzer {

    public List<Transacao> suspeitas(
            List<Transacao> transacoes) {

        return transacoes.stream()
                .filter(transacao ->
                        transacao.valor()
                                .compareTo(
                                        new BigDecimal("10000")
                                ) > 0)
                .toList();
    }
}