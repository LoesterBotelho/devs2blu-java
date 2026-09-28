package exercicios28092026parte0.oo.exercicio2;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class ProcessadorUsuarios {

    private ProcessadorUsuarios() {
    }

    public static <T> List<T> filtrar(
            List<T> elementos,
            Predicate<T> criterio) {

        return elementos.stream()
                .filter(criterio)
                .toList();
    }

    public static <T, R> List<R> transformar(
            List<T> elementos,
            Function<T, R> funcao) {

        return elementos.stream()
                .map(funcao)
                .toList();
    }

    public static <T> void consumir(
            List<T> elementos,
            Consumer<T> consumidor) {

        elementos.forEach(consumidor);
    }

    public static <T> Optional<T> primeiro(
            List<T> elementos) {

        return elementos.stream()
                .findFirst();
    }

    public static <T> long contar(
            List<T> elementos,
            Predicate<T> criterio) {

        return elementos.stream()
                .filter(criterio)
                .count();
    }

    public static Map<Perfil, List<Usuario>> agruparPorPerfil(
            List<Usuario> usuarios) {

        return usuarios.stream()
                .collect(
                        Collectors.groupingBy(
                                Usuario::getPerfil
                        )
                );
    }

    public static Map<StatusUsuario, List<Usuario>> agruparPorStatus(
            List<Usuario> usuarios) {

        return usuarios.stream()
                .collect(
                        Collectors.groupingBy(
                                Usuario::getStatus
                        )
                );
    }

    public static Map<String, List<Usuario>> agruparPorCidade(
            List<Usuario> usuarios) {

        return usuarios.stream()
                .collect(
                        Collectors.groupingBy(
                                Usuario::getCidade
                        )
                );
    }

    public static Map<Boolean, List<Usuario>> particionarPorSalario(
            List<Usuario> usuarios,
            java.math.BigDecimal limite) {

        return usuarios.stream()
                .collect(
                        Collectors.partitioningBy(
                                usuario ->
                                        usuario.getSalario()
                                                .compareTo(limite) > 0
                        )
                );
    }
}