package exercicios23082026parte0.oo.exercicio2;

public class DescontoNatalino implements CalculadoraDesconto {
    @Override
    public double calcular(double valorOriginal) {
        // Regra de negócio: 15% de desconto no Natal
        return valorOriginal * 0.15;
    }
}