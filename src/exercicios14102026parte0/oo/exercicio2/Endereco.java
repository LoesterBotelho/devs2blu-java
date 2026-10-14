package exercicios14102026parte0.oo.exercicio2;

public record Endereco(
        String rua,
        String cidade,
        String estado,
        String cep) {

    public Endereco {
        if (rua == null || rua.isBlank()
                || cidade == null || cidade.isBlank()
                || estado == null || estado.isBlank()
                || cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("Endereco invalido");
        }
    }

    @Override
    public String toString() {
        return rua + ", " + cidade + " - " + estado + " - " + cep;
    }
}