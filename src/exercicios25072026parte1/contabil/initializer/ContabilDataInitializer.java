package exercicios25072026parte1.contabil.initializer;

import java.util.List;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.factory.PlanoContaFactory;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;

public class ContabilDataInitializer {

	private final PlanoContaRepository repository;

	public ContabilDataInitializer(PlanoContaRepository repository) {

		this.repository = repository;

	}

	public void carregar() {

		if (!repository.listar().isEmpty()) {

			return;

		}

		/*
		 * ===================================== ATIVO
		 * =====================================
		 */

		PlanoConta ativo = PlanoContaFactory.criarSintetica("1", "ATIVO", NaturezaConta.ATIVO, 1);

		PlanoConta ativoCirculante = PlanoContaFactory.criarSintetica("1.1", "ATIVO CIRCULANTE", NaturezaConta.ATIVO,
				2);

		PlanoConta caixa = PlanoContaFactory.criarAnalitica("1.1.01", "Caixa", NaturezaConta.ATIVO, 3);

		PlanoConta banco = PlanoContaFactory.criarAnalitica("1.1.02", "Banco", NaturezaConta.ATIVO, 3);

		PlanoConta clientes = PlanoContaFactory.criarAnalitica("1.1.03", "Clientes", NaturezaConta.ATIVO, 3);

		ativo.adicionarFilha(ativoCirculante);

		ativoCirculante.adicionarFilha(caixa);

		ativoCirculante.adicionarFilha(banco);

		ativoCirculante.adicionarFilha(clientes);

		/*
		 * ===================================== PASSIVO
		 * =====================================
		 */

		PlanoConta passivo = PlanoContaFactory.criarSintetica("2", "PASSIVO", NaturezaConta.PASSIVO, 1);

		PlanoConta fornecedores = PlanoContaFactory.criarAnalitica("2.1.01", "Fornecedores", NaturezaConta.PASSIVO, 3);

		passivo.adicionarFilha(fornecedores);

		/*
		 * ===================================== PATRIMÔNIO LÍQUIDO
		 * =====================================
		 */

		PlanoConta patrimonio = PlanoContaFactory.criarSintetica("3", "PATRIMÔNIO LÍQUIDO",
				NaturezaConta.PATRIMONIO_LIQUIDO, 1);

		PlanoConta capital = PlanoContaFactory.criarAnalitica("3.1.01", "Capital Social",
				NaturezaConta.PATRIMONIO_LIQUIDO, 3);

		patrimonio.adicionarFilha(capital);

		/*
		 * ===================================== RECEITAS
		 * =====================================
		 */

		PlanoConta receitas = PlanoContaFactory.criarSintetica("4", "RECEITAS", NaturezaConta.RECEITA, 1);

		PlanoConta vendas = PlanoContaFactory.criarAnalitica("4.1.01", "Receita de Vendas", NaturezaConta.RECEITA, 3);

		receitas.adicionarFilha(vendas);

		/*
		 * ===================================== DESPESAS
		 * =====================================
		 */

		PlanoConta despesas = PlanoContaFactory.criarSintetica("5", "DESPESAS", NaturezaConta.DESPESA, 1);

		PlanoConta salario = PlanoContaFactory.criarAnalitica("5.1.01", "Salários", NaturezaConta.DESPESA, 3);

		PlanoConta energia = PlanoContaFactory.criarAnalitica("5.1.02", "Energia Elétrica", NaturezaConta.DESPESA, 3);

		despesas.adicionarFilha(salario);

		despesas.adicionarFilha(energia);

		/*
		 * ===================================== PERSISTÊNCIA
		 * =====================================
		 */

		repository.salvarTodos(

				List.of(

						ativo, ativoCirculante, caixa, banco, clientes,

						passivo, fornecedores,

						patrimonio, capital,

						receitas, vendas,

						despesas, salario, energia

				)

		);

	}

}