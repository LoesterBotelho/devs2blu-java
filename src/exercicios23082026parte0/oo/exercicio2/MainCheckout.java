package exercicios23082026parte0.oo.exercicio2;

public class MainCheckout {
    public static void main(String[] args) {
        double valorCompra = 500.00;

        System.out.println("--- Campanha de Natal ---");
        CalculadoraDesconto descontoNatal = new DescontoNatalino();
        PedidoCheckout pedidoNatal = new PedidoCheckout(descontoNatal);
        pedidoNatal.finalizarPedido(valorCompra);

        valorCompra = 1000.00;
        System.out.println("\n--- Campanha de Black Friday ---");
        CalculadoraDesconto descontoBF = new DescontoBlackFriday();
        PedidoCheckout pedidoBF = new PedidoCheckout(descontoBF);
        pedidoBF.finalizarPedido(valorCompra);
    }
}