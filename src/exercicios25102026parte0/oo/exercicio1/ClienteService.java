package exercicios25102026parte0.oo.exercicio1;

import java.util.List;
import java.util.Optional;

public class ClienteService {
    private final RepositorioMemoria<Cliente> repositorio =
            new RepositorioMemoria<>();

    public void cadastrar(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente obrigatório");
        }

        repositorio.salvar(cliente);
    }

    public Optional<Cliente> buscarPorId(String id) {
        return repositorio.buscarPorId(id);
    }

    public List<Cliente> listarTodos() {
        return repositorio.listarTodos();
    }

    public long contar() {
        return repositorio.contar();
    }
}