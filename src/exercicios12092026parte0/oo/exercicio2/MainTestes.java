package exercicios12092026parte0.oo.exercicio2;

import java.util.List;

public class MainTestes {

    public static void main(String[] args) {
    	
        List<Aluno> alunos = List.of(
                new Aluno(1L,"Ana", 8.5),
                new Aluno(2L,"Carlos", 9.7),
                new Aluno(3L,"Beatriz", 7.2),
                new Aluno(4L,"João", 6.8),
                new Aluno(5L,"Maria", 9.1)
        );

        RankingEmMemoria<Aluno> rankingAlunos = new RankingEmMemoria<>();

        System.out.println("ALUNOS ORDENADOS");

        rankingAlunos.ordenarPorPontuacao(alunos)
                .forEach(aluno ->
                        System.out.println(
                                aluno.nome() +"-"+ aluno.nota()
                        )
                );

        System.out.println("\nMAIOR PONTUAÇÃO");

        rankingAlunos.maiorPontuacao(alunos)
                .ifPresent(aluno ->
                        System.out.println(
                                aluno.nome() +"-"+ aluno.nota()
                        )
                );

        System.out.println("\nALUNOS COM NOTA >= 7.0");

        rankingAlunos.filtrar(
                        alunos,
                        aluno -> aluno.nota() >= 7.0
                )
                .forEach(aluno ->
                        System.out.println(
                                aluno.nome() +"-"+ aluno.nota()
                        )
                );

        System.out.println("\nALUNOS COM NOTA >= 9.0");

        rankingAlunos.filtrar(
                        alunos,
                        aluno -> aluno.nota() >= 9.0
                )
                .forEach(aluno ->
                        System.out.println(
                                aluno.nome() +"-"+ aluno.nota()
                        )
                );

        List<Jogo> jogos = List.of(
                new Jogo("J01","Minecraft", 95.0),
                new Jogo("J02","Stardew Valley", 91.0),
                new Jogo("J03","Terraria", 88.0),
                new Jogo("J04","Factorio", 97.0)
        );

        RankingEmMemoria<Jogo> rankingJogos = new RankingEmMemoria<>();

        System.out.println("\nJOGOS ORDENADOS");

        rankingJogos.ordenarPorPontuacao(jogos)
                .forEach(jogo ->
                        System.out.println(
                                jogo.nome() +"-"+ jogo.pontuacao()
                        )
                );
    }

}