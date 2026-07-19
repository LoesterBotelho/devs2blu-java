package exercicios19072026parte1;

public class Ex05 {

    private static final double HORA_EXTRA = 1.5;

    private double valorHora = 0.0;
    private double horasTrabalhadas = 0.0;
    private double horasExtras = 0.0;

    public Ex05() {
    }

    public Ex05(double valorHora, double horasTrabalhadas, double horasExtras) {
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.horasExtras = horasExtras;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public double getSalarioNormal() {
        return valorHora * horasTrabalhadas;
    }

    public double getValorHorasExtras() {
        return valorHora * HORA_EXTRA * horasExtras;
    }

    public double getSalarioTotal() {
        return getSalarioNormal() + getValorHorasExtras();
    }

    @Override
    public String toString() {
        return "Ex05 [ValorHora=" + this.getValorHora()
                + ", HorasTrabalhadas=" + this.getHorasTrabalhadas()
                + ", HorasExtras=" + this.getHorasExtras()
                + ", SalarioNormal=" + this.getSalarioNormal()
                + ", ValorHorasExtras=" + this.getValorHorasExtras()
                + ", SalarioTotal=" + this.getSalarioTotal()
                + "]";
    }

}