package exercicios28082026parte0.oo.exercicio1;

public class CsvExportador implements ExportadorRelatorio {
    @Override
    public void exportar(String titulo, String conteudo) {
        System.out.println("[CSV] Delimitando dados por vírgula (,)");
        System.out.println("[CSV] Gerando planilha: " + titulo + ".csv");
        System.out.println("[CSV] Dados tabulares gravados: " + conteudo + "\n");
    }
}