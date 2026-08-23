package exercicios22082026parte0.oo.exercicio0;

@Tabela(nome = "usuarios", schema = "public")
public class Usuario {

	@Id
	@Campo(nome = "id", tipo = TipoDado.BIGINT, nullable = false)
	private Long id;

	@Campo(nome = "nome", tipo = TipoDado.VARCHAR, tamanho = 100, nullable = false)
	private String nome;

	@Campo(nome = "email", tipo = TipoDado.VARCHAR, tamanho = 150, nullable = false)
	private String email;

	@Campo(nome = "idade", tipo = TipoDado.INTEGER)
	private Integer idade;

	public Usuario(Long id, String nome, String email, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.idade = idade;
	}
}