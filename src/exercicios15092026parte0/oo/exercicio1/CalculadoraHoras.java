package exercicios15092026parte0.oo.exercicio1;

import java.util.List;

public class CalculadoraHoras {

    public static double calcularTotal(
            List<RegistroPonto> registros) {

        return registros.stream()
                .mapToDouble(
                        RegistroPonto::calcularHoras
                )
                .sum();
    }

    public static double calcularHorasExtras(
            List<RegistroPonto> registros,
            double jornada) {

        double horas =
                calcularTotal(registros);

        return Math.max(
                0,
                horas - jornada
        );
    }

}