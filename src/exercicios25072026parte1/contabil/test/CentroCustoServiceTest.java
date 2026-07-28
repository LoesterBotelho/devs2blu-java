package exercicios25072026parte1.contabil.test;


import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.repository.CentroCustoRepository;
import exercicios25072026parte1.contabil.service.CentroCustoService;



public class CentroCustoServiceTest {


    public static void main(String[] args) {



        CentroCustoRepository repository =

                new CentroCustoRepository();





        CentroCustoService service =

                new CentroCustoService(repository);






        CentroCusto administrativo =

                new CentroCusto(

                        1,
                        "10",
                        "Administrativo"

                );






        CentroCusto rh =

                new CentroCusto(

                        2,
                        "10.01",
                        "Recursos Humanos"

                );






        CentroCusto financeiro =

                new CentroCusto(

                        3,
                        "10.02",
                        "Financeiro"

                );








        service.cadastrar(administrativo);


        service.cadastrar(rh);


        service.cadastrar(financeiro);







        System.out.println(
                "================================="
        );


        System.out.println(
                "      CENTRO DE CUSTO"
        );


        System.out.println(
                "================================="
        );






        service.listar()

                .forEach(

                        System.out::println

                );






        System.out.println();


        System.out.println(

                "Quantidade cadastrada: "

                + repository.quantidade()

        );






        System.out.println();


        System.out.println(

                "Buscar ID 1: "

                +

                service.buscar(1)

                        .orElseThrow()

        );



    }


}