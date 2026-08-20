package exercicios19082026parte0.oo.exercicio4;

import exercicios19082026parte0.oo.exercicio4.abstratas.Terrestre;

public class Automovel extends Terrestre {

    private String placa;
    private String categoria;
    private int portas;

    public Automovel() {
    }

    public Automovel(String modelo,
                     String fabricante,
                     int capacidade,
                     int rodas,
                     String combustivel,
                     String cor,
                     String placa,
                     String categoria,
                     int portas) {

        super(modelo, fabricante, capacidade,
                rodas, combustivel, cor);

        this.placa = placa;
        this.categoria = categoria;
        this.portas = portas;
    }

    @Override
    public void mover() {
        System.out.println("Automovel em movimento...");
    }

    @Override
    public String toString() {
        return "Automovel{" +
                super.toString() +
                ", placa='" + placa + '\'' +
                ", categoria='" + categoria + '\'' +
                ", portas=" + portas +
                '}';
    }
}