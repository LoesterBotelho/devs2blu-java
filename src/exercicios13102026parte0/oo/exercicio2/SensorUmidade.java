package exercicios13102026parte0.oo.exercicio2;

public class SensorUmidade extends Sensor {

    public SensorUmidade(String identificador, String local) {
        super(identificador, local);
    }

    @Override
    public String getTipo() {
        return "Umidade (%)";
    }
}