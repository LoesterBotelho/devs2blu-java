package exercicios12082026parte0.oo.exercicio4;

public class NotaFiscalService {

    public void gerarNotaFiscal(Pedido pedido) {
        System.out.println("Nota fiscal gerada para o cliente " + pedido.getCliente() + " no valor de R$ " + pedido.getValorTotal());
    }
}