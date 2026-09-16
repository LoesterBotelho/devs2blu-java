package exercicios15092026parte0.oo.exercicio2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MainTestes {

    public static final String MSG_PADRAO = "\n------------------------------------------------------------------------------------------";

    public static void main(String[] args) {

        List<Funcionario> funcionarios =
                InserirDados.funcionarios();

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("TESTE 1: LISTA DE FUNCIONÁRIOS");

        funcionarios.forEach(item ->
                System.out.println(
                        item.id()
                                + " - "
                                + item.nome()
                                + " - "
                                + item.cargo()
                                + " - "
                                + item.nivel()
                                + " - R$ "
                                + item.salario()
                )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 2: LAMBDA COM FOR EACH");

        funcionarios.forEach(
                item ->
                        System.out.println(
                                item.nome()
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 3: PREDICATE");

        List<Funcionario> desenvolvedores =
                FuncionarioLambda.filtrar(
                        funcionarios,
                        item ->
                                item.cargo()
                                        == Cargo.DESENVOLVEDOR
                );

        desenvolvedores.forEach(
                item ->
                        System.out.println(
                                item.nome()
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 4: PREDICATE + IF");

        FuncionarioLambda.processar(
                funcionarios,
                item -> {

                    if (item.salario() >= 7000) {

                        System.out.println(
                                item.nome()
                                        + " recebe salário alto"
                        );

                    } else {

                        System.out.println(
                                item.nome()
                                        + " recebe salário abaixo de 7000"
                        );
                    }
                }
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 5: SWITCH COM CARGO");

        FuncionarioLambda.processar(
                funcionarios,
                item ->
                        System.out.println(
                                item.nome()
                                        + " - "
                                        + FuncionarioService.classificarCargo(
                                        item.cargo()
                                )
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 6: SWITCH COM NÍVEL");

        FuncionarioLambda.processar(
                funcionarios,
                item ->
                        System.out.println(
                                item.nome()
                                        + " - Bônus: R$ "
                                        + FuncionarioService.calcularBonus(
                                        item
                                )
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 7: FUNCTION");

        List<String> nomes =
                FuncionarioLambda.transformar(
                        funcionarios,
                        Funcionario::nome
                );

        nomes.forEach(
                System.out::println
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 8: FUNCTION");

        List<Double> salarios =
                FuncionarioLambda.transformar(
                        funcionarios,
                        Funcionario::salario
                );

        salarios.forEach(
                salario ->
                        System.out.println(
                                "R$ " + salario
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 9: CONSUMER");

        FuncionarioLambda.processar(
                funcionarios,
                item ->
                        System.out.println(
                                "Processando funcionário: "
                                        + item.nome()
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 10: BIFUNCTION");

        double salarioComAumento =
                FuncionarioLambda.calcular(
                        funcionarios.get(0),
                        (salario, funcionarioItem) ->
                                salario * 1.10
                );

        System.out.println(
                "Salário com aumento: R$ "
                        + salarioComAumento
        );
        
        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 11: UNARY OPERATOR");

        Funcionario funcionarioSelecionado =
                funcionarios.get(0);

        Funcionario funcionarioAlterado =
                FuncionarioLambda.transformarFuncionario(
                        funcionarioSelecionado,
                        item ->
                                new Funcionario(
                                        item.id(),
                                        item.nome(),
                                        item.cargo(),
                                        item.nivel(),
                                        item.salario() * 1.10
                                )
                );

        System.out.println(
                funcionarioAlterado.nome()
                        + " - R$ "
                        + funcionarioAlterado.salario()
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 12: BINARY OPERATOR");

        double totalSalarios =
                FuncionarioLambda.combinarSalarios(
                        funcionarios,
                        Double::sum
                );

        System.out.println(
                "Total salários: R$ "
                        + totalSalarios
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 13: SUPPLIER");

        Funcionario novoFuncionario =
                FuncionarioLambda.fornecer(
                        () ->
                                new Funcionario(
                                        7L,
                                        "Lucas Martins",
                                        Cargo.DESENVOLVEDOR,
                                        Nivel.JUNIOR,
                                        4000.00
                                )
                );

        System.out.println(
                novoFuncionario
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 14: SORTED + COMPARATOR");

        List<Funcionario> ordenadosPorNome =
                FuncionarioService.ordenarPorNome(
                        funcionarios
                );

        ordenadosPorNome.forEach(
                item ->
                        System.out.println(
                                item.nome()
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 15: SORTED POR SALÁRIO");

        List<Funcionario> ordenadosPorSalario =
                FuncionarioService.ordenarPorSalario(
                        funcionarios
                );

        ordenadosPorSalario.forEach(
                item ->
                        System.out.println(
                                item.nome()
                                        + " - R$ "
                                        + item.salario()
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 16: SET + DISTINCT");

        Set<Cargo> cargos =
                FuncionarioService.cargos(
                        funcionarios
                );

        cargos.forEach(
                cargo ->
                        System.out.println(
                                cargo
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 17: MAP");

        Map<Long, Funcionario> funcionariosPorId =
                FuncionarioService.mapearPorId(
                        funcionarios
                );

        funcionariosPorId.forEach(
                (id, item) ->
                        System.out.println(
                                id
                                        + " - "
                                        + item.nome()
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 18: GROUPING BY");

        Map<Cargo, List<Funcionario>> agrupadosPorCargo =
                FuncionarioService.agruparPorCargo(
                        funcionarios
                );

        agrupadosPorCargo.forEach(
                (cargo, lista) -> {

                    System.out.println(
                            "\n"
                                    + cargo
                    );

                    lista.forEach(
                            item ->
                                    System.out.println(
                                            " - "
                                                    + item.nome()
                                    )
                    );
                }
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 19: COUNT");

        long quantidadeSenior =
                FuncionarioService.contar(
                        funcionarios,
                        item ->
                                item.nivel()
                                        == Nivel.SENIOR
                );

        System.out.println(
                "Quantidade de Senior: "
                        + quantidadeSenior
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 20: ANY MATCH");

        boolean existeGerente =
                FuncionarioService.existe(
                        funcionarios,
                        item ->
                                item.cargo()
                                        == Cargo.GERENTE
                );

        System.out.println(
                "Existe gerente: "
                        + existeGerente
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 21: ALL MATCH");

        boolean todosRecebemMaisDe3000 =
                FuncionarioService.todos(
                        funcionarios,
                        item ->
                                item.salario() > 3000
                );

        System.out.println(
                "Todos recebem mais de 3000: "
                        + todosRecebemMaisDe3000
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 22: NONE MATCH");

        boolean nenhumJunior =
                FuncionarioService.nenhum(
                        funcionarios,
                        item ->
                                item.nivel()
                                        == Nivel.JUNIOR
                );

        System.out.println(
                "Nenhum Junior: "
                        + nenhumJunior
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 23: IF + LAMBDA");

        FuncionarioLambda.processar(
                funcionarios,
                item -> {

                    String classificacao =
                            FuncionarioService.classificarSalario(
                                    item.salario()
                            );

                    System.out.println(
                            item.nome()
                                    + " - "
                                    + classificacao
                    );
                }
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 24: QUEUE + LAMBDA");

        Queue<Funcionario> fila =
                new ArrayDeque<>();

        funcionarios.forEach(
                fila::offer
        );

        while (!fila.isEmpty()) {

            Funcionario item =
                    fila.poll();

            System.out.println(
                    "Processando: "
                            + item.nome()
            );
        }

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 25: DEQUE + LAMBDA");

        Deque<Funcionario> historico =
                new ArrayDeque<>();

        funcionarios.forEach(
                historico::push
        );

        historico.forEach(
                item ->
                        System.out.println(
                                item.nome()
                        )
        );

        //------------------------------------------------------------------------------------------
        
        System.out.println(MSG_PADRAO);
        System.out.println("\nTESTE 26: ARRAYLIST + LAMBDA");

        List<String> listaNomes =
                new ArrayList<>();

        funcionarios.forEach(
                item ->
                        listaNomes.add(
                                item.nome()
                        )
        );

        listaNomes.forEach(
                System.out::println
        );
        
        //------------------------------------------------------------------------------------------
        
    }

}