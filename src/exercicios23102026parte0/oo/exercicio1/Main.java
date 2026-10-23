package exercicios23102026parte0.oo.exercicio1;

import java.util.Comparator;

class Main {

    void main() {
        Guerreiro guerreiro = new Guerreiro(1L, "Arthas");
        Mago mago = new Mago(2L, "Merlin");
        Arqueiro arqueiro = new Arqueiro(3L, "Legolas");

        RepositorioPersonagens repositorio =
                new RepositorioPersonagens();

        GerenciadorPersonagens gerenciador =
                new GerenciadorPersonagens(repositorio);

        gerenciador.adicionar(guerreiro);
        gerenciador.adicionar(mago);
        gerenciador.adicionar(arqueiro);

        System.out.println("PERSONAGENS DO RPG");
        gerenciador.listarTodos().forEach(System.out::println);

        System.out.println("\nPERSONAGENS DE NÍVEL 1");
        gerenciador.filtrar(
                personagem -> personagem.getNivel() == 1
        ).forEach(System.out::println);

        Arma espada = new Arma(
                101L, "Espada de Aço",
                Raridade.RARO, 100, 20
        );

        Pocao pocao = new Pocao(
                102L, "Poção de Cura",
                Raridade.COMUM, 25, 40
        );

        guerreiro.getInventario().adicionar(espada);
        guerreiro.getInventario().adicionar(pocao);
        guerreiro.getInventario().equiparArma(101L);

        System.out.println("\nINVENTÁRIO DO GUERREIRO");
        guerreiro.getInventario().listarTodos()
                .forEach(System.out::println);

        System.out.println("\nHABILIDADE ESPECIAL");
        Goblin goblin = new Goblin(201L, "Goblin das Cavernas");

        Habilidade golpeEspecial = (origem, alvo) -> {
            int dano = origem.getForca() + 12;
            alvo.receberDano(dano);

            System.out.printf(
                    "%s usou Golpe Especial contra %s: %d de dano.%n",
                    origem.getNome(), alvo.getNome(), dano
            );
        };

        guerreiro.executarHabilidade(golpeEspecial, goblin);

        System.out.println("\nBATALHA");
        ResultadoBatalha resultado =
                new Batalha().lutar(guerreiro, goblin);

        System.out.println("\nRESULTADO");
        System.out.println("Vencedor: " + resultado.vencedor());
        System.out.println("Rodadas: " + resultado.rodadas());
        System.out.println(
                "Vitória do jogador: " + resultado.vitoriaJogador()
        );

        if (resultado.vitoriaJogador()) {
            guerreiro.getInventario().usarPocao(102L, guerreiro);
        }

        Missao missao = new Missao(
                "Primeira Caçada",
                "Derrote um monstro e ganhe experiência.",
                50,
                personagem -> personagem.getExperiencia() >= 30
        );

        System.out.println("\nMISSÃO");
        missao.tentarConcluir(guerreiro);
        System.out.println(
                "Missão concluída: " + missao.isConcluida()
        );

        System.out.println("\nPERSONAGENS ORDENADOS POR NÍVEL");
        gerenciador.listarTodos().stream()
                .sorted(Comparator.comparingInt(
                        Personagem::getNivel
                ).reversed())
                .forEach(System.out::println);

        System.out.println("\nESTATÍSTICAS");
        EstatisticasRPG estatisticas =
                new EstatisticasRPG(gerenciador.listarTodos());

        System.out.println("Total: " + estatisticas.total());
        System.out.println("Vivos: " + estatisticas.vivos());
        System.out.println("Derrotados: " + estatisticas.derrotados());
        System.out.println(
                "Nível médio: " + estatisticas.nivelMedio()
        );

        System.out.println("\nPERSONAGENS POR CLASSE");
        estatisticas.contarPorClasse()
                .forEach((classe, quantidade) ->
                        System.out.println(
                                classe + ": " + quantidade
                        )
                );

        System.out.println("\nBUSCA POR ID");
        gerenciador.buscarPorId(1L).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Personagem não encontrado")
        );
    }
}