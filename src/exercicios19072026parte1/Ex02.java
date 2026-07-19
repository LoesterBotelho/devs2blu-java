package exercicios19072026parte1;

public class Ex02 {

    private double distancia = 0.0;
    private double combustivel = 0.0;

    public Ex02() {
    }

    public Ex02(double distancia, double combustivel) {
        this.distancia = distancia;
        this.combustivel = combustivel;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    public double getConsumoMedio() {
        return distancia / combustivel;
    }

    @Override
    public String toString() {
        return "Ex03 [Distancia=" + this.getDistancia()
                + ", Combustivel=" + this.getCombustivel()
                + ", ConsumoMedio=" + this.getConsumoMedio()
                + " km/L]";
    }

}