package exercicios14102026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Frota<T extends Veiculo> {

	private final List<T> veiculos = new ArrayList<>();

    public void adicionar(T veiculo) {
        if (veiculo == null) {
            throw new IllegalArgumentException("Veiculo obrigatorio");
        }

        boolean placaExistente = veiculos.stream()
                .anyMatch(v -> v.getPlaca().equalsIgnoreCase(
                        veiculo.getPlaca()));

        if (placaExistente) {
            throw new IllegalArgumentException("Placa duplicada");
        }

        veiculos.add(veiculo);
    }

    public List<T> listar() {
        return List.copyOf(veiculos);
    }

    public List<T> filtrar(Predicate<T> criterio) {
        return veiculos.stream()
                .filter(criterio)
                .toList();
    }

    public Optional<T> buscarPorPlaca(String placa) {
        return veiculos.stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placa))
                .findFirst();
    }

    public int quantidade() {
        return veiculos.size();
    }
    
}