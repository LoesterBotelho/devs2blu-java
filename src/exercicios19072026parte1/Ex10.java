package exercicios19072026parte1;

public class Ex10 {

    private double valorReais = 0.0;
    private double cotacaoDolar = 0.0;

    public Ex10() {
    }

    public Ex10(double valorReais, double cotacaoDolar) {
        this.valorReais = valorReais;
        this.cotacaoDolar = cotacaoDolar;
    }

    public double getValorReais() {
        return valorReais;
    }

    public void setValorReais(double valorReais) {
        this.valorReais = valorReais;
    }

    public double getCotacaoDolar() {
        return cotacaoDolar;
    }

    public void setCotacaoDolar(double cotacaoDolar) {
        this.cotacaoDolar = cotacaoDolar;
    }

    public double getValorDolar() {
        return valorReais / cotacaoDolar;
    }

    @Override
    public String toString() {
        return "Ex10 [ValorReais=" + this.getValorReais()
                + ", CotacaoDolar=" + this.getCotacaoDolar()
                + ", ValorDolar=" + this.getValorDolar()
                + "]";
    }

}