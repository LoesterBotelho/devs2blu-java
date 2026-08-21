package exercicios20082026parte0.oo.exercicio0;

public class Triangulo implements FiguraGeometrica {

    private double lado;

    public Triangulo(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return (Math.sqrt(3) / 4) * lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return lado * 3;
    }

    @Override
    public String getNome() {
        return "Triângulo Equilátero";
    }
}