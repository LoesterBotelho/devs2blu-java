package exercicios25072026parte1.contabil.config;


import java.util.List;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.enums.TipoConta;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.service.PlanoContaService;



public class ContabilInitializer {


    private final PlanoContaService planoContaService;



    public ContabilInitializer(
            PlanoContaService planoContaService) {

        this.planoContaService = planoContaService;

    }







    public void carregar() {



        PlanoConta ativo = criarConta(
                1,
                "1",
                "Ativo",
                NaturezaConta.ATIVO,
                TipoConta.SINTETICA,
                1,
                false
        );



        PlanoConta ativoCirculante = criarConta(
                2,
                "1.1",
                "Ativo Circulante",
                NaturezaConta.ATIVO,
                TipoConta.SINTETICA,
                2,
                false
        );



        PlanoConta caixa = criarConta(
                3,
                "1.1.01",
                "Caixa",
                NaturezaConta.ATIVO,
                TipoConta.ANALITICA,
                3,
                true
        );



        PlanoConta banco = criarConta(
                4,
                "1.1.02",
                "Banco",
                NaturezaConta.ATIVO,
                TipoConta.ANALITICA,
                3,
                true
        );





        PlanoConta passivo = criarConta(
                5,
                "2",
                "Passivo",
                NaturezaConta.PASSIVO,
                TipoConta.SINTETICA,
                1,
                false
        );



        PlanoConta fornecedores = criarConta(
                6,
                "2.1",
                "Fornecedores",
                NaturezaConta.PASSIVO,
                TipoConta.ANALITICA,
                2,
                true
        );





        PlanoConta patrimonio = criarConta(
                7,
                "3",
                "Patrimônio Líquido",
                NaturezaConta.PATRIMONIO_LIQUIDO,
                TipoConta.SINTETICA,
                1,
                false
        );



        PlanoConta capital = criarConta(
                8,
                "3.1",
                "Capital Social",
                NaturezaConta.PATRIMONIO_LIQUIDO,
                TipoConta.ANALITICA,
                2,
                true
        );






        PlanoConta receita = criarConta(
                9,
                "4",
                "Receitas",
                NaturezaConta.RECEITA,
                TipoConta.SINTETICA,
                1,
                false
        );



        PlanoConta venda = criarConta(
                10,
                "4.1",
                "Venda de Produtos",
                NaturezaConta.RECEITA,
                TipoConta.ANALITICA,
                2,
                true
        );






        PlanoConta despesa = criarConta(
                11,
                "5",
                "Despesas",
                NaturezaConta.DESPESA,
                TipoConta.SINTETICA,
                1,
                false
        );



        PlanoConta salario = criarConta(
                12,
                "5.1",
                "Salários",
                NaturezaConta.DESPESA,
                TipoConta.ANALITICA,
                2,
                true
        );







        List<PlanoConta> contas = List.of(

                ativo,
                ativoCirculante,
                caixa,
                banco,

                passivo,
                fornecedores,

                patrimonio,
                capital,

                receita,
                venda,

                despesa,
                salario

        );





        contas.forEach(

                planoContaService::cadastrar

        );








        ativo.adicionarFilha(
                ativoCirculante
        );


        ativoCirculante.adicionarFilha(
                caixa
        );


        ativoCirculante.adicionarFilha(
                banco
        );



        passivo.adicionarFilha(
                fornecedores
        );



        patrimonio.adicionarFilha(
                capital
        );



        receita.adicionarFilha(
                venda
        );



        despesa.adicionarFilha(
                salario
        );



    }









    private PlanoConta criarConta(

            Integer id,

            String codigo,

            String descricao,

            NaturezaConta natureza,

            TipoConta tipoConta,

            Integer nivel,

            boolean aceitaLancamento

    ) {



        PlanoConta conta = new PlanoConta();



        conta.setId(id);

        conta.setCodigoInterno(id);

        conta.setCodigo(codigo);

        conta.setDescricao(descricao);

        conta.setNatureza(natureza);

        conta.setTipoConta(tipoConta);

        conta.setNivel(nivel);

        conta.setAceitaLancamento(aceitaLancamento);

        conta.setAtivo(true);



        return conta;

    }


}