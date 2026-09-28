package exercicios27092026parte0.oo.exercicio2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {

        List<Gerente> gerentes = List.of(
                new Gerente(
                        "João",
                        "Gerente de TI",
                        new BigDecimal("12000.00")
                ),
                new Gerente(
                        "Maria",
                        "Gerente Comercial",
                        new BigDecimal("10000.00")
                )
        );

        List<Funcionario> funcionarios = new ArrayList<>();

        ProcessadorGenerico.copiar(
                gerentes,
                funcionarios
        );

        System.out.println("FUNCIONARIOS");

        ProcessadorGenerico.consumir(
                funcionarios,
                System.out::println
        );

        System.out.println("\nNOMES");

        List<String> nomes =
                ProcessadorGenerico.transformar(
                        funcionarios,
                        Pessoa::getNome
                );

        nomes.forEach(System.out::println);

        System.out.println("\nGERENTES");

        List<Gerente> filtrados =
                ProcessadorGenerico.filtrar(
                        gerentes,
                        gerente ->
                                gerente.getSalario()
                                        .compareTo(
                                                new BigDecimal("11000.00")
                                        ) > 0
                );

        filtrados.forEach(System.out::println);
    }
}