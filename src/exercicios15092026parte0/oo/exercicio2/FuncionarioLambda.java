package exercicios15092026parte0.oo.exercicio2;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FuncionarioLambda {

    public static List<Funcionario> filtrar(
            List<Funcionario> funcionarios,
            Predicate<Funcionario> criterio) {

        return funcionarios.stream()
                .filter(criterio)
                .toList();
    }

    public static void processar(
            List<Funcionario> funcionarios,
            Consumer<Funcionario> consumidor) {

        funcionarios.forEach(consumidor);
    }

    public static <R> List<R> transformar(
            List<Funcionario> funcionarios,
            Function<Funcionario, R> function) {

        return funcionarios.stream()
                .map(function)
                .toList();
    }

    public static double calcular(
            Funcionario funcionario,
            BiFunction<Double, Funcionario, Double> calculadora) {

        return calculadora.apply(
                funcionario.salario(),
                funcionario
        );
    }

    public static Funcionario transformarFuncionario(
            Funcionario funcionario,
            UnaryOperator<Funcionario> operador) {

        return operador.apply(funcionario);
    }

    public static double combinarSalarios(
            List<Funcionario> funcionarios,
            BinaryOperator<Double> operador) {

        return funcionarios.stream()
                .map(Funcionario::salario)
                .reduce(operador)
                .orElse(0.0);
    }

    public static Funcionario fornecer(
            Supplier<Funcionario> fornecedor) {

        return fornecedor.get();
    }

}