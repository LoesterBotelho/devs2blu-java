package exercicios19072026parte1;

public class Ex01 {

    private static final double KELVIN = 273.15;

    private double celsius = 0.0;

    public Ex01() {
    }

    public Ex01(double celsius) {
        this.celsius = celsius;
    }

    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public double getFahrenheit() {
        return (celsius * 9 / 5) + 32;
    }

    public double getKelvin() {
        return celsius + KELVIN;
    }

    @Override
    public String toString() {
        return "Ex02 [Celsius=" + this.getCelsius()
                + ", Fahrenheit=" + this.getFahrenheit()
                + ", Kelvin=" + this.getKelvin()
                + "]";
    }

}