package exercicios27082026parte0.oo.exercicio1;

public class MainPagamento {
    public static void main(String[] args) {

        System.out.println("--- Cenário 1: Cartão de Crédito ---");
        GatewayPagamento stripe = new StripeGateway();
        CheckoutService checkoutStripe = new CheckoutService(stripe);
        
        checkoutStripe.finalizarCompra(250.00, "tok_1Mxyz92384A");


        System.out.println("--- Cenário 2: PIX ---");
        GatewayPagamento pix = new PixGateway();
        CheckoutService checkoutPix = new CheckoutService(pix);
        
        checkoutPix.finalizarCompra(120.50, "chave-pix-empresa@email.com");
    }
}