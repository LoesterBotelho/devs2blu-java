package exercicios25072026parte1.contabil.test;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.enums.TipoConta;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;


public class RepositoryTest {


    public static void main(String[] args) {


        PlanoContaRepository repository =
                new PlanoContaRepository();



        PlanoConta caixa =
            new PlanoConta(
                1,
                "1.1.01",
                "Caixa",
                NaturezaConta.ATIVO,
                TipoConta.ANALITICA,
                3,
                true
            );



        PlanoConta banco =
            new PlanoConta(
                2,
                "1.1.02",
                "Banco",
                NaturezaConta.ATIVO,
                TipoConta.ANALITICA,
                3,
                true
            );



        repository.salvar(caixa);

        repository.salvar(banco);



        repository.listar()

            .forEach(System.out::println);



        System.out.println();


        repository.buscar(1)

            .ifPresent(System.out::println);



    }

}