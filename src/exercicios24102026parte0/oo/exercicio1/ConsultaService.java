package exercicios24102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultaService {
	
    private final RepositorioMemoria<Consulta> repositorio = new RepositorioMemoria<>();
    private final AgendamentoValidator validator = new AgendamentoValidator();

    public Consulta agendar(
            Long id,
            Animal animal,
            Veterinario veterinario,
            LocalDateTime dataHora,
            BigDecimal valor) {
        validator.validar(animal, veterinario, dataHora, repositorio.listarTodos());

        Consulta consulta = new Consulta(id, animal, veterinario, dataHora, valor);
        repositorio.salvar(consulta);

        return consulta;
    }

    public List<Consulta> listarTodas() {
        return repositorio.listarTodos();
    }

    public List<Consulta> listarAgendadas() {
        return repositorio.listarTodos().stream()
                .filter(consulta -> consulta.getStatus() == StatusConsulta.AGENDADA)
                .toList();
    }
    
}