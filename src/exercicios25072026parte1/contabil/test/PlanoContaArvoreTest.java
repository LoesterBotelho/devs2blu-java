package exercicios25072026parte1.contabil.test;


import exercicios25072026parte1.contabil.config.ContabilContext;
import exercicios25072026parte1.contabil.service.PlanoContaService;



public class PlanoContaArvoreTest {


    public static void main(String[] args) {



        ContabilContext context =

                new ContabilContext();





        PlanoContaService service =

                context.getPlanoContaService();






        System.out.println(
                "================================="
        );


        System.out.println(
                "       ÁRVORE DO PLANO DE CONTAS"
        );


        System.out.println(
                "================================="
        );





        service.imprimirArvore();




    }


}