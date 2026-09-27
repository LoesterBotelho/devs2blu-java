package exercicios26092026parte0.oo.exercicio2;

import java.math.BigDecimal;

public class Transacao {

    private final String tipo;
    private final BigDecimal valor;

    public Transacao(String tipo, BigDecimal valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format(
                "Transacao{tipo='%s', valor=R$ %.2f}",
                tipo,
                valor
        );
    }
}