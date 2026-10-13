package exercicios12102026parte0.oo.exercicio1;

public class Lampada extends Dispositivo {
	
    private final int potencia;

    public Lampada(String nome, int potencia) {
        super(nome);
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
    public String obterStatus() {
        return getNome() + " - " + potencia + "W - "
                + (isLigado() ? "Iluminando" : "Apagada");
    }
    
}