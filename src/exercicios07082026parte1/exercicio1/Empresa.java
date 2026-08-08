package exercicios07082026parte1.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

    private String nome;

    private List<Departamento> departamentos =
            new ArrayList<>();

    public Empresa(String nome) {
        this.nome = nome;
    }

    public void criarDepartamento(String nome) {

        Departamento departamento =
                new Departamento(nome);

        departamentos.add(departamento);
    }

    public Departamento buscarDepartamento(
            String nome) {

        for (Departamento departamento
                : departamentos) {

            if (departamento.getNome()
                    .equalsIgnoreCase(nome)) {

                return departamento;
            }
        }

        return null;
    }

    public void listarDepartamentos() {

        System.out.println(
                "\nEmpresa: " + nome);

        for (Departamento departamento
                : departamentos) {

            System.out.println(
                    "- " + departamento.getNome());
        }
    }

	@Override
	public String toString() {
		return "Empresa [nome=" + nome + 
				", departamentos=" + departamentos + 
				"]";
	}
    
}