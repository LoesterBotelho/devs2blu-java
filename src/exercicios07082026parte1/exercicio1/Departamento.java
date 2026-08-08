package exercicios07082026parte1.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Departamento {

    private String nome;

    private List<Funcionario> funcionarios =
            new ArrayList<>();

    public Departamento(String nome) {
        this.nome = nome;
    }

    public void adicionarFuncionario(
            Funcionario funcionario) {

        funcionarios.add(funcionario);
    }

    public void listarFuncionarios() {

        System.out.println(
                "\nDepartamento: " + nome);

        for (Funcionario funcionario : funcionarios) {

            System.out.println(
                    "- " + funcionario.getNome());
        }
    }

    public String getNome() {
        return nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

	@Override
	public String toString() {
		return "Departamento [nome=" + nome + 
				", funcionarios=" + funcionarios + 
				"]";
	}
        
}