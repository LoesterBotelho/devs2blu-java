package exercicios27092026parte0.oo.exercicio3;

import java.math.BigDecimal;

public class Transacao {

    private final Long id;
    private final String cliente;
    private final TipoTransacao tipo;
    private final StatusTransacao status;
    private final BigDecimal valor;

    public Transacao(
            Long id,
            String cliente,
            TipoTransacao tipo,
            StatusTransacao status,
            BigDecimal valor) {

        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.status = status;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public StatusTransacao getStatus() {
        return status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return String.format(
                "Transacao{id=%d, cliente='%s', tipo=%s, status=%s, valor=R$ %.2f}",
                id,
                cliente,
                tipo,
                status,
                valor
        );
    }
}