package exercicios25102026parte0.oo.exercicio1;

public record Endereco(
        String rua,
        String numero,
        String cidade,
        String estado,
        String cep) {

    public Endereco {
        if (rua == null || rua.isBlank()
                || numero == null || numero.isBlank()
                || cidade == null || cidade.isBlank()
                || estado == null || estado.isBlank()
                || cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("Endereço incompleto");
        }
    }

    @Override
    public String toString() {
        return rua + ", " + numero + " - " + cidade + "/" + estado
                + " - CEP: " + cep;
    }
}