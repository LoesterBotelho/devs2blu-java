package exercicios19082026parte0.oo.exercicio4.abstratas;

public abstract class Transporte {

    protected String modelo;
    protected String fabricante;
    protected int capacidade;

    public Transporte() {
    }

    public Transporte(String modelo, String fabricante, int capacidade) {
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.capacidade = capacidade;
    }

    public abstract void mover();

    @Override
    public String toString() {
        return "modelo=" + modelo +
                ", fabricante=" + fabricante +
                ", capacidade=" + capacidade;
    }
}
