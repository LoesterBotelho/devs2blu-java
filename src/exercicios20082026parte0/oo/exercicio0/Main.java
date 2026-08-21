package exercicios20082026parte0.oo.exercicio0;

public class Main {

    public static void main(String[] args) {

        FiguraGeometrica quadrado = new Quadrado(8);

        FiguraGeometrica triangulo = new Triangulo(6);

        exibirFigura(quadrado);

        System.out.println();

        exibirFigura(triangulo);
    }

    private static void exibirFigura(FiguraGeometrica figura) {

        System.out.println("Figura: " + figura.getNome());

        System.out.printf("Área: %.2f%n", figura.calcularArea());

        System.out.printf("Perímetro: %.2f%n", figura.calcularPerimetro());
    }
}