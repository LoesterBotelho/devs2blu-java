package exercicios25072026parte1.contabil.initializer;


import exercicios25072026parte1.contabil.model.CentroCusto;
import exercicios25072026parte1.contabil.service.CentroCustoService;


public class CentroCustoInitializer {


    private final CentroCustoService service;



    public CentroCustoInitializer(
            CentroCustoService service) {

        this.service = service;

    }




    public void carregar() {


        if(!service.listar().isEmpty()) {

            return;

        }



        CentroCusto administrativo =

                new CentroCusto(
                        null,
                        "10",
                        "Administrativo"
                );



        CentroCusto rh =

                new CentroCusto(
                        null,
                        "10.01",
                        "RH"
                );



        CentroCusto financeiro =

                new CentroCusto(
                        null,
                        "10.02",
                        "Financeiro"
                );




        administrativo.adicionarFilho(rh);

        administrativo.adicionarFilho(financeiro);



        administrativo.ordenarFilhos();




        service.cadastrar(administrativo);

        service.cadastrar(rh);

        service.cadastrar(financeiro);


    }


}