package exercicios24102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Prontuario {

	private final List<String> registros = new ArrayList<>();
    private final List<Prescricao> prescricoes = new ArrayList<>();

    public void registrar(String descricao) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("Descrição obrigatória");
        }

        registros.add(descricao);
    }

    public void adicionarPrescricao(Prescricao prescricao) {
        if (prescricao == null) {
            throw new IllegalArgumentException("Prescrição obrigatória");
        }

        prescricoes.add(prescricao);
    }

    public List<String> getRegistros() {
        return List.copyOf(registros);
    }

    public List<Prescricao> getPrescricoes() {
        return List.copyOf(prescricoes);
    }
    
}