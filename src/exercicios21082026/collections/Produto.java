package exercicios21082026.collections;

public class Produto implements Comparable<Produto> {
    private int id;
    private String nome;
    private double preco;

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public double getPreco() { return preco; }

    @Override
    public int compareTo(Produto outro) {
        // Ordenação natural por ID
        return Integer.compare(this.id, outro.id);
    }

    @Override
    public String toString() {
        return String.format("Produto{id=%d, nome='%s', preco=R$ %.2f}", id, nome, preco);
    }
}