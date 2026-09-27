package exercicios26092026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {

        RegistroFuncionario registro = new RegistroFuncionario();

        registro.salvar(
                new Funcionario(
                        "F01",
                        "Ana Souza",
                        new BigDecimal("4500.00")
                )
        );

        registro.salvar(
                new Funcionario(
                        "F02",
                        "Carlos Lima",
                        new BigDecimal("2800.00")
                )
        );

        registro.salvar(
                new Funcionario(
                        "F03",
                        "Beatriz Mendes",
                        new BigDecimal("6100.00")
                )
        );

        List<Funcionario> ricos =
                registro.filtrarFuncionarios(
                        funcionario -> funcionario.getSalario()
                                .compareTo(new BigDecimal("4000.00")) > 0
                );

        ricos.forEach(System.out::println);
    }
}