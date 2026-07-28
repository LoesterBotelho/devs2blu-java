package exercicios25072026parte1.contabil.test;


import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.repository.CentroCustoRepository;
import exercicios25072026parte1.contabil.service.CentroCustoService;



public class CentroCustoTest {



    public static void main(String[] args) {



        CentroCustoRepository repository =

                new CentroCustoRepository();





        CentroCustoService service =

                new CentroCustoService(repository);







        CentroCusto administrativo =

                new CentroCusto(

                        1,
                        "ADM",
                        "Administrativo"

                );






        CentroCusto comercial =

                new CentroCusto(

                        2,
                        "COM",
                        "Comercial"

                );






        CentroCusto tecnologia =

                new CentroCusto(

                        3,
                        "TI",
                        "Tecnologia"

                );







        service.cadastrar(administrativo);

        service.cadastrar(comercial);

        service.cadastrar(tecnologia);








        System.out.println(
                "================================"
        );


        System.out.println(
                "LISTA DE CENTROS DE CUSTO"
        );


        System.out.println(
                "================================"
        );




        service.listar()

                .forEach(System.out::println);








        System.out.println();




        System.out.println(
                "================================"
        );


        System.out.println(
                "BUSCA POR CÓDIGO"
        );


        System.out.println(
                "================================"
        );





        service.buscarPorCodigo("TI")

                .ifPresent(

                        centro ->

                        System.out.println(
                                centro
                        )

                );








        System.out.println();




        System.out.println(
                "================================"
        );


        System.out.println(
                "QUANTIDADE"
        );


        System.out.println(
                "================================"
        );




        System.out.println(

                service.quantidade()

        );








        System.out.println();




        System.out.println(
                "================================"
        );


        System.out.println(
                "REMOVER CENTRO COMERCIAL"
        );


        System.out.println(
                "================================"
        );





        service.remover(2);






        service.listar()

                .forEach(System.out::println);



    }


}