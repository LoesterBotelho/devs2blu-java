package exercicios19082026parte0.oo.exercicio4.abstratas;

public abstract class Terrestre extends Transporte {

    protected int rodas;
    protected String combustivel;
    protected String cor;

    public Terrestre() {
    }

    public Terrestre(String modelo,
                     String fabricante,
                     int capacidade,
                     int rodas,
                     String combustivel,
                     String cor) {

        super(modelo, fabricante, capacidade);

        this.rodas = rodas;
        this.combustivel = combustivel;
        this.cor = cor;
    }
}