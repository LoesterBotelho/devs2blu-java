package exercicios05102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public class PedidoRepository {

    private final GenericRepository<Pedido, Long>
            repository =
            new GenericRepository<>(Pedido::getId);

    public void salvar(Pedido pedido) {
        repository.salvar(pedido);
    }

    public Optional<Pedido> buscar(Long id) {
        return repository.buscar(id);
    }

    public List<Pedido> listar() {
        return repository.listar();
    }
}