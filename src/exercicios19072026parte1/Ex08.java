package exercicios19072026parte1;

public class Ex08 {

    private static final double COMISSAO = 0.08;

    private double salarioFixo = 0.0;
    private double valorVendas = 0.0;

    public Ex08() {
    }

    public Ex08(double salarioFixo, double valorVendas) {
        this.salarioFixo = salarioFixo;
        this.valorVendas = valorVendas;
    }

    public double getSalarioFixo() {
        return salarioFixo;
    }

    public void setSalarioFixo(double salarioFixo) {
        this.salarioFixo = salarioFixo;
    }

    public double getValorVendas() {
        return valorVendas;
    }

    public void setValorVendas(double valorVendas) {
        this.valorVendas = valorVendas;
    }

    public double getComissao() {
        return valorVendas * COMISSAO;
    }

    public double getSalarioFinal() {
        return salarioFixo + getComissao();
    }

    @Override
    public String toString() {
        return "Ex08 [SalarioFixo=" + this.getSalarioFixo()
                + ", ValorVendas=" + this.getValorVendas()
                + ", Comissao=" + this.getComissao()
                + ", SalarioFinal=" + this.getSalarioFinal()
                + "]";
    }

}