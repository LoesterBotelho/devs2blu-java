package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.List;

public class SistemaLogistica {
	
    private final ClienteService clienteService = new ClienteService();
    private final RepositorioEncomendas repositorio = new RepositorioEncomendas();
    private final ValidadorEntrega validador = new ValidadorEntrega();
    private final EntregaService entregaService =
            new EntregaService(repositorio, validador);
    private final RelatorioLogistica relatorio = new RelatorioLogistica();

    public void executar() {
        Cliente cliente = new Cliente(
                "C001",
                "Ana Silva",
                "47999990000",
                "ana@email.com");

        clienteService.cadastrar(cliente);

        Endereco origem = new Endereco(
                "Rua das Flores", "100", "Blumenau", "SC", "89000-000");

        Endereco destino = new Endereco(
                "Rua Central", "250", "Blumenau", "SC", "89010-000");

        Pacote pacote = new Pacote(
                new BigDecimal("2.00"),
                new BigDecimal("20"),
                new BigDecimal("15"),
                new BigDecimal("10"));

        Encomenda encomenda = entregaService.criar(
                "E001",
                cliente,
                origem,
                destino,
                pacote,
                TipoServico.PADRAO,
                new BigDecimal("10"));

        System.out.println("Encomenda criada");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Frete: R$ " + encomenda.getValorFrete());
        System.out.println("Status: " + encomenda.getStatus());

        entregaService.atualizarStatus(
                encomenda.getId(), StatusEntrega.AGUARDANDO_COLETA);

        entregaService.atualizarStatus(
                encomenda.getId(), StatusEntrega.EM_TRANSITO);

        entregaService.atualizarStatus(
                encomenda.getId(), StatusEntrega.SAIU_PARA_ENTREGA);

        entregaService.atualizarStatus(
                encomenda.getId(), StatusEntrega.ENTREGUE);

        System.out.println();
        System.out.println("Histórico de rastreamento");

        entregaService.rastrear(encomenda.getId())
                .forEach(item -> System.out.println(
                        item.dataHora() + " | "
                                + item.status() + " | "
                                + item.descricao()));

        List<Encomenda> encomendas = entregaService.listarTodas();

        System.out.println();
        System.out.println("Relatório de encomendas");
        relatorio.imprimir(encomendas);

        System.out.println();
        System.out.println("Total de clientes: " + clienteService.contar());
        System.out.println("Total de encomendas: " + encomendas.size());
        System.out.println(
                "Encomendas entregues: "
                        + relatorio.contarPorStatus(
                                encomendas, StatusEntrega.ENTREGUE));
        System.out.println(
                "Faturamento dos fretes entregues: R$ "
                        + relatorio.calcularFaturamento(encomendas));
    }

    public ClienteService getClienteService() {
        return clienteService;
    }

    public EntregaService getEntregaService() {
        return entregaService;
    }

    public RelatorioLogistica getRelatorio() {
        return relatorio;
    }
    
}