package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.List;

public class BancoService {

    private final SaldoCalculator saldoCalculator;

    public BancoService(
            SaldoCalculator saldoCalculator) {

        this.saldoCalculator = saldoCalculator;
    }

    public BigDecimal saldo(
            Conta conta,
            List<Transacao> transacoes) {

        return saldoCalculator.calcular(
                conta,
                transacoes
        );
    }
}