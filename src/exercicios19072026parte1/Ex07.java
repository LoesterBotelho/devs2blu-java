package exercicios19072026parte1;

public class Ex07 {

    private static final double RENDIMENTO_TINTA = 3.0;

    private double largura = 0.0;
    private double altura = 0.0;

    public Ex07() {
    }

    public Ex07(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getArea() {
        return largura * altura;
    }

    public double getLitrosTinta() {
        return getArea() / RENDIMENTO_TINTA;
    }

    @Override
    public String toString() {
        return "Ex07 [Largura=" + this.getLargura()
                + ", Altura=" + this.getAltura()
                + ", Area=" + this.getArea()
                + ", LitrosTinta=" + this.getLitrosTinta()
                + "]";
    }

}