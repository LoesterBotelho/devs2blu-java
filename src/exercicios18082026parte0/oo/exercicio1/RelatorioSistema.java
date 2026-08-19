package exercicios18082026parte0.oo.exercicio1;

public class RelatorioSistema {
    private String titulo;

    public RelatorioSistema() {
        this.titulo = "Relatório Geral";
    }

    public RelatorioSistema(String titulo) {
        this.titulo = titulo;
    }

    public void gerar() {
        System.out.println("\n---------------------------------------------------------------------------");    	
        System.out.println(titulo);
        System.out.println("-----------------------------------------------------------------------------");  	
        System.out.println("Author : Loester Botelho                                                     ");
        System.out.println("---------------------------------------------------------------------------\n");        
    }
}
