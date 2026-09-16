package exercicios15092026parte0.oo.exercicio1;

import java.util.List;

public class CalculadoraFolha {

    public static <T extends Calculavel> double calcularTotal(
            List<T> itens) {

        return itens.stream()
                .mapToDouble(
                        Calculavel::calcular
                )
                .sum();
    }

    public static double calcularSalarioBruto(
            Funcionario funcionario,
            List<Provento> proventos) {

        return funcionario.salarioBase()
                + calcularTotal(proventos);
    }

    public static double calcularSalarioLiquido(
            Funcionario funcionario,
            List<Provento> proventos,
            List<Desconto> descontos) {

        double bruto =
                calcularSalarioBruto(
                        funcionario,
                        proventos
                );

        double totalDescontos =
                calcularTotal(descontos);

        return bruto - totalDescontos;
    }

}
