package exercicios25072026parte1.contabil.config;


import exercicios25072026parte1.contabil.initializer.ContabilDataInitializer;
import exercicios25072026parte1.contabil.repository.CentroCustoRepository;
import exercicios25072026parte1.contabil.repository.LancamentoRepository;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;
import exercicios25072026parte1.contabil.service.BalanceteService;
import exercicios25072026parte1.contabil.service.CentroCustoService;
import exercicios25072026parte1.contabil.service.LancamentoContabilService;
import exercicios25072026parte1.contabil.service.LivroDiarioService;
import exercicios25072026parte1.contabil.service.LivroRazaoService;
import exercicios25072026parte1.contabil.service.PlanoContaService;



public class ContabilContext {


    private final PlanoContaRepository planoContaRepository;


    private final LancamentoRepository lancamentoRepository;


    private final CentroCustoRepository centroCustoRepository;



    private final PlanoContaService planoContaService;


    private final LancamentoContabilService lancamentoService;


    private final CentroCustoService centroCustoService;



    private final LivroDiarioService livroDiarioService;


    private final LivroRazaoService livroRazaoService;


    private final BalanceteService balanceteService;





    public ContabilContext() {


        planoContaRepository =
                new PlanoContaRepository();



        lancamentoRepository =
                new LancamentoRepository();



        centroCustoRepository =
                new CentroCustoRepository();





        planoContaService =

                new PlanoContaService(
                        planoContaRepository
                );





        lancamentoService =

                new LancamentoContabilService(
                        lancamentoRepository
                );





        centroCustoService =

                new CentroCustoService(
                        centroCustoRepository
                );





        livroDiarioService =

                new LivroDiarioService(
                        lancamentoService
                );





        livroRazaoService =

                new LivroRazaoService(
                        lancamentoService
                );





        balanceteService =

                new BalanceteService(
                        planoContaService
                );





        carregarDados();


    }







    private void carregarDados() {


        ContabilDataInitializer initializer =

                new ContabilDataInitializer(
                        planoContaRepository
                );


        initializer.carregar();


    }








    public PlanoContaService getPlanoContaService() {

        return planoContaService;

    }






    public LancamentoContabilService getLancamentoService() {

        return lancamentoService;

    }






    public CentroCustoService getCentroCustoService() {

        return centroCustoService;

    }






    public LivroDiarioService getLivroDiarioService() {

        return livroDiarioService;

    }






    public LivroRazaoService getLivroRazaoService() {

        return livroRazaoService;

    }






    public BalanceteService getBalanceteService() {

        return balanceteService;

    }






    public PlanoContaRepository getPlanoContaRepository() {

        return planoContaRepository;

    }






    public LancamentoRepository getLancamentoRepository() {

        return lancamentoRepository;

    }






    public CentroCustoRepository getCentroCustoRepository() {

        return centroCustoRepository;

    }


}