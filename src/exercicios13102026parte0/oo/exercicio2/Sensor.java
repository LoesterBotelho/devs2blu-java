package exercicios13102026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;

public abstract class Sensor {
	
    private final String identificador;
    private final String local;
    private final List<Medicao> medicoes = new ArrayList<>();

    protected Sensor(String identificador, String local) {
        this.identificador = identificador;
        this.local = local;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getLocal() {
        return local;
    }

    public void registrarMedicao(double valor) {
        medicoes.add(new Medicao(valor, java.time.LocalDateTime.now()));
    }

    public List<Medicao> getMedicoes() {
        return List.copyOf(medicoes);
    }

    public double calcularMedia() {
        return medicoes.stream()
                .mapToDouble(Medicao::valor)
                .average()
                .orElse(0.0);
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        return identificador + " - " + local + " - " + getTipo();
    }
    
}