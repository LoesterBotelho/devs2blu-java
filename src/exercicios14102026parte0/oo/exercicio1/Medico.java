package exercicios14102026parte0.oo.exercicio1;

import java.math.BigDecimal;

public class Medico extends Pessoa {
	
    private final String crm;
    private final Especialidade especialidade;
    private final BigDecimal valorConsulta;

    public Medico(
            String nome,
            String documento,
            int idade,
            String crm,
            Especialidade especialidade,
            BigDecimal valorConsulta) {

        super(nome, documento, idade);

        if (crm == null || crm.isBlank()) {
            throw new IllegalArgumentException("CRM obrigatorio");
        }
        if (especialidade == null) {
            throw new IllegalArgumentException("Especialidade obrigatoria");
        }
        if (valorConsulta == null
                || valorConsulta.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Valor invalido");
        }

        this.crm = crm;
        this.especialidade = especialidade;
        this.valorConsulta = valorConsulta;
    }

    public String getCrm() {
        return crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public BigDecimal getValorConsulta() {
        return valorConsulta;
    }

    @Override
    public String getTipo() {
        return "Medico";
    }

    @Override
    public String toString() {
        return super.toString()
                + " | CRM: " + crm
                + " | Especialidade: " + especialidade
                + " | Consulta: R$ " + valorConsulta;
    }
    
}