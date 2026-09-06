package exercicios05092026parte0.oo.exercicio2;

public class MainTestes {
	public static void main(String[] args) {
		Repositorio<Produto> repoProdutos = new Repositorio<>();

		repoProdutos.salvar(new Produto("Notebook Gamer", 6500.0));
		repoProdutos.salvar(new Produto("Teclado Mecânico", 350.0));
		
		repoProdutos.listarTodos().forEach(System.out::println);

		System.out.println();
		
		repoProdutos.buscarPorId(2)
		.ifPresentOrElse(
				produto -> System.out.println("Encontrado: " + produto),
				() -> System.out.println("Produto não encontrado.")
				);
	}
}