package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Encomenda implements Identificavel {
	
    private final String id;
    private final Cliente cliente;
    private final Endereco origem;
    private final Endereco destino;
    private final Pacote pacote;
    private final TipoServico tipoServico;
    private final BigDecimal distanciaKm;
    private final BigDecimal valorFrete;
    private final LocalDateTime criadaEm;
    private StatusEntrega status;

    public Encomenda(
            String id,
            Cliente cliente,
            Endereco origem,
            Endereco destino,
            Pacote pacote,
            TipoServico tipoServico,
            BigDecimal distanciaKm,
            CalculadoraFrete calculadoraFrete) {

        if (id == null || id.isBlank()
                || cliente == null
                || origem == null
                || destino == null
                || pacote == null
                || tipoServico == null
                || distanciaKm == null
                || distanciaKm.compareTo(BigDecimal.ZERO) < 0
                || calculadoraFrete == null) {
            throw new IllegalArgumentException("Dados da encomenda inválidos");
        }

        this.id = id;
        this.cliente = cliente;
        this.origem = origem;
        this.destino = destino;
        this.pacote = pacote;
        this.tipoServico = tipoServico;
        this.distanciaKm = distanciaKm;
        this.valorFrete = Objects.requireNonNull(
                calculadoraFrete.calcular(pacote, distanciaKm),
                "O frete calculado não pode ser nulo");
        this.criadaEm = LocalDateTime.now();
        this.status = StatusEntrega.CRIADA;
    }

    @Override
    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Endereco getOrigem() {
        return origem;
    }

    public Endereco getDestino() {
        return destino;
    }

    public Pacote getPacote() {
        return pacote;
    }

    public TipoServico getTipoServico() {
        return tipoServico;
    }

    public BigDecimal getDistanciaKm() {
        return distanciaKm;
    }

    public BigDecimal getValorFrete() {
        return valorFrete;
    }

    public LocalDateTime getCriadaEm() {
        return criadaEm;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void atualizarStatus(StatusEntrega novoStatus) {
        if (novoStatus == null) {
            throw new IllegalArgumentException("Status obrigatório");
        }

        this.status = novoStatus;
    }
    
}