package exercicios19072026parte1;

public class Ex03 {

    private double peso = 0.0;
    private double altura = 0.0;

    public Ex03() {
    }

    public Ex03(double peso, double altura) {
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getImc() {
        double alturaMetros = altura / 100;
        return peso / (alturaMetros * alturaMetros);
    }

    @Override
    public String toString() {
        return "Ex04 [Peso=" + this.getPeso()
                + ", Altura=" + this.getAltura()
                + ", IMC=" + this.getImc()
                + "]";
    }

}