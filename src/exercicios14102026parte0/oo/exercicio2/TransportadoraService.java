package exercicios14102026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TransportadoraService {

	private final Frota<Veiculo> frota = new Frota<>();
    private final List<Entrega> entregas = new ArrayList<>();

    public void adicionarVeiculo(Veiculo veiculo) {
        frota.adicionar(veiculo);
    }

    public void registrarEntrega(Entrega entrega) {
        if (entrega == null) {
            throw new IllegalArgumentException("Entrega obrigatoria");
        }

        boolean idExistente = entregas.stream()
                .anyMatch(e -> e.getId() == entrega.getId());

        if (idExistente) {
            throw new IllegalArgumentException("ID de entrega duplicado");
        }

        entregas.add(entrega);
    }

    public Optional<Entrega> buscarEntrega(int id) {
        return entregas.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
    }

    public Optional<Veiculo> buscarVeiculo(String placa) {
        return frota.buscarPorPlaca(placa);
    }

    public void despacharEntrega(int id, String placa) {
        Entrega entrega = buscarEntrega(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Entrega nao encontrada"));

        Veiculo veiculo = buscarVeiculo(placa)
                .orElseThrow(() ->
                        new IllegalArgumentException("Veiculo nao encontrado"));

        entrega.despachar(veiculo);
    }

    public List<Entrega> listarEntregas() {
        return entregas.stream()
                .sorted(Comparator.comparingInt(Entrega::getId))
                .toList();
    }

    public List<Entrega> listarPorStatus(StatusEntrega status) {
        return entregas.stream()
                .filter(e -> e.getStatus() == status)
                .toList();
    }

    public List<Veiculo> listarVeiculos() {
        return frota.listar();
    }

    public List<Veiculo> listarVeiculosPorCapacidade(double pesoKg) {
        return frota.filtrar(v -> v.suportaPeso(pesoKg));
    }

    public BigDecimal calcularFreteTotalEntregue() {
        return entregas.stream()
                .filter(e -> e.getStatus() == StatusEntrega.ENTREGUE)
                .map(Entrega::getFrete)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public long contarEntregas(StatusEntrega status) {
        return entregas.stream()
                .filter(e -> e.getStatus() == status)
                .count();
    }

    public int quantidadeVeiculos() {
        return frota.quantidade();
    }

    public int quantidadeEntregas() {
        return entregas.size();
    }
    
}