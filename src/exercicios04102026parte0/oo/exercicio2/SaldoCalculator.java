package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.List;

public class SaldoCalculator {

    public BigDecimal calcular(
            Conta conta,
            List<Transacao> transacoes) {

        return transacoes.stream()
                .filter(t ->
                        t.conta().equals(conta))
                .filter(t ->
                        t.status() == StatusTransacao.APROVADA)
                .map(t -> {

                    if (t.tipo() == TipoTransacao.SAQUE) {
                        return t.valor().negate();
                    }

                    return t.valor();
                })
                .reduce(
                        conta.getSaldo(),
                        BigDecimal::add
                );
    }
}