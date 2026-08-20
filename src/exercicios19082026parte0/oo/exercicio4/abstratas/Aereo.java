package exercicios19082026parte0.oo.exercicio4.abstratas;

public abstract class Aereo extends Transporte {

    protected double altitudeMaxima;
    protected int motores;
    protected String combustivel;

    public Aereo() {
    }

    public Aereo(String modelo,
                 String fabricante,
                 int capacidade,
                 double altitudeMaxima,
                 int motores,
                 String combustivel) {

        super(modelo, fabricante, capacidade);

        this.altitudeMaxima = altitudeMaxima;
        this.motores = motores;
        this.combustivel = combustivel;
    }
}