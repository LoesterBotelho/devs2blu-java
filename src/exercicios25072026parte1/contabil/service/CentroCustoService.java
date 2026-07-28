package exercicios25072026parte1.contabil.service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.repository.CentroCustoRepository;

public class CentroCustoService {

	private final CentroCustoRepository repository;

	public CentroCustoService(CentroCustoRepository repository) {

		this.repository = repository;

	}

	public void cadastrar(CentroCusto centro) {

		validar(centro);

		validarCodigoDuplicado(centro.getCodigo());

		repository.salvar(centro);

	}

	public Optional<CentroCusto> buscarPorId(Integer id) {

		return repository.buscar(id);

	}

	public Optional<CentroCusto> buscarPorCodigo(String codigo) {

		return repository.primeiro(

				centro ->

				centro.getCodigo().equals(codigo)

		);

	}

	public List<CentroCusto> pesquisar(String texto) {

		return repository.filtrar(

				centro ->

				centro.getDescricao().toLowerCase().contains(texto.toLowerCase())

		);

	}

	public List<CentroCusto> listar() {

		return repository.listarOrdenado(

				Comparator.comparing(CentroCusto::getCodigo)

		);

	}

	public List<CentroCusto> listarAtivos() {

		return repository.filtrar(

				CentroCusto::isAtivo

		);

	}

	public void adicionarFilho(Integer idPai, CentroCusto filho) {

		CentroCusto pai =

				repository.buscar(idPai)

						.orElseThrow(

								() -> new RuntimeException("Centro pai não encontrado")

						);

		pai.adicionarFilho(filho);

	}

	public void alterarSituacao(Integer id) {

		repository.atualizar(

				id,

				centro ->

				centro.setAtivo(!centro.isAtivo())

		);

	}

	public void remover(Integer id) {

		CentroCusto centro =

				repository.buscar(id)

						.orElseThrow(

								() -> new RuntimeException("Centro não encontrado")

						);

		if (centro.possuiFilhos()) {

			throw new RuntimeException(

					"Centro possui filhos"

			);

		}

		repository.removerPorId(id);

	}

	public boolean validarRateio(Integer id) {

		CentroCusto centro =

				repository.buscar(id)

						.orElseThrow();

		return centro.rateioValido();

	}

	public void alterarPercentual(Integer id, BigDecimal percentual) {

		repository.atualizar(

				id,

				centro ->

				centro.setPercentualRateio(percentual)

		);

	}

	private void validar(CentroCusto centro) {

		if (centro == null) {

			throw new RuntimeException("Centro obrigatório");

		}

		if (centro.getCodigo() == null || centro.getCodigo().isBlank()) {

			throw new RuntimeException("Código obrigatório");

		}

		if (centro.getDescricao() == null || centro.getDescricao().isBlank()) {

			throw new RuntimeException("Descrição obrigatória");

		}

	}

	private void validarCodigoDuplicado(String codigo) {

		boolean existe =

				repository.existe(

						centro ->

						centro.getCodigo().equals(codigo)

				);

		if (existe) {

			throw new RuntimeException(

					"Código já cadastrado: " + codigo

			);

		}

	}

}