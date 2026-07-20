package exercicios20072026parte1.oo.aula1.ex02;

public abstract class Pagamento implements Pagavel {

    private final double valor;

    public Pagamento(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public double calcularTotal() {
        return valor + calcularTaxa();
    }

    public void mostrarValor() {
        System.out.printf("Valor: R$ %.2f%n", valor);
    }

}