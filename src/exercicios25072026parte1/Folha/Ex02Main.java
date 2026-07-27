package exercicios25072026parte1.Folha;

import java.util.ArrayList;
import java.util.List;

public class Ex02Main {

	public static void main(String[] args) {

		System.out.println("Autor: Loester Botelho");

		List<Funcionario> funcionarios = new ArrayList<>();

		Funcionario funcionario1 = new Funcionario(1001, "Angelica Silva", "Java Full Stack", "TI", 7000.00);
		funcionario1.adicionarDependente(new Dependente("Baskhara Silva", "Filha"));
		funcionarios.add(funcionario1);

		Funcionario funcionario2 = new Funcionario(1002, "Pitagoras Silva", "Gerente de Projetos", "Recursos Humanos", 15000.00);
		funcionarios.add(funcionario2);
 
		Ex02 folha = new Ex02();
 
		for (Funcionario funcionario : funcionarios) {
			Holerite holerite = folha.gerarHolerite(funcionario);
			holerite.imprimir();
		}

	}

}