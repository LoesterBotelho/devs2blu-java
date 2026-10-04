package exercicios04102026parte0.oo.exercicio1;

import java.util.List;

public class PedidoRepository {

    private final RepositorioGenerico<Pedido, Long> repositorio =
            new RepositorioGenerico<>(Pedido::getId);

    public void salvar(Pedido pedido) {
        repositorio.salvar(pedido);
    }

    public List<Pedido> listar() {
        return repositorio.listar();
    }

    public List<Pedido> filtrar(java.util.function.Predicate<Pedido> predicate) {
        return repositorio.filtrar(predicate);
    }
}