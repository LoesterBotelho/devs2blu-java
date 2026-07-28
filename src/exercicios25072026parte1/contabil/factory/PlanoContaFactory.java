package exercicios25072026parte1.contabil.factory;


import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.enums.TipoConta;
import exercicios25072026parte1.contabil.model.PlanoConta;


public class PlanoContaFactory {


    private static int sequencia = 1;



    public static PlanoConta criarSintetica(
            String codigo,
            String descricao,
            NaturezaConta natureza,
            Integer nivel) {


        int id = sequencia++;


        return new PlanoConta(

                id,              // ID da entidade
                id,              // código interno

                codigo,
                descricao,

                natureza,

                TipoConta.SINTETICA,

                nivel,

                false

        );


    }





    public static PlanoConta criarAnalitica(
            String codigo,
            String descricao,
            NaturezaConta natureza,
            Integer nivel) {


        int id = sequencia++;


        return new PlanoConta(

                id,              // ID da entidade
                id,              // código interno

                codigo,
                descricao,

                natureza,

                TipoConta.ANALITICA,

                nivel,

                true

        );


    }


}