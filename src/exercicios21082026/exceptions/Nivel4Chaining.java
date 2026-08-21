package exercicios21082026.exceptions;

public class Nivel4Chaining {
    public static void main(String[] args) {
        PedidoController controller = new PedidoController();

        try {
        	
            controller.finalizarPedido();
            
        } catch (ProcessamentoPedidoException e) {
        	
            System.err.println("Mensagem de Negócio: " + e.getMessage());
            
            System.err.println("--- Imprimindo o StackTrace completo (com a causa raiz) ---");
            
            e.printStackTrace();
            
        }
    }
}
