package exercicios24102026parte0.oo.exercicio1;

import java.time.LocalDateTime;
import java.util.List;

public class AgendamentoValidator {
	
    public void validar(
            Animal animal,
            Veterinario veterinario,
            LocalDateTime dataHora,
            
            List<Consulta> consultas) {
        if (animal == null || veterinario == null || dataHora == null) {
            throw new IllegalArgumentException("Dados obrigatórios ausentes");
        }

        if (dataHora.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Data deve ser futura");
        }

        boolean conflito = consultas.stream()
                .filter(consulta -> consulta.getStatus() == StatusConsulta.AGENDADA
                        || consulta.getStatus() == StatusConsulta.EM_ANDAMENTO)
                .anyMatch(consulta ->
                        consulta.getVeterinario().getId().equals(veterinario.getId())
                                && consulta.getDataHora().equals(dataHora));

        if (conflito) {
            throw new IllegalStateException("Veterinário já possui consulta nesse horário");
        }
    }
    
}