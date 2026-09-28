package exercicios28092026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class MainTestes {

    public static void main(String[] args) {

        List<Usuario> usuarios = List.of(

                new Usuario(
                        1L,
                        "João",
                        "joao@email.com",
                        Perfil.DESENVOLVEDOR,
                        StatusUsuario.ATIVO,
                        new BigDecimal("8500.00"),
                        "Blumenau"
                ),

                new Usuario(
                        2L,
                        "Maria",
                        "maria@email.com",
                        Perfil.GERENTE,
                        StatusUsuario.ATIVO,
                        new BigDecimal("12000.00"),
                        "Blumenau"
                ),

                new Usuario(
                        3L,
                        "Carlos",
                        "carlos@email.com",
                        Perfil.ANALISTA,
                        StatusUsuario.ATIVO,
                        new BigDecimal("6500.00"),
                        "Joinville"
                ),

                new Usuario(
                        4L,
                        "Ana",
                        "ana@email.com",
                        Perfil.DESENVOLVEDOR,
                        StatusUsuario.INATIVO,
                        new BigDecimal("9200.00"),
                        "Florianopolis"
                ),

                new Usuario(
                        5L,
                        "Pedro",
                        "pedro@email.com",
                        Perfil.ESTAGIARIO,
                        StatusUsuario.ATIVO,
                        new BigDecimal("2200.00"),
                        "Blumenau"
                ),

                new Usuario(
                        6L,
                        "Fernanda",
                        "fernanda@email.com",
                        Perfil.ADMIN,
                        StatusUsuario.ATIVO,
                        new BigDecimal("10500.00"),
                        "Curitiba"
                ),

                new Usuario(
                        7L,
                        "Lucas",
                        "lucas@email.com",
                        Perfil.DESENVOLVEDOR,
                        StatusUsuario.BLOQUEADO,
                        new BigDecimal("7800.00"),
                        "Joinville"
                ),

                new Usuario(
                        8L,
                        "Juliana",
                        "juliana@email.com",
                        Perfil.ANALISTA,
                        StatusUsuario.ATIVO,
                        new BigDecimal("7200.00"),
                        "Blumenau"
                ),

                new Usuario(
                        9L,
                        "Rafael",
                        "rafael@email.com",
                        Perfil.GERENTE,
                        StatusUsuario.ATIVO,
                        new BigDecimal("13500.00"),
                        "Florianopolis"
                ),

                new Usuario(
                        10L,
                        "Camila",
                        "camila@email.com",
                        Perfil.ESTAGIARIO,
                        StatusUsuario.INATIVO,
                        new BigDecimal("2000.00"),
                        "Curitiba"
                )
        );

        System.out.println("TODOS OS USUARIOS");

        usuarios.forEach(
                System.out::println
        );

        System.out.println("\nUSUARIOS ATIVOS");

        List<Usuario> ativos =
                ProcessadorUsuarios.filtrar(
                        usuarios,
                        usuario ->
                                usuario.getStatus()
                                        == StatusUsuario.ATIVO
                );

        ativos.forEach(
                System.out::println
        );

        System.out.println("\nDESENVOLVEDORES");

        List<Usuario> desenvolvedores =
                ProcessadorUsuarios.filtrar(
                        usuarios,
                        usuario ->
                                usuario.getPerfil()
                                        == Perfil.DESENVOLVEDOR
                );

        desenvolvedores.forEach(
                System.out::println
        );

        System.out.println("\nSALARIO ACIMA DE 8.000");

        List<Usuario> salariosAltos =
                ProcessadorUsuarios.filtrar(
                        usuarios,
                        usuario ->
                                usuario.getSalario()
                                        .compareTo(
                                                new BigDecimal("8000.00")
                                        ) > 0
                );

        salariosAltos.forEach(
                System.out::println
        );

        System.out.println("\nNOMES");

        List<String> nomes =
                ProcessadorUsuarios.transformar(
                        usuarios,
                        Usuario::getNome
                );

        nomes.forEach(
                System.out::println
        );

        System.out.println("\nEMAILS");

        List<String> emails =
                ProcessadorUsuarios.transformar(
                        usuarios,
                        Usuario::getEmail
                );

        emails.forEach(
                System.out::println
        );

        System.out.println("\nUSUARIO COM MAIOR SALARIO");

        usuarios.stream()
                .max(
                        java.util.Comparator.comparing(
                                Usuario::getSalario
                        )
                )
                .ifPresent(
                        System.out::println
                );

        System.out.println("\nUSUARIO COM MENOR SALARIO");

        usuarios.stream()
                .min(
                        java.util.Comparator.comparing(
                                Usuario::getSalario
                        )
                )
                .ifPresent(
                        System.out::println
                );

        System.out.println("\nUSUARIOS ORDENADOS POR SALARIO");

        usuarios.stream()
                .sorted(
                        java.util.Comparator.comparing(
                                Usuario::getSalario
                        )
                )
                .forEach(
                        System.out::println
                );

        System.out.println(
                "\nUSUARIOS ORDENADOS POR SALARIO DESCENDENTE ==="
        );

        usuarios.stream()
                .sorted(
                        java.util.Comparator.comparing(
                                Usuario::getSalario
                        ).reversed()
                )
                .forEach(
                        System.out::println
                );

        System.out.println("\nAGRUPADOS POR PERFIL");

        Map<Perfil, List<Usuario>> porPerfil =
                ProcessadorUsuarios.agruparPorPerfil(
                        usuarios
                );

        porPerfil.forEach(
                (perfil, lista) -> {

                    System.out.println(
                            "\n" + perfil
                    );

                    lista.forEach(
                            System.out::println
                    );
                }
        );

        System.out.println("\nAGRUPADOS POR STATUS");

        Map<StatusUsuario, List<Usuario>> porStatus =
                ProcessadorUsuarios.agruparPorStatus(
                        usuarios
                );

        porStatus.forEach(
                (status, lista) ->
                        System.out.println(
                                status +
                                " -> " +
                                lista.size()
                        )
        );

        System.out.println("\nAGRUPADOS POR CIDADE");

        Map<String, List<Usuario>> porCidade =
                ProcessadorUsuarios.agruparPorCidade(
                        usuarios
                );

        porCidade.forEach(
                (cidade, lista) ->
                        System.out.println(
                                cidade +
                                " -> " +
                                lista.size()
                        )
        );

        System.out.println("\nPARTICIONAMENTO POR SALARIO");

        Map<Boolean, List<Usuario>> salarioParticionado =
                ProcessadorUsuarios.particionarPorSalario(
                        usuarios,
                        new BigDecimal("8000.00")
                );

        System.out.println("\nAcima de R$ 8.000:");

        salarioParticionado
                .get(true)
                .forEach(
                        System.out::println
                );

        System.out.println("\nAté R$ 8.000:");

        salarioParticionado
                .get(false)
                .forEach(
                        System.out::println
                );

        System.out.println("\nPRIMEIRO USUARIO");

        ProcessadorUsuarios.primeiro(
                        usuarios
                )
                .ifPresent(
                        System.out::println
                );

        System.out.println("\nCONTAGEM DE DESENVOLVEDORES");

        long quantidadeDesenvolvedores =
                ProcessadorUsuarios.contar(
                        usuarios,
                        usuario ->
                                usuario.getPerfil()
                                        == Perfil.DESENVOLVEDOR
                );

        System.out.println(
                quantidadeDesenvolvedores
        );
    }
}