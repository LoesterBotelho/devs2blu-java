package exercicios12102026parte0.oo.exercicio1;

public abstract class Dispositivo {
	
    private final String nome;
    private boolean ligado;

    protected Dispositivo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void ligar() {
        ligado = true;
    }

    public void desligar() {
        ligado = false;
    }

    public abstract String obterStatus();

    @Override
    public String toString() {
        return nome + " - Ligado: " + ligado;
    }
    
}