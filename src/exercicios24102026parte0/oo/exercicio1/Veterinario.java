package exercicios24102026parte0.oo.exercicio1;

public class Veterinario extends Pessoa {
	
    private final Especialidade especialidade;
    private final String crmv;

    public Veterinario(
            Long id,
            String nome,
            String telefone,
            Especialidade especialidade,
            String crmv) {
        super(id, nome, telefone);

        if (especialidade == null) {
            throw new IllegalArgumentException("Especialidade obrigatória");
        }

        if (crmv == null || crmv.isBlank()) {
            throw new IllegalArgumentException("CRMV obrigatório");
        }

        this.especialidade = especialidade;
        this.crmv = crmv;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public String getCrmv() {
        return crmv;
    }
    
}