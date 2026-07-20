package exercicios20072026parte1.oo.aula1.ex02;

public class Pedido {

    private final Pagamento pagamento;

    public Pedido(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public void finalizarPedido() {
        pagamento.pagar();
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

}