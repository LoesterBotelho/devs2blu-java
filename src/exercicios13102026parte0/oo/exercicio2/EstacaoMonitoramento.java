package exercicios13102026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EstacaoMonitoramento<T extends Sensor> {

	private final String nome;
    private final List<T> sensores = new ArrayList<>();

    public EstacaoMonitoramento(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarSensor(T sensor) {
        sensores.add(sensor);
    }

    public List<T> listarSensores() {
        return List.copyOf(sensores);
    }

    public Optional<T> buscarPorIdentificador(String identificador) {
        return sensores.stream()
                .filter(sensor -> sensor.getIdentificador()
                        .equalsIgnoreCase(identificador))
                .findFirst();
    }

    public List<T> ordenarPorMedia() {
        return sensores.stream()
                .sorted(Comparator.comparingDouble(Sensor::calcularMedia)
                        .reversed())
                .toList();
    }

    public long contarSensores() {
        return sensores.size();
    }
    
}