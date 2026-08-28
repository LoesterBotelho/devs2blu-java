package exercicios28082026parte0.oo.exercicio1;

public class MainRelatorio {
    public static void main(String[] args) {
    
    	double faturamento = 354_213.75;
        double despesas = 118_348.21;


        System.out.println("--- Cenário 1: Exportação em PDF ---");
        ExportadorRelatorio pdfExp = new PdfExportador();
        RelatorioService servicoPdf = new RelatorioService(pdfExp);
        servicoPdf.gerarRelatorioFinanceiro(faturamento, despesas);


        System.out.println("--- Cenário 2: Exportação em CSV ---");
        ExportadorRelatorio csvExp = new CsvExportador();
        RelatorioService servicoCsv = new RelatorioService(csvExp);
        servicoCsv.gerarRelatorioFinanceiro(faturamento, despesas);
    }
    
}