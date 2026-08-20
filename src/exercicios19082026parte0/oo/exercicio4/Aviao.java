package exercicios19082026parte0.oo.exercicio4;

import exercicios19082026parte0.oo.exercicio4.abstratas.Aereo;

public class Aviao extends Aereo {

    private String companhia;
    private String categoria;
    private double envergadura;

    public Aviao() {
    }

    public Aviao(String modelo,
                 String fabricante,
                 int capacidade,
                 double altitudeMaxima,
                 int motores,
                 String combustivel,
                 String companhia,
                 String categoria,
                 double envergadura) {

        super(modelo, fabricante, capacidade,
                altitudeMaxima, motores, combustivel);

        this.companhia = companhia;
        this.categoria = categoria;
        this.envergadura = envergadura;
    }

    @Override
    public void mover() {
        System.out.println("Aviao voando...");
    }

    @Override
    public String toString() {
        return "Aviao{" +
                super.toString() +
                ", companhia='" + companhia + '\'' +
                ", categoria='" + categoria + '\'' +
                ", envergadura=" + envergadura +
                '}';
    }
}