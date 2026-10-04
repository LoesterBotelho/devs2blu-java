package exercicios04102026parte0.oo.exercicio2;

import java.math.BigDecimal;

public class Conta {

    private Long numero;
    private Cliente cliente;
    private TipoConta tipo;
    private BigDecimal saldo;

    public Conta(
            Long numero,
            Cliente cliente,
            TipoConta tipo,
            BigDecimal saldo) {

        this.numero = numero;
        this.cliente = cliente;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Long getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void alterarSaldo(BigDecimal valor) {
        saldo = saldo.add(valor);
    }
}