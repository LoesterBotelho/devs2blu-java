package exercicios12092026parte0.oo.exercicio1;

public record Produto(String id, String descricao, double preco) implements Identifiable<String> {

	@Override
	public String getId() {
		return id;
	}

}