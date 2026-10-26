package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EntregaService {
    private final RepositorioEncomendas repositorio;
    private final ValidadorEntrega validador;
    private final List<Rastreamento> historico = new ArrayList<>();

    public EntregaService(
            RepositorioEncomendas repositorio,
            ValidadorEntrega validador) {
        if (repositorio == null || validador == null) {
            throw new IllegalArgumentException(
                    "Repositório e validador são obrigatórios");
        }

        this.repositorio = repositorio;
        this.validador = validador;
    }

    public Encomenda criar(
            String id,
            Cliente cliente,
            Endereco origem,
            Endereco destino,
            Pacote pacote,
            TipoServico tipo,
            BigDecimal distanciaKm) {

        CalculadoraFrete calculadora = switch (tipo) {
            case PADRAO -> new FretePadrao();
            case EXPRESSO -> new FreteExpresso(new FretePadrao());
        };

        Encomenda encomenda = new Encomenda(
                id, cliente, origem, destino, pacote,
                tipo, distanciaKm, calculadora);

        repositorio.salvar(encomenda);

        historico.add(new Rastreamento(
                id, StatusEntrega.CRIADA,
                LocalDateTime.now(), "Encomenda criada"));

        return encomenda;
    }

    public Optional<Encomenda> buscarPorId(String id) {
        return repositorio.buscarPorId(id);
    }

    public List<Encomenda> listarTodas() {
        return repositorio.listarTodos();
    }

    public void atualizarStatus(String id, StatusEntrega novoStatus) {
        Encomenda encomenda = repositorio.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Encomenda não encontrada: " + id));

        StatusEntrega atual = encomenda.getStatus();
        validador.validarTransicao(atual, novoStatus);

        encomenda.atualizarStatus(novoStatus);

        historico.add(new Rastreamento(
                id,
                novoStatus,
                LocalDateTime.now(),
                "Status atualizado de " + atual + " para " + novoStatus));
    }

    public List<Rastreamento> rastrear(String encomendaId) {
        return historico.stream()
                .filter(item -> item.encomendaId().equals(encomendaId))
                .toList();
    }

    public List<Rastreamento> getHistorico() {
        return List.copyOf(historico);
    }
}