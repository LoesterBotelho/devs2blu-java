package exercicios20082026parte0.oo.exercicio002.outros;

public interface ConfiguracoesSistema {

    String NOME_SISTEMA = "Sistema de Vendas";
    String VERSAO = "1.0";

    int IDADE_MINIMA = 18;
    int TAMANHO_MAXIMO_NOME = 100;

    double TAXA_JUROS = 0.05;
    double DESCONTO_PADRAO = 0.10;

    boolean AMBIENTE_PRODUCAO = false;

    void exibirConfiguracoes();
}