package exercicios11102026parte0.oo.exercicio1;

public class MainTeste {

    public static void main(String[] args) {

    	CentralMissoes<Missao> central = new CentralMissoes<>();

        central.adicionar(new MissaoExploracao(
                "Expedicao Marte", 180, "Marte"));

        central.adicionar(new MissaoPesquisa(
                "Projeto Europa", 90, "Astrobiologia"));

        central.adicionar(new MissaoExploracao(
                "Expedicao Lua", 30, "Lua"));

        System.out.println("TODAS AS MISSOES");
        central.listar().forEach(System.out::println);

        System.out.println("\nMISSOES DE ATE 90 DIAS");
        central.buscarPorDuracao(90)
                .forEach(System.out::println);

        System.out.println("\nEXECUCAO");
        central.executarMissoes();

        System.out.println("\nQuantidade: " + central.quantidade());
    }
    
}