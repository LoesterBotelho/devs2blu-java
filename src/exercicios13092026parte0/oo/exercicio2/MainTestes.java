package exercicios13092026parte0.oo.exercicio2;

import java.util.ArrayList;
import java.util.List;

public class MainTestes {

    public static final String MSG_PADRAO =
            "\n------------------------------------------------------------------------------------------";

    public static void main(String[] args) {

        List<Funcionario> funcionarios = InserirDados.funcionarios();

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("TESTE 1: LISTAR FUNCIONÁRIOS");

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
        System.out.println("\nTESTE 2: CÁLCULO DE FOLHA");

        funcionarios.forEach(funcionario -> {

            List<Provento> proventos =
                    InserirDados.proventos();

            List<Desconto> descontos =
                    InserirDados.descontos();

            Holerite holerite = new Holerite(
                    funcionario,
                    funcionario.salarioBase(),
                    proventos,
                    descontos
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
                    "Total proventos: R$ "
                            + holerite.totalProventos()
            );

            System.out.println(
                    "Salário bruto: R$ "
                            + holerite.salarioBruto()
            );

            System.out.println(
                    "Total descontos: R$ "
                            + holerite.totalDescontos()
            );

            System.out.println(
                    "Salário líquido: R$ "
                            + holerite.salarioLiquido()
            );
        });

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 3: REPOSITÓRIO GENÉRICO");

        Repositorio<Funcionario, Long> repositorio =
                new RepositorioEmMemoria<>();

        funcionarios.forEach(repositorio::salvar);

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
        System.out.println("\nTESTE 4: BUSCAR FUNCIONÁRIO");

        repositorio.buscarPorId(2L)
                .ifPresent(funcionario ->
                        System.out.println(
                                funcionario.nome()
                                        + " - R$ "
                                        + funcionario.salarioBase()
                        )
                );

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 5: PROVENTOS");

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
        System.out.println("\nTESTE 6: DESCONTOS");

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
        System.out.println("\nTESTE 7: CÁLCULO GENÉRICO");

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
        System.out.println("\nTESTE 8: FILTRO GENÉRICO");

        List<Provento> proventosAltos =
                RhUtil.filtrar(
                        proventos,
                        provento -> provento.valor() >= 500
                );

        proventosAltos.forEach(provento ->
                System.out.println(
                        provento.descricao()
                                + " - R$ "
                                + provento.valor()
                )
        );

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 9: MAPEAMENTO GENÉRICO");

        List<String> nomesProventos =
                RhUtil.mapear(
                        proventos,
                        Provento::descricao
                );

        nomesProventos.forEach(System.out::println);

        // ------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 10: CONSUMER SUPER");

        List<Calculavel> destino =
                new ArrayList<>();

        RhUtil.adicionarTodos(
                destino,
                proventos
        );

        RhUtil.adicionarTodos(
                destino,
                descontos
        );

        System.out.println(
                "Itens adicionados: "
                        + destino.size()
        );

        // ------------------------------------------------------------------------------------------

    }

}