package exercicios03092026parte0.oo.exercicio2;

class ProdutoG<T, V, S> {
    private T codigo;
    private V nome;
    private S preco;

    public ProdutoG(T codigo, V nome, S preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    public T getCodigo() {
        return codigo;
    }

    public V getNome() {
        return nome;
    }

    public S getPreco() {
        return preco;
    }

	@Override
	public String toString() {
        return "Produto [Código: " + codigo + 
        		", Nome: " + nome + 
        		", Preço: " + preco + 
        		"]";
    }
}