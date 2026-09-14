package exercicios13092026parte0.oo.exercicio1;

public record ProdutoDigital(
        Long id,
        String nome,
        double preco,
        double tamanhoMb
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