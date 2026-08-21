package exercicios20082026parte0.oo.exercicio2;

public class Papagaio extends Ave {
    public Papagaio(String nome) {
        super(nome);
    }

    @Override
    public String emitirSom() {
        return "Som de papagaio";
    }

    @Override
    public String voar() {
        return "Papagaio voando";
    }
}