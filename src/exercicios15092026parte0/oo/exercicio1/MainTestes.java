package exercicios15092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class MainTestes {

    public static final String MSG_PADRAO = "\n------------------------------------------------------------------------------------------";

    public static void main(String[] args) {

        List<Funcionario> funcionarios =
                InserirDados.funcionarios();

        System.out.println(MSG_PADRAO);
        System.out.println("TESTE 1: LISTA DE FUNCIONÁRIOS");

        funcionarios.forEach(funcionario ->
                System.out.println(
                        funcionario.id()
                                + " - "
                                + funcionario.nome()
                                + " - R$ "
                                + funcionario.salarioBase()
                )
        );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 2: REGISTRO DE PONTO");

        funcionarios.forEach(funcionario -> {

            List<RegistroPonto> registros =
                    InserirDados.registrosPonto(
                            funcionario
                    );

            System.out.println(
                    "\nFuncionário: "
                            + funcionario.nome()
            );

            registros.forEach(registro ->
                    System.out.println(
                            registro.entrada()
                                    + " → "
                                    + registro.saida()
                                    + " - "
                                    + registro.calcularHoras()
                                    + " horas"
                    )
            );
        });

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 3: CÁLCULO DE HORAS");

        funcionarios.forEach(funcionario -> {

            List<RegistroPonto> registros =
                    InserirDados.registrosPonto(
                            funcionario
                    );

            double horas =
                    CalculadoraHoras.calcularTotal(
                            registros
                    );

            double horasExtras =
                    CalculadoraHoras.calcularHorasExtras(
                            registros,
                            16.0
                    );

            System.out.println(
                    funcionario.nome()
                            + " - Horas: "
                            + horas
                            + " - Extras: "
                            + horasExtras
            );
        });

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 4: PROVENTOS");

        List<Provento> proventos =
                InserirDados.proventos();

        proventos.forEach(provento ->
                System.out.println(
                        provento.descricao()
                                + " - R$ "
                                + provento.valor()
                )
        );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 5: DESCONTOS");

        List<Desconto> descontos =
                InserirDados.descontos();

        descontos.forEach(desconto ->
                System.out.println(
                        desconto.descricao()
                                + " - R$ "
                                + desconto.valor()
                )
        );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 6: GENERICS CALCULAVEL");

        double totalProventos =
                CalculadoraFolha.calcularTotal(
                        proventos
                );

        double totalDescontos =
                CalculadoraFolha.calcularTotal(
                        descontos
                );

        System.out.println(
                "Total proventos: R$ "
                        + totalProventos
        );

        System.out.println(
                "Total descontos: R$ "
                        + totalDescontos
        );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 7: HOLERITE DOS FUNCIONÁRIOS");

        funcionarios.forEach(funcionario -> {

            List<Provento> proventosFuncionario =
                    InserirDados.proventos();

            List<Desconto> descontosFuncionario =
                    InserirDados.descontos();

            Holerite holerite =
                    new Holerite(
                            funcionario,
                            funcionario.salarioBase(),
                            proventosFuncionario,
                            descontosFuncionario
                    );

            System.out.println(
                    "\nFuncionário: "
                            + funcionario.nome()
            );

            System.out.println(
                    "Salário base: R$ "
                            + holerite.salarioBase()
            );

            System.out.println(
                    "Proventos: R$ "
                            + holerite.totalProventos()
            );

            System.out.println(
                    "Salário bruto: R$ "
                            + holerite.salarioBruto()
            );

            System.out.println(
                    "Descontos: R$ "
                            + holerite.totalDescontos()
            );

            System.out.println(
                    "Salário líquido: R$ "
                            + holerite.salarioLiquido()
            );
        });

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 8: REPOSITÓRIO GENÉRICO");

        Repositorio<Funcionario, Long> repositorio =
                new RepositorioEmMemoria<>();

        funcionarios.forEach(
                repositorio::salvar
        );

        repositorio.listar()
                .forEach(funcionario ->
                        System.out.println(
                                funcionario.id()
                                        + " - "
                                        + funcionario.nome()
                        )
                );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 9: BUSCAR FUNCIONÁRIO");

        repositorio.buscarPorId(2L)
                .ifPresent(funcionario ->
                        System.out.println(
                                "Encontrado: "
                                        + funcionario.nome()
                        )
                );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 10: FILTRO GENERICS");

        List<Funcionario> salariosAltos =
                RhUtil.filtrar(
                        funcionarios,
                        funcionario ->
                                funcionario.salarioBase()
                                        >= 3500
                );

        salariosAltos.forEach(funcionario ->
                System.out.println(
                        funcionario.nome()
                                + " - R$ "
                                + funcionario.salarioBase()
                )
        );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 11: MAP GENERICS");

        List<String> nomes =
                RhUtil.mapear(
                        funcionarios,
                        Funcionario::nome
                );

        nomes.forEach(System.out::println);

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 12: CONSUMER GENERICS");

        RhUtil.processar(
                funcionarios,
                funcionario ->
                        System.out.println(
                                "Processando: "
                                        + funcionario.nome()
                        )
        );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 13: LIST + SUPER");

        List<Identifiable<Long>> destino =
                new ArrayList<>();

        RhUtil.adicionarTodos(
                destino,
                funcionarios
        );

        System.out.println(
                "Itens adicionados: "
                        + destino.size()
        );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 14: EVENTO GENÉRICO");

        EventoFolha<Provento> eventoProvento =
                new EventoFolha<>(
                        TipoEvento.PROVENTO,
                        new Provento(
                                "Hora extra",
                                750.00
                        )
                );

        EventoFolha<Desconto> eventoDesconto =
                new EventoFolha<>(
                        TipoEvento.DESCONTO,
                        new Desconto(
                                "INSS",
                                350.00
                        )
                );

        System.out.println(
                eventoProvento.tipo()
                        + " - R$ "
                        + eventoProvento.calcular()
        );

        System.out.println(
                eventoDesconto.tipo()
                        + " - R$ "
                        + eventoDesconto.calcular()
        );

        // ------------------------------------------------------------------------------------------

        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 15: QUEUE");

        FilaProcessamento<Funcionario> fila =
                new FilaProcessamento<>();

        funcionarios.forEach(
                fila::adicionar
        );

        System.out.println(
                "Itens na fila: "
                        + fila.tamanhoFila()
        );

        Funcionario primeiro =
                fila.processar();

        System.out.println(
                "Processado: "
                        + primeiro.nome()
        );

        System.out.println(
                "Itens restantes: "
                        + fila.tamanhoFila()
        );

        System.out.println(
                "Itens no histórico: "
                        + fila.tamanhoHistorico()
        );

        // ------------------------------------------------------------------------------------------

    }

}
