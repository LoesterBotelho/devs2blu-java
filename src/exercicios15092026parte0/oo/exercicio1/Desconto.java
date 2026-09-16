package exercicios15092026parte0.oo.exercicio1;

public record Desconto(
        String descricao,
        double valor
) implements Calculavel {

    @Override
    public double calcular() {
        return valor;
    }

}