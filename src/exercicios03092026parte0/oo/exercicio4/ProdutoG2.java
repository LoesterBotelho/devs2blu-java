package exercicios03092026parte0.oo.exercicio4;

class ProdutoG2<T, V, S> {
    private T codigo;
    private V nome;
    private S preco;

    public ProdutoG2(T codigo, V nome, S preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Produto [Código: " + codigo + 
        		", Nome: " + nome + 
        		", Preço: " + preco + 
        		"]";
    }
}