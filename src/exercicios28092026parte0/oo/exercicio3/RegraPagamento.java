package exercicios28092026parte0.oo.exercicio3;

import java.math.BigDecimal;

// Isso permite criar regras usando Lambda.
@FunctionalInterface
public interface RegraPagamento<T> {

    BigDecimal aplicar(T pagamento);
}