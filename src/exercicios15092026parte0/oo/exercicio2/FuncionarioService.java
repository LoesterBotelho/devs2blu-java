package exercicios15092026parte0.oo.exercicio2;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FuncionarioService {

    public static List<Funcionario> ordenarPorNome(
            List<Funcionario> funcionarios) {

        return funcionarios.stream()
                .sorted(
                        Comparator.comparing(
                                Funcionario::nome
                        )
                )
                .toList();
    }

    public static List<Funcionario> ordenarPorSalario(
            List<Funcionario> funcionarios) {

        return funcionarios.stream()
                .sorted(
                        Comparator.comparingDouble(
                                Funcionario::salario
                        ).reversed()
                )
                .toList();
    }

    public static Set<Cargo> cargos(
            List<Funcionario> funcionarios) {

        return funcionarios.stream()
                .map(Funcionario::cargo)
                .collect(Collectors.toSet());
    }

    public static Map<Long, Funcionario> mapearPorId(
            List<Funcionario> funcionarios) {

        return funcionarios.stream()
                .collect(
                        Collectors.toMap(
                                Funcionario::id,
                                funcionario -> funcionario
                        )
                );
    }

    public static Map<Cargo, List<Funcionario>> agruparPorCargo(
            List<Funcionario> funcionarios) {

        return funcionarios.stream()
                .collect(
                        Collectors.groupingBy(
                                Funcionario::cargo
                        )
                );
    }

    public static long contar(
            List<Funcionario> funcionarios,
            Predicate<Funcionario> criterio) {

        return funcionarios.stream()
                .filter(criterio)
                .count();
    }

    public static boolean existe(
            List<Funcionario> funcionarios,
            Predicate<Funcionario> criterio) {

        return funcionarios.stream()
                .anyMatch(criterio);
    }

    public static boolean todos(
            List<Funcionario> funcionarios,
            Predicate<Funcionario> criterio) {

        return funcionarios.stream()
                .allMatch(criterio);
    }

    public static boolean nenhum(
            List<Funcionario> funcionarios,
            Predicate<Funcionario> criterio) {

        return funcionarios.stream()
                .noneMatch(criterio);
    }

    public static String classificarSalario(
            double salario) {

        if (salario >= 10000) {
            return "SALÁRIO ALTO";
        }

        if (salario >= 5000) {
            return "SALÁRIO MÉDIO";
        }

        return "SALÁRIO INICIAL";
    }

    public static String classificarCargo(
            Cargo cargo) {

        return switch (cargo) {

            case DESENVOLVEDOR ->
                    "Área de Desenvolvimento";

            case ANALISTA ->
                    "Área de Análise";

            case TESTER ->
                    "Área de Qualidade";

            case DEVOPS ->
                    "Área de Infraestrutura";

            case GERENTE ->
                    "Área de Gestão";
        };
    }

    public static double calcularBonus(
            Funcionario funcionario) {

        return switch (funcionario.nivel()) {

            case JUNIOR -> funcionario.salario() * 0.05;

            case PLENO -> funcionario.salario() * 0.10;

            case SENIOR -> funcionario.salario() * 0.15;
        };
    }

}