package exercicios27082026parte0.oo.exercicio1;

public class StripeGateway implements GatewayPagamento {
    @Override
    public boolean processarPagamento(double valor, String tokenCartaoOuChave) {
        System.out.println("[Stripe] Conectando à operadora internacional de cartão...");
        System.out.println("[Stripe] Cobrança de R$ " + valor + " aprovada com o token: " + tokenCartaoOuChave);
        return true;
    }
}