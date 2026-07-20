package exercicios20072026parte1.oo.aula1.ex02;

public class CartaoPagamento extends Pagamento {

    private static final double TAXA = 0.05;

    public CartaoPagamento(double valor) {
        super(valor);
    }

    @Override
    public double calcularTaxa() {
        return getValor() * TAXA;
    }

    @Override
    public void pagar() {
        System.out.println("Pagamento via Cartão realizado com sucesso.");
    }

    @Override
    public String gerarComprovante() {

        return String.format(
                """
                ------ CARTÃO -------
                Valor: R$ %.2f
                Taxa : R$ %.2f
                Total: R$ %.2f
                """,
                getValor(),
                calcularTaxa(),
                calcularTotal());

    }

}