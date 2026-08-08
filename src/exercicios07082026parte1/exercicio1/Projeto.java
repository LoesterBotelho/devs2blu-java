package exercicios07082026parte1.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Projeto {

    private String nome;

    private List<Funcionario> equipe =
            new ArrayList<>();

    public Projeto(String nome) {
        this.nome = nome;
    }

    public void adicionarFuncionario(
            Funcionario funcionario) {

        equipe.add(funcionario);
    }

    public void listarEquipe() {

        System.out.println(
                "\nProjeto: " + nome);

        for (Funcionario funcionario : equipe) {

            System.out.println(
                    "- " + funcionario.getNome());
        }
    }

    public void executarProjeto() {

        System.out.println(
                "\nExecutando projeto: " + nome);

        for (Funcionario funcionario : equipe) {

            funcionario.trabalhar();
        }
    }

	@Override
	public String toString() {
		return "Projeto [nome=" + nome + 
				", equipe=" + equipe + 
				"]";
	}
        
}