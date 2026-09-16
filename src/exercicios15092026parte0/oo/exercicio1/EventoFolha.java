package exercicios15092026parte0.oo.exercicio1;

public record EventoFolha<T extends Calculavel>(
        TipoEvento tipo,
        T evento
) {

    public double calcular() {
        return evento.calcular();
    }

}
