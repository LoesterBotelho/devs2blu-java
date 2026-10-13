package exercicios13102026parte0.oo.exercicio1;

public class MainTeste {

    public static void main(String[] args) {

    	Campeonato<Equipe> campeonato =
                new Campeonato<>("Java E-sports Cup");

        Equipe equipe1 = new Equipe("Dragons");
        
        equipe1.adicionarJogador(
                new Jogador("Carlos", "Shadow", "Valorant"));
        
        equipe1.adicionarJogador(
                new Jogador("Ana", "Phoenix", "Valorant"));

        Equipe equipe2 = new Equipe("Titans");
        
        equipe2.adicionarJogador(
                new Jogador("Pedro", "Blaze", "Counter-Strike"));

        Equipe equipe3 = new Equipe("Wolves");
        
        equipe3.adicionarJogador(
                new Jogador("Maria", "Storm", "League of Legends"));

        equipe1.registrarVitoria();
        equipe1.registrarVitoria();
        
        equipe2.registrarVitoria();
        equipe2.registrarEmpate();
        
        equipe3.registrarVitoria();

        campeonato.inscrever(equipe1);
        campeonato.inscrever(equipe2);
        campeonato.inscrever(equipe3);

        System.out.println(" " + campeonato.getNome() + " ");

        campeonato.listarClassificacao()
                .forEach(System.out::println);

        System.out.println("\n LIDER ");

        campeonato.getLider()
                .ifPresent(System.out::println);

        System.out.println("\n BUSCAR EQUIPE ");

        campeonato.buscarPorNome("Titans")
                .ifPresent(equipe -> {
                    System.out.println(equipe);
                    equipe.getJogadores().forEach(System.out::println);
                });

        System.out.println("\nParticipantes: "
                + campeonato.quantidadeParticipantes());
    }
    
}