package exercicios25072026parte1.contabil.test;


import exercicios25072026parte1.contabil.initializer.ContabilInitializer;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;
import exercicios25072026parte1.contabil.service.PlanoContaService;



public class ContabilInitializerTest {


    public static void main(String[] args) {


        PlanoContaRepository repository =
                new PlanoContaRepository();



        PlanoContaService service =
                new PlanoContaService(repository);



        ContabilInitializer initializer =
                new ContabilInitializer(service);



        initializer.carregar();



        service.listar()

                .forEach(conta -> {

                    conta.imprimir("");

                    System.out.println();

                });


    }


}