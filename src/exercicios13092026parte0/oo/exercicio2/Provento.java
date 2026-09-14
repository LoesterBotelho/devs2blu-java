package exercicios13092026parte0.oo.exercicio2;

public record Provento(
        String descricao,
        double valor
) implements Calculavel {

    @Override
    public double calcular() {
        return valor;
    }

}