package exercicios28082026parte0.oo.exercicio1;

public class PdfExportador implements ExportadorRelatorio {
    @Override
    public void exportar(String titulo, String conteudo) {
        System.out.println("[PDF] Formatando layout de página A4...");
        System.out.println("[PDF] Gerando arquivo: " + titulo + ".pdf");
        System.out.println("[PDF] Conteúdo gravado: " + conteudo + "\n");
    }
}