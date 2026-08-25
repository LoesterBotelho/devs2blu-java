package exercicios23082026parte0.oo.exercicio2;

public class PedidoCheckout {
    // Inversão de dependência: depende da interface e não de implementações concretas
    private final CalculadoraDesconto calculadoraDesconto;

    // Injeção de dependência via construtor
    public PedidoCheckout(CalculadoraDesconto calculadoraDesconto) {
        this.calculadoraDesconto = calculadoraDesconto;
    }

    public void finalizarPedido(double valorBruto) {
        double desconto = calculadoraDesconto.calcular(valorBruto);
        double valorFinal = valorBruto - desconto;
        
        System.out.println("Valor Bruto: R$ " + valorBruto);
        System.out.println("Desconto Aplicado: R$ " + desconto);
        System.out.println("Valor Final a Pagar: R$ " + valorFinal);
    }
}