package exercicios05102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public class ProdutoRepository {

    private final GenericRepository<Produto, Long>
            repository =
            new GenericRepository<>(Produto::getId);

    public void salvar(Produto produto) {
        repository.salvar(produto);
    }

    public Optional<Produto> buscar(Long id) {
        return repository.buscar(id);
    }

    public List<Produto> listar() {
        return repository.listar();
    }
}