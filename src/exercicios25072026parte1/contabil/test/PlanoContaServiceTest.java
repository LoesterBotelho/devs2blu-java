package exercicios25072026parte1.contabil.test;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.enums.TipoConta;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;
import exercicios25072026parte1.contabil.service.PlanoContaService;

public class PlanoContaServiceTest {

	public static void main(String[] args) {

		PlanoContaRepository repository = new PlanoContaRepository();

		PlanoContaService service = new PlanoContaService(repository);

		PlanoConta ativo =

				new PlanoConta(

						1, "1", "ATIVO", NaturezaConta.ATIVO, TipoConta.SINTETICA, 1, false

				);

		PlanoConta caixa =

				new PlanoConta(

						2, "1.1.01", "Caixa", NaturezaConta.ATIVO, TipoConta.ANALITICA, 3, true

				);

		service.cadastrar(ativo);

		service.cadastrar(caixa);

		service.adicionarFilha(1, caixa);

		service.listar()

				.forEach(System.out::println);

		System.out.println();

		ativo.imprimir("");

	}

}