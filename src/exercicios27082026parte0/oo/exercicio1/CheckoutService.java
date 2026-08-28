package exercicios27082026parte0.oo.exercicio1;

public class CheckoutService {
    // Inversão de dependência: a classe depende da abstração
    private final GatewayPagamento gatewayPagamento;

    // Injeção de dependência via construtor
    public CheckoutService(GatewayPagamento gatewayPagamento) {
        this.gatewayPagamento = gatewayPagamento;
    }

    public void finalizarCompra(double valor, String identificador) {
        System.out.println("Iniciando processo de checkout...");
        
        if (valor <= 0) {
            System.out.println("Erro: O valor da compra deve ser maior que zero.");
            return;
        }

        // Executa o pagamento usando o gateway injetado
        boolean sucesso = gatewayPagamento.processarPagamento(valor, identificador);

        if (sucesso) {
            System.out.println("Pedido concluído com sucesso! Nota fiscal emitida.\n");
        } else {
            System.out.println("Falha ao processar o pagamento. Tente novamente.\n");
        }
    }
}