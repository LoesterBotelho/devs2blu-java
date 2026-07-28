package exercicios25072026parte1.contabil.test;

import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.model.PlanoConta;

public class PlanoContaDebugTest {

	public static void main(String[] args) {

		ContabilContext context = new ContabilContext();

		for (PlanoConta conta : context.getPlanoContaService().listar()) {

			System.out.println(conta.getCodigo() + " Pai: " + conta.getContaPai());

		}

	}

}