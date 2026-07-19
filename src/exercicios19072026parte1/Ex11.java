package exercicios19072026parte1;

public class Ex11 {

    private double distancia = 0.0;
    private double velocidadeMedia = 0.0;

    public Ex11() {
    }

    public Ex11(double distancia, double velocidadeMedia) {
        this.distancia = distancia;
        this.velocidadeMedia = velocidadeMedia;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getVelocidadeMedia() {
        return velocidadeMedia;
    }

    public void setVelocidadeMedia(double velocidadeMedia) {
        this.velocidadeMedia = velocidadeMedia;
    }

    public double getTempoHoras() {
        return distancia / velocidadeMedia;
    }

    public double getTempoMinutos() {
        return getTempoHoras() * 60;
    }

    @Override
    public String toString() {
        return "Ex11 [Distancia=" + this.getDistancia()
                + ", VelocidadeMedia=" + this.getVelocidadeMedia()
                + ", TempoHoras=" + this.getTempoHoras()
                + ", TempoMinutos=" + this.getTempoMinutos()
                + "]";
    }

}