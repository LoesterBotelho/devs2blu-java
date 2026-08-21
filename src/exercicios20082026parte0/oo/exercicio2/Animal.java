package exercicios20082026parte0.oo.exercicio2;

public abstract class Animal {
    private String nome;

    public Animal(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract String emitirSom();
}