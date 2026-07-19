package exercicios19072026parte1;

public class Ex09 {

    private double valorCompra = 0.0;
    private int numeroParcelas = 0;
    private double juros = 0.0;

    public Ex09() {
    }

    public Ex09(double valorCompra, int numeroParcelas, double juros) {
        this.valorCompra = valorCompra;
        this.numeroParcelas = numeroParcelas;
        this.juros = juros;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(int numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public double getJuros() {
        return juros;
    }

    public void setJuros(double juros) {
        this.juros = juros;
    }

    public double getValorParcela() {

        if (juros == 0) {
            return valorCompra / numeroParcelas;
        }

        double valorComJuros = valorCompra + (valorCompra * juros / 100);

        return valorComJuros / numeroParcelas;
    }

    @Override
    public String toString() {
        return "Ex09 [ValorCompra=" + valorCompra
                + ", NumeroParcelas=" + numeroParcelas
                + ", Juros=" + juros + "%"
                + ", ValorParcela=" + getValorParcela()
                + "]";
    }

}