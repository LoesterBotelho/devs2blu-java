package exercicios13092026parte0.oo.exercicio1;

public record ProdutoFisico(
        Long id,
        String nome,
        double preco,
        double peso
) implements Identifiable<Long>, Precificavel {

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public double getPreco() {
        return preco;
    }

}