package exercicios12102026parte0.oo.exercicio1;

public class ArCondicionado extends Dispositivo {
    private final double temperatura;

    public ArCondicionado(String nome, double temperatura) {
        super(nome);
        this.temperatura = temperatura;
    }

    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public String obterStatus() {
        return getNome() + " - " + temperatura + " °C - "
                + (isLigado() ? "Resfriando" : "Desligado");
    }
}