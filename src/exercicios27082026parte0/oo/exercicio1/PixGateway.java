package exercicios27082026parte0.oo.exercicio1;

public class PixGateway implements GatewayPagamento {
    @Override
    public boolean processarPagamento(double valor, String tokenCartaoOuChave) {
        System.out.println("[PIX] Gerando QR Code instantâneo...");
        System.out.println("[PIX] Pagamento de R$ " + valor + " confirmado para a chave: " + tokenCartaoOuChave);
        return true;
    }
}