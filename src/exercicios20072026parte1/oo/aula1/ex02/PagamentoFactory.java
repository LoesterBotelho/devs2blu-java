package exercicios20072026parte1.oo.aula1.ex02;

public class PagamentoFactory {

    private PagamentoFactory() {
    }

    public static Pagamento criar(String tipo, double valor) {

        switch (tipo.toUpperCase()) {

            case "PIX":
                return new PixPagamento(valor);

            case "CARTAO":
            case "CARTÃO":
                return new CartaoPagamento(valor);

            default:
                throw new IllegalArgumentException(
                        "Forma de pagamento inválida.");
        }

    }

}