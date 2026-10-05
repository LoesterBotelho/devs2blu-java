package exercicios05102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public class ClienteRepository {

    private final GenericRepository<Cliente, Long>
            repository =
            new GenericRepository<>(Cliente::id);

    public void salvar(Cliente cliente) {
        repository.salvar(cliente);
    }

    public Optional<Cliente> buscar(Long id) {
        return repository.buscar(id);
    }

    public List<Cliente> listar() {
        return repository.listar();
    }
}