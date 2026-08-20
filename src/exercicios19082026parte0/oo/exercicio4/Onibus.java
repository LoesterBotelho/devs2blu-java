package exercicios19082026parte0.oo.exercicio4;

import exercicios19082026parte0.oo.exercicio4.abstratas.Terrestre;

public class Onibus extends Terrestre {

    private String linha;
    private String empresa;
    private boolean acessivel;

    public Onibus() {
    }

    public Onibus(String modelo,
                  String fabricante,
                  int capacidade,
                  int rodas,
                  String combustivel,
                  String cor,
                  String linha,
                  String empresa,
                  boolean acessivel) {

        super(modelo, fabricante, capacidade,
                rodas, combustivel, cor);

        this.linha = linha;
        this.empresa = empresa;
        this.acessivel = acessivel;
    }

    @Override
    public void mover() {
        System.out.println("Onibus em movimento...");
    }

    @Override
    public String toString() {
        return "Onibus{" +
                super.toString() +
                ", linha='" + linha + '\'' +
                ", empresa='" + empresa + '\'' +
                ", acessivel=" + acessivel +
                '}';
    }
}