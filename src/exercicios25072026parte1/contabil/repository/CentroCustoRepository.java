package exercicios25072026parte1.contabil.repository;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import exercicios25072026parte1.contabil.model.CentroCusto;

public class CentroCustoRepository
        extends MemoryRepository<CentroCusto, Integer> {

    private final AtomicInteger sequencia =
            new AtomicInteger(1);

    @Override
    protected Integer gerarId() {

        return sequencia.getAndIncrement();

    }

    /**
     * Busca um centro de custo pelo código.
     */
    public Optional<CentroCusto> buscarPorCodigo(String codigo) {

        if (codigo == null || codigo.isBlank()) {
            return Optional.empty();
        }

        return listar().stream()
                .filter(cc -> codigo.equalsIgnoreCase(cc.getCodigo()))
                .findFirst();
    }

    /**
     * Verifica se já existe um centro de custo com o código informado.
     */
    public boolean existeCodigo(String codigo) {

        return buscarPorCodigo(codigo).isPresent();

    }

}