package exercicios25072026parte1.contabil.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;

public class PlanoContaService {

	private final PlanoContaRepository repository;

	public PlanoContaService(PlanoContaRepository repository) {

		this.repository = repository;

	}

	/*
	 * =============================== CADASTRO ===============================
	 */

	public void cadastrar(PlanoConta conta) {

		validar(conta);

		repository.salvar(conta);

	}

	public void cadastrarTodos(List<PlanoConta> contas) {

		contas.forEach(

				this::cadastrar

		);

	}

	/*
	 * Compatibilidade
	 */

	public void salvar(PlanoConta conta) {

		cadastrar(conta);

	}

	public void salvarTodos(List<PlanoConta> contas) {

		cadastrarTodos(contas);

	}

	/*
	 * =============================== BUSCAS ===============================
	 */

	public Optional<PlanoConta> buscar(Integer id) {

		return repository.buscar(id);

	}

	public Optional<PlanoConta> buscarPorCodigo(String codigo) {

		return repository.listar()

				.stream()

				.filter(

						conta ->

						conta.getCodigo().equals(codigo)

				)

				.findFirst();

	}

	public PlanoConta buscarContaLancamento(String codigo) {

		PlanoConta conta =

				buscarPorCodigo(codigo)

						.orElseThrow(

								() -> new RuntimeException(

										"Conta não encontrada: " + codigo

								)

						);

		if (!conta.isAceitaLancamento()) {

			throw new RuntimeException(

					"Conta sintética não aceita lançamento: " + conta.getDescricao()

			);

		}

		return conta;

	}

	/*
	 * =============================== LISTAGEM ===============================
	 */

	public List<PlanoConta> listar() {

		return repository.listar()

				.stream()

				.sorted(

						Comparator.comparing(PlanoConta::getCodigo)

				)

				.toList();

	}

	public List<PlanoConta> listarAnaliticas() {

		return filtrar(

				PlanoConta::isAnalitica

		);

	}

	public List<PlanoConta> listarSinteticas() {

		return filtrar(

				PlanoConta::isSintetica

		);

	}

	public List<PlanoConta> filtrar(Predicate<PlanoConta> filtro) {

		return repository.listar()

				.stream()

				.filter(filtro)

				.toList();

	}

	/*
	 * =============================== HIERARQUIA ===============================
	 */

	public void adicionarFilha(Integer idContaPai, PlanoConta filha) {

		PlanoConta pai =

				buscar(idContaPai)

						.orElseThrow(

								() -> new RuntimeException(

										"Conta pai não encontrada"

								)

						);

		pai.adicionarFilha(filha);

	}

	public void removerFilha(Integer idContaPai, PlanoConta filha) {

		PlanoConta pai =

				buscar(idContaPai)

						.orElseThrow(

								() -> new RuntimeException(

										"Conta pai não encontrada"

								)

						);

		pai.removerFilha(filha);

	}

	/*
	 * =============================== ÁRVORE ===============================
	 */

	public void imprimirArvore() {

		listar()

				.stream()

				.filter(

						conta ->

						conta.getContaPai() == null

				)

				.forEach(

						conta ->

						imprimirRecursivo(conta, "")

				);

	}

	private void imprimirRecursivo(PlanoConta conta, String espacos) {

		System.out.println(

				espacos + conta.getCodigo() + " - " + conta.getDescricao()

		);

		conta.getContasFilhas()

				.stream()

				.sorted()

				.forEach(

						filha ->

						imprimirRecursivo(

								filha,

								espacos + "    "

						)

				);

	}

	/*
	 * =============================== ESTATÍSTICAS ===============================
	 */

	public long quantidadeContas() {

		return repository.listar()

				.stream()

				.count();

	}

	public long quantidadeAnaliticas() {

		return listarAnaliticas()

				.size();

	}

	public long quantidadeSinteticas() {

		return listarSinteticas()

				.size();

	}

	/*
	 * =============================== REMOVER ===============================
	 */

	public void remover(Integer id) {

		repository.removerPorId(id);

	}

	/*
	 * =============================== VALIDAÇÕES ===============================
	 */

	private void validar(PlanoConta conta) {

		if (conta == null) {

			throw new RuntimeException(

					"Conta obrigatória"

			);

		}

		if (conta.getCodigo() == null || conta.getCodigo().isBlank()) {

			throw new RuntimeException(

					"Código obrigatório"

			);

		}

		if (conta.getDescricao() == null || conta.getDescricao().isBlank()) {

			throw new RuntimeException(

					"Descrição obrigatória"

			);

		}

		boolean existe =

				repository.listar()

						.stream()

						.anyMatch(

								c ->

								c.getCodigo().equals(conta.getCodigo())

						);

		if (existe) {

			throw new RuntimeException(

					"Conta já cadastrada: " + conta.getCodigo()

			);

		}

	}

}