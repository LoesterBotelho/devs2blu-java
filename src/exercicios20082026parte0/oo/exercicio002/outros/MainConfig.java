package exercicios20082026parte0.oo.exercicio002.outros;

public class MainConfig {

	    public static void main(String[] args) {

	    	SistemaVendas sistema = new SistemaVendas();

	        sistema.exibirConfiguracoes();

	        System.out.println();
	        System.out.println("Acessando constantes pela interface:");

	        System.out.println(ConfiguracoesSistema.NOME_SISTEMA);
	        System.out.println(ConfiguracoesSistema.VERSAO);
	        System.out.println(ConfiguracoesSistema.IDADE_MINIMA);
	        System.out.println(ConfiguracoesSistema.TAXA_JUROS);
	    }
	}