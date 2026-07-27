package exercicios25072026parte1.Folha;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {

	private int matricula;
	private String nome;
	private String cargo;
	private String setor;
	private double salarioBase;
	private List<Dependente> dependentes = new ArrayList<>();

	public Funcionario(int matricula, String nome, String cargo, String setor, double salarioBase) {

		this.matricula = matricula;
		this.nome = nome;
		this.cargo = cargo;
		this.setor = setor;
		this.salarioBase = salarioBase;

	}

	public void adicionarDependente(Dependente dependente) {

		dependentes.add(dependente);

	}

	public List<Dependente> getDependentes() {

		return dependentes;

	}

	public int getMatricula() {

		return matricula;

	}

	public String getNome() {

		return nome;

	}

	public double getSalarioBase() {

		return salarioBase;

	}

	public void imprimirDados() {

		System.out.println("--------------------------------");
		System.out.println("Matricula....: " + matricula);
		System.out.println("Nome.........: " + nome);
		System.out.println("Cargo........: " + cargo);
		System.out.println("Setor........: " + setor);
		System.out.printf("Salario Base.: R$ %.2f%n", salarioBase);
		System.out.println("Dependentes:");

		for (Dependente d : dependentes) {
			d.imprimir();
		}

	}

}