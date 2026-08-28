package exercicios28082026parte0.oo.exercicio1;

public class RelatorioService {
    // Inversão de dependência: a classe depende da abstração
    private final ExportadorRelatorio exportador;

    // Injeção de dependência via construtor
    public RelatorioService(ExportadorRelatorio exportador) {
        this.exportador = exportador;
    }

    public void gerarRelatorioFinanceiro(double faturamentoTotal, double despesas) {
        System.out.println("Processando cálculos do balanço financeiro...");
        double lucroLiquido = faturamentoTotal - despesas;
        
        String titulo = "Relatorio_Financeiro_2026";
        String conteudo = "Faturamento: R$ " + faturamentoTotal + " | Despesas: R$ " + despesas + " | Lucro: R$ " + lucroLiquido;

        // Delega a exportação para o formato injetado
        exportador.exportar(titulo, conteudo);
    }
}