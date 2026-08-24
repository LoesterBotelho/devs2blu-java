package exercicios24082026parte0.oo.exercicio1;
import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private String nomeEquipe;
    private List<MembroEquipe> membros;
    private String repositorioGit;
    private String urlDeployGcp;

    public Equipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
        this.membros = new ArrayList<>();
    }

    public void adicionarMembro(MembroEquipe membro) {
        if (membros.size() >= 10) {
            throw new IllegalStateException("A equipe já atingiu o limite máximo de 10 integrantes.");
        }
        membros.add(membro);
    }

    public void removerMembro(MembroEquipe membro) {
        membros.remove(membro);
    }

    public String getNomeEquipe() { 
        return nomeEquipe; 
    }
    
    public void setNomeEquipe(String nomeEquipe) { 
        this.nomeEquipe = nomeEquipe; 
    }

    public List<MembroEquipe> getMembros() { 
        return new ArrayList<>(membros); 
    }

    public String getRepositorioGit() { 
        return repositorioGit; 
    }
    
    public void setRepositorioGit(String repositorioGit) { 
        this.repositorioGit = repositorioGit; 
    }

    public String getUrlDeployGcp() { 
        return urlDeployGcp; 
    }
    
    public void setUrlDeployGcp(String urlDeployGcp) { 
        this.urlDeployGcp = urlDeployGcp; 
    }

    @Override
    public String toString() {
        return "Equipe: " + nomeEquipe + 
        		" | Total de Membros: " + membros.size();
    }
}