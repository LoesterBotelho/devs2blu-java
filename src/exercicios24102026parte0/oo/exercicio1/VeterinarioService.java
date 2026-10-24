package exercicios24102026parte0.oo.exercicio1;

import java.util.List;

public class VeterinarioService {
	
    private final RepositorioMemoria<Veterinario> repositorio = new RepositorioMemoria<>();

    public void cadastrar(Veterinario veterinario) {
        repositorio.salvar(veterinario);
    }

    public List<Veterinario> listarPorEspecialidade(Especialidade especialidade) {
        return repositorio.listarTodos().stream()
                .filter(veterinario -> veterinario.getEspecialidade() == especialidade)
                .toList();
    }

    public List<Veterinario> listarTodos() {
        return repositorio.listarTodos();
    }
    
}