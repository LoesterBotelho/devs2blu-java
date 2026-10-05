package exercicios05102026parte0.oo.exercicio1;

public record Cliente(
        Long id,
        String nome,
        String email,
        TipoCliente tipo,
        Endereco endereco
) {
}