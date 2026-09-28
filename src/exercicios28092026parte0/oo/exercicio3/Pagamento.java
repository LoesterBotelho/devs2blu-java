package exercicios28092026parte0.oo.exercicio3;

import java.math.BigDecimal;

public class Pagamento {

    private final Long id;
    private final String cliente;
    private final TipoPagamento tipo;
    private final StatusPagamento status;
    private final BigDecimal valor;

    public Pagamento(
            Long id,
            String cliente,
            TipoPagamento tipo,
            StatusPagamento status,
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

    public TipoPagamento getTipo() {
        return tipo;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", cliente='" + cliente + '\'' +
                ", tipo=" + tipo +
                ", status=" + status +
                ", valor=" + valor +
                '}';
    }
}