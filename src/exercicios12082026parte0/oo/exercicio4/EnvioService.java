package exercicios12082026parte0.oo.exercicio4;

public class EnvioService {

    public void enviarPedido(Pedido pedido, String endereco) {
        System.out.println("Pedido ID " + pedido.getId() + " enviado para o cliente " + pedido.getCliente() + " no endereço: " + endereco);
    }
}