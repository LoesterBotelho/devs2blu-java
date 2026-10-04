package exercicios04102026parte0.oo.exercicio2;

import java.util.List;

public class TransacaoRepository {

    private final GenericRepository<Transacao, Long> repository =
            new GenericRepository<>(Transacao::id);

    public void salvar(Transacao transacao) {
        repository.salvar(transacao);
    }

    public List<Transacao> listar() {
        return repository.listar();
    }

    public List<Transacao> filtrar(
            java.util.function.Predicate<Transacao> predicate) {

        return repository.filtrar(predicate);
    }
}