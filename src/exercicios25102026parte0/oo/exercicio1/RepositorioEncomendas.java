package exercicios25102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public class RepositorioEncomendas {
	
    private final Repositorio<Encomenda> repositorio =
            new RepositorioMemoria<>();

    public void salvar(Encomenda encomenda) {
        repositorio.salvar(encomenda);
    }

    public Optional<Encomenda> buscarPorId(String id) {
        return repositorio.buscarPorId(id);
    }

    public List<Encomenda> listarTodos() {
        return repositorio.listarTodos();
    }

    public boolean remover(String id) {
        return repositorio.remover(id);
    }

    public long contar() {
        return repositorio.contar();
    }
    
}