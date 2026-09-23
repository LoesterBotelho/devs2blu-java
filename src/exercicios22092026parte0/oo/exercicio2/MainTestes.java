package exercicios22092026parte0.oo.exercicio2;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainTestes {

    public static void main(String[] args) {

    	// -----------------------------------------------------------------------------------------------------
    	
        Repositorio<Funcionario> repositorio = new Repositorio<>();

        // -----------------------------------------------------------------------------------------------------
        
        repositorio.adicionar(
                new Funcionario("João", "Desenvolvedor", 6500.00)
        );

        repositorio.adicionar(
                new Funcionario("Maria", "Analista", 5200.00)
        );

        repositorio.adicionar(
                new Funcionario("Carlos", "Desenvolvedor", 7500.00)
        );

        repositorio.adicionar(
                new Funcionario("Ana", "Gerente", 9500.00)
        );

        repositorio.adicionar(
                new Funcionario("Pedro", "Analista", 4800.00)
        );

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n1. TODOS OS FUNCIONÁRIOS");

        repositorio.listarTodos()
                .forEach(System.out::println);

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n2. FUNCIONÁRIOS COM SALÁRIO ACIMA DE R$ 6.000");

        List<Funcionario> salarioAlto = repositorio.filtrar(
                funcionario -> funcionario.getSalario() > 6000
        );

        salarioAlto.forEach(System.out::println);

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n3. DESENVOLVEDORES");

        List<Funcionario> desenvolvedores = repositorio.filtrar(
                funcionario -> funcionario.getCargo().equals("Desenvolvedor")
        );

        desenvolvedores.forEach(System.out::println);

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n4. ORDENANDO POR SALÁRIO");

        List<Funcionario> funcionarios = repositorio.listarTodos();

        funcionarios.sort(
                (f1, f2) -> Double.compare(
                        f1.getSalario(),
                        f2.getSalario()
                )
        );
        
        funcionarios.forEach(System.out::println);

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n5. NOMES DOS FUNCIONÁRIOS");

        funcionarios.stream()
                .map(Funcionario::getNome)
                .forEach(System.out::println);

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n6. CARGOS ÚNICOS");

        Set<String> cargos = funcionarios.stream()
                .map(Funcionario::getCargo)
                .collect(Collectors.toSet());

        cargos.forEach(System.out::println);

        // -----------------------------------------------------------------------------------------------------
        
        System.out.println("\n7. FUNCIONÁRIOS AGRUPADOS POR CARGO");

        Map<String, List<Funcionario>> funcionariosPorCargo =
                funcionarios.stream()
                        .collect(
                                Collectors.groupingBy(
                                        Funcionario::getCargo
                                )
                        );

        funcionariosPorCargo.forEach(
                (cargo, lista) -> {
                    System.out.println("\nCargo: " + cargo);

                    lista.forEach(
                            funcionario -> System.out.println(
                                    "  " + funcionario
                            )
                    );
                }
        );
        
     // -----------------------------------------------------------------------------------------------------
        
    }
}