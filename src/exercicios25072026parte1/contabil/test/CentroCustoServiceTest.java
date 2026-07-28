package exercicios25072026parte1.contabil.test;

import java.math.BigDecimal;

import exercicios25072026parte1.contabil.enums.TipoCentroCusto;
import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.repository.CentroCustoRepository;
import exercicios25072026parte1.contabil.service.CentroCustoService;

public class CentroCustoServiceTest {

	public static void main(String[] args) {

		CentroCustoRepository repository = new CentroCustoRepository();

		CentroCustoService service = new CentroCustoService(repository);

		CentroCusto administrativo =

				new CentroCusto(

						1, "10", "Administrativo", TipoCentroCusto.SINTETICO

				);

		CentroCusto rh =

				new CentroCusto(

						2, "10.01", "Recursos Humanos", TipoCentroCusto.ANALITICO

				);

		CentroCusto financeiro =

				new CentroCusto(

						3, "10.02", "Financeiro", TipoCentroCusto.ANALITICO

				);

		rh.setPercentualRateio(BigDecimal.valueOf(40));

		financeiro.setPercentualRateio(BigDecimal.valueOf(60));

		service.cadastrar(administrativo);

		service.cadastrar(rh);

		service.cadastrar(financeiro);

		service.adicionarFilho(1, rh);

		service.adicionarFilho(1, financeiro);

		administrativo.imprimir("");

		System.out.println();

		System.out.println(

				"Rateio válido: "

						+ administrativo.rateioValido()

		);

	}

}