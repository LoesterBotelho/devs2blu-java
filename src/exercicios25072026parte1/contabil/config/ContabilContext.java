package exercicios25072026parte1.contabil.config;

import exercicios25072026parte1.contabil.initializer.CentroCustoInitializer;
import exercicios25072026parte1.contabil.initializer.ContabilInitializer;
import exercicios25072026parte1.contabil.repository.CentroCustoRepository;
import exercicios25072026parte1.contabil.repository.LancamentoRepository;
import exercicios25072026parte1.contabil.repository.PlanoContaRepository;
import exercicios25072026parte1.contabil.service.BalanceteService;
import exercicios25072026parte1.contabil.service.CentroCustoAnaliseService;
import exercicios25072026parte1.contabil.service.CentroCustoService;
import exercicios25072026parte1.contabil.service.LancamentoContabilService;
import exercicios25072026parte1.contabil.service.LivroDiarioService;
import exercicios25072026parte1.contabil.service.LivroRazaoService;
import exercicios25072026parte1.contabil.service.PlanoContaService;
import exercicios25072026parte1.contabil.initializer.LancamentoDataInitializer;

public class ContabilContext {

    /*
     * ======================================
     * REPOSITÓRIOS
     * ======================================
     */

    private final PlanoContaRepository planoContaRepository;

    private final LancamentoRepository lancamentoRepository;

    private final CentroCustoRepository centroCustoRepository;

    /*
     * ======================================
     * SERVICES
     * ======================================
     */

    private final PlanoContaService planoContaService;

    private final LancamentoContabilService lancamentoService;

    private final CentroCustoService centroCustoService;

    private final CentroCustoAnaliseService centroCustoAnaliseService;
    
    private final LivroDiarioService livroDiarioService;

    private final LivroRazaoService livroRazaoService;

    private final BalanceteService balanceteService;

      
    public ContabilContext() {

        /*
         * Repositórios
         */

        this.planoContaRepository = new PlanoContaRepository();

        this.lancamentoRepository = new LancamentoRepository();

        this.centroCustoRepository = new CentroCustoRepository();

        /*
         * Serviços
         */

        this.planoContaService =
                new PlanoContaService(planoContaRepository);

        this.lancamentoService =
                new LancamentoContabilService(
                        lancamentoRepository,
                        planoContaRepository
                );

        this.centroCustoService =
                new CentroCustoService(centroCustoRepository);

        this.centroCustoAnaliseService =
                new CentroCustoAnaliseService(
                        lancamentoService
                );
        
        this.livroDiarioService =
                new LivroDiarioService(lancamentoService);

        this.livroRazaoService =
                new LivroRazaoService(lancamentoService);

        this.balanceteService =
                new BalanceteService(lancamentoService);

        /*
         * Carga inicial
         */

        inicializar();

    }

    private void inicializar() {
        inicializarPlanoContas();
        inicializarCentroCustos();
        inicializarLancamentos();        
    }

    private void inicializarPlanoContas() {

        new ContabilInitializer(
                planoContaService
        ).carregar();

    }

    private void inicializarCentroCustos() {

        new CentroCustoInitializer(
                centroCustoService
        ).carregar();

    }
    
    private void inicializarLancamentos() {


        new LancamentoDataInitializer(
                lancamentoService,
                planoContaService,
                centroCustoService
        ).carregar();


    }
    
    /*
     * ======================================
     * GETTERS
     * ======================================
     */

    public PlanoContaRepository getPlanoContaRepository() {
        return planoContaRepository;
    }

    public LancamentoRepository getLancamentoRepository() {
        return lancamentoRepository;
    }

    public CentroCustoRepository getCentroCustoRepository() {
        return centroCustoRepository;
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

    public CentroCustoAnaliseService getCentroCustoAnaliseService() {

        return centroCustoAnaliseService;

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

}