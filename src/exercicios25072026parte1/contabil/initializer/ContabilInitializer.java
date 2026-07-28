package exercicios25072026parte1.contabil.initializer;

import exercicios25072026parte1.contabil.enums.NaturezaConta;
import exercicios25072026parte1.contabil.factory.PlanoContaFactory;
import exercicios25072026parte1.contabil.model.PlanoConta;
import exercicios25072026parte1.contabil.service.PlanoContaService;

public class ContabilInitializer {

    private final PlanoContaService planoContaService;

    public ContabilInitializer(PlanoContaService planoContaService) {
        this.planoContaService = planoContaService;
    }

    public void carregar() {

        // Evita cadastrar novamente caso já exista carga
        if (!planoContaService.listar().isEmpty()) {
            return;
        }

        /*
         * ==========================
         * ATIVO
         * ==========================
         */

        PlanoConta ativo =
                PlanoContaFactory.criarSintetica(
                        "1",
                        "Ativo",
                        NaturezaConta.ATIVO,
                        1);

        PlanoConta ativoCirculante =
                PlanoContaFactory.criarSintetica(
                        "1.1",
                        "Ativo Circulante",
                        NaturezaConta.ATIVO,
                        2);

        PlanoConta caixa =
                PlanoContaFactory.criarAnalitica(
                        "1.1.01",
                        "Caixa",
                        NaturezaConta.ATIVO,
                        3);

        PlanoConta banco =
                PlanoContaFactory.criarAnalitica(
                        "1.1.02",
                        "Banco",
                        NaturezaConta.ATIVO,
                        3);

        /*
         * ==========================
         * PASSIVO
         * ==========================
         */

        PlanoConta passivo =
                PlanoContaFactory.criarSintetica(
                        "2",
                        "Passivo",
                        NaturezaConta.PASSIVO,
                        1);

        PlanoConta fornecedores =
                PlanoContaFactory.criarAnalitica(
                        "2.1.01",
                        "Fornecedores",
                        NaturezaConta.PASSIVO,
                        2);

        /*
         * ==========================
         * PATRIMÔNIO LÍQUIDO
         * ==========================
         */

        PlanoConta patrimonioLiquido =
                PlanoContaFactory.criarSintetica(
                        "3",
                        "Patrimônio Líquido",
                        NaturezaConta.PATRIMONIO_LIQUIDO,
                        1);

        PlanoConta capitalSocial =
                PlanoContaFactory.criarAnalitica(
                        "3.1.01",
                        "Capital Social",
                        NaturezaConta.PATRIMONIO_LIQUIDO,
                        2);

        /*
         * ==========================
         * RECEITAS
         * ==========================
         */

        PlanoConta receitas =
                PlanoContaFactory.criarSintetica(
                        "4",
                        "Receitas",
                        NaturezaConta.RECEITA,
                        1);

        PlanoConta vendaProdutos =
                PlanoContaFactory.criarAnalitica(
                        "4.1.01",
                        "Venda de Produtos",
                        NaturezaConta.RECEITA,
                        2);

        /*
         * ==========================
         * DESPESAS
         * ==========================
         */

        PlanoConta despesas =
                PlanoContaFactory.criarSintetica(
                        "5",
                        "Despesas",
                        NaturezaConta.DESPESA,
                        1);

        PlanoConta salarios =
                PlanoContaFactory.criarAnalitica(
                        "5.1.01",
                        "Salários",
                        NaturezaConta.DESPESA,
                        2);

        /*
         * ==========================
         * MONTA A ÁRVORE
         * ==========================
         */

        ativo.adicionarFilha(ativoCirculante);

        ativoCirculante.adicionarFilha(caixa);
        ativoCirculante.adicionarFilha(banco);

        passivo.adicionarFilha(fornecedores);

        patrimonioLiquido.adicionarFilha(capitalSocial);

        receitas.adicionarFilha(vendaProdutos);

        despesas.adicionarFilha(salarios);

        /*
         * ==========================
         * ORDENA A ÁRVORE
         * ==========================
         */

        ativo.ordenarFilhos();
        ativoCirculante.ordenarFilhos();

        passivo.ordenarFilhos();

        patrimonioLiquido.ordenarFilhos();

        receitas.ordenarFilhos();

        despesas.ordenarFilhos();

        /*
         * ==========================
         * PERSISTE
         * ==========================
         */

        cadastrar(
                ativo,
                ativoCirculante,
                caixa,
                banco,
                passivo,
                fornecedores,
                patrimonioLiquido,
                capitalSocial,
                receitas,
                vendaProdutos,
                despesas,
                salarios
        );
    }

    private void cadastrar(PlanoConta... contas) {

        for (PlanoConta conta : contas) {
            planoContaService.cadastrar(conta);
        }

    }

}