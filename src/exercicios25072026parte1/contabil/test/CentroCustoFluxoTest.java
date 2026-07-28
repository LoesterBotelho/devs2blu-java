package exercicios25072026parte1.contabil.test;


import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.service.CentroCustoAnaliseService;



public class CentroCustoFluxoTest {


    public static void main(String[] args) {


        ContabilContext context =
                new ContabilContext();



        CentroCustoAnaliseService service =

                context.getCentroCustoAnaliseService();



        System.out.println("==============================");
        System.out.println(" ANALISE CENTRO DE CUSTO");
        System.out.println("==============================");



        service.gerar()

                .forEach(System.out::println);



    }

}