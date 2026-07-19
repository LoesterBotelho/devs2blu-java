package exercicios19072026parte1;

public class Ex04 {

    private static final double IMPOSTO = 0.12;

    private double consumoKwh = 0.0;
    private double valorKwh = 0.0;

    public Ex04() {
    }

    public Ex04(double consumoKwh, double valorKwh) {
        this.consumoKwh = consumoKwh;
        this.valorKwh = valorKwh;
    }

    public double getConsumoKwh() {
        return consumoKwh;
    }

    public void setConsumoKwh(double consumoKwh) {
        this.consumoKwh = consumoKwh;
    }

    public double getValorKwh() {
        return valorKwh;
    }

    public void setValorKwh(double valorKwh) {
        this.valorKwh = valorKwh;
    }

    public double getValorConta() {
        return consumoKwh * valorKwh;
    }

    public double getValorImposto() {
        return getValorConta() * IMPOSTO;
    }

    public double getValorTotal() {
        return getValorConta() + getValorImposto();
    }

    @Override
    public String toString() {
        return "Ex12 [ConsumoKwh=" + this.getConsumoKwh()
                + ", ValorKwh=" + this.getValorKwh()
                + ", ValorConta=" + this.getValorConta()
                + ", Imposto=" + this.getValorImposto()
                + ", ValorTotal=" + this.getValorTotal()
                + "]";
    }

}