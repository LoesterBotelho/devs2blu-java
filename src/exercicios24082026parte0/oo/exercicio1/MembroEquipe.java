package exercicios24082026parte0.oo.exercicio1;

public class MembroEquipe extends Pessoa {
    private String papelNoProjeto;

    public MembroEquipe(String nome, String email, String papelNoProjeto) {
        super(nome, email);
        this.papelNoProjeto = papelNoProjeto;
    }

    public String getPapelNoProjeto() { 
        return papelNoProjeto; 
    }
    
    public void setPapelNoProjeto(String papelNoProjeto) { 
        this.papelNoProjeto = papelNoProjeto; 
    }

    @Override
    public String toString() {
        return "Membro [Nome: " + getNome() + 
        		", Papel: " + papelNoProjeto + 
        		"]";
    }
}