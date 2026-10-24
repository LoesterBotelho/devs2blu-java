package exercicios24102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RelatorioClinica {
	
    public long contarPorStatus(List<Consulta> consultas, StatusConsulta status) {
        return consultas.stream()
                .filter(consulta -> consulta.getStatus() == status)
                .count();
    }

    public Map<String, Long> consultasPorVeterinario(List<Consulta> consultas) {
        return consultas.stream()
                .collect(Collectors.groupingBy(
                        consulta -> consulta.getVeterinario().getNome(),
                        Collectors.counting()));
    }

    public BigDecimal faturamentoConcluido(List<Consulta> consultas) {
        return consultas.stream()
                .filter(consulta -> consulta.getStatus() == StatusConsulta.CONCLUIDA)
                .map(Consulta::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    
}