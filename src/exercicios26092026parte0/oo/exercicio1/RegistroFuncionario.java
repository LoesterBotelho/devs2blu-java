package exercicios26092026parte0.oo.exercicio1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class RegistroFuncionario {

    private final Map<String, Funcionario> database = new HashMap<>();

    public void salvar(Funcionario funcionario) {
        database.put(funcionario.getId(), funcionario);
    }

    public Funcionario buscarPorId(String id) {
        return database.get(id);
    }

    public List<Funcionario> filtrarFuncionarios(
            Predicate<Funcionario> criterio) {

        return database.values()
                .stream()
                .filter(criterio)
                .toList();
    }
}