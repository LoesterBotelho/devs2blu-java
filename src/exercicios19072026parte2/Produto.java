package exercicios19072026parte2;

public class Produto {

    private String nome;
    private int quantidade;
    private double preco;

    public Produto() {
    }

    public Produto(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getValorTotal() {
        return quantidade * preco;
    }

    public String getSituacaoEstoque() {

        if (quantidade <= 10) {
            return "ESTOQUE BAIXO";
        }

        if (quantidade <= 50) {
            return "ESTOQUE MÉDIO";
        }

        return "ESTOQUE ALTO";
    }

    @Override
    public String toString() {

        return "Produto [Nome=" + nome
                + ", Quantidade=" + quantidade
                + ", Preço=R$ " + String.format("%.2f", preco)
                + ", Total=R$ " + String.format("%.2f", getValorTotal())
                + ", Situação=" + getSituacaoEstoque()
                + "]";
    }

}