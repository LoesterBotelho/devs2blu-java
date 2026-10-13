package exercicios13102026parte0.oo.exercicio2;

public class SensorTemperatura extends Sensor {

    public SensorTemperatura(String identificador, String local) {
        super(identificador, local);
    }

    @Override
    public String getTipo() {
        return "Temperatura (°C)";
    }
}