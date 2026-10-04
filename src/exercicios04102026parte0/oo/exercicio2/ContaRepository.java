package exercicios04102026parte0.oo.exercicio2;

import java.util.List;

public class ContaRepository {

    private final GenericRepository<Conta, Long> repository =
            new GenericRepository<>(Conta::getNumero);

    public void salvar(Conta conta) {
        repository.salvar(conta);
    }

    public List<Conta> listar() {
        return repository.listar();
    }
}