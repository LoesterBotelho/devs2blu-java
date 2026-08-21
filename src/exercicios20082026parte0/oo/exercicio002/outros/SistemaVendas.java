package exercicios20082026parte0.oo.exercicio002.outros;

public class SistemaVendas implements ConfiguracoesSistema {

    @Override
    public void exibirConfiguracoes() {
        System.out.println("Sistema: " + NOME_SISTEMA);
        System.out.println("Versão: " + VERSAO);
        System.out.println("Idade mínima: " + IDADE_MINIMA);
        System.out.println("Tamanho máximo nome: " + TAMANHO_MAXIMO_NOME);
        System.out.println("Taxa de juros: " + TAXA_JUROS);
        System.out.println("Desconto padrão: " + DESCONTO_PADRAO);
        System.out.println("Ambiente produção: " + AMBIENTE_PRODUCAO);
    }
}