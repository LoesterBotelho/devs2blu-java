package exercicios23082026parte0.oo.exercicio2;

public class DescontoBlackFriday implements CalculadoraDesconto {
    @Override
    public double calcular(double valorOriginal) {
        // Regra de negócio: 30% de desconto na Black Friday
        return valorOriginal * 0.30;
    }
}