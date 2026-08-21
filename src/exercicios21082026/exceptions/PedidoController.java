package exercicios21082026.exceptions;

public class PedidoController {
    private final ServicoPagamento servicoPagamento = new ServicoPagamento();

    public void finalizarPedido() throws ProcessamentoPedidoException {
    	
        try {
        	
            servicoPagamento.conectarGateway();
            
        } catch (Exception e) {
        	
            throw new ProcessamentoPedidoException("Não foi possível finalizar o pedido devido a um erro no pagamento.", e);
            
        }
    }
}
