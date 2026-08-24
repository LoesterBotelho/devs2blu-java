package exercicios24082026parte0.oo.exercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exercicios24082026parte0.oo.Pitch;

public class Main {
	public static void main(String[] args) {

        System.out.println("PITCH & MARATONA DEV");


        
        LocalDate inicio = LocalDate.now();
        LocalDate fim = inicio.plusDays(4);
        
        DesafioTech desafio = new DesafioTech("Maratona de Inovação Cloud 2026", inicio, fim);


        Equipe equipeAlpha = new Equipe("Alpha Code Senior");


        equipeAlpha.adicionarMembro(new MembroEquipe("Loester Botelho", "loester.developer@gmail.com", "Tech Lead"));
        equipeAlpha.adicionarMembro(new MembroEquipe("Bruno Souza", "bruno@email.com", "Backend Java"));
        equipeAlpha.adicionarMembro(new MembroEquipe("Carla Dias", "carla@email.com", "Frontend Angular"));
        equipeAlpha.adicionarMembro(new MembroEquipe("Daniel Lima", "daniel@email.com", "Cloud GCP"));
        equipeAlpha.adicionarMembro(new MembroEquipe("Elisa Rocha", "elisa@email.com", "UX/UI Designer"));
        equipeAlpha.adicionarMembro(new MembroEquipe("Felipe Costa", "felipe@email.com", "QA Engineer"));
        equipeAlpha.adicionarMembro(new MembroEquipe("Gabriela Martins", "gabriela@email.com", "DevOps"));
        equipeAlpha.adicionarMembro(new MembroEquipe("Henrique Alves", "henrique@email.com", "Pitcher / Negócios"));


        equipeAlpha.setRepositorioGit("https://github.com/exemplo/alpha-code-projeto");
        equipeAlpha.setUrlDeployGcp("https://alpha-backend-run-xyz.a.run.app");


        desafio.registrarEquipe(equipeAlpha);

        
        
        

        List<Avaliador> banca = new ArrayList<>();
        banca.add(new Avaliador("Dr. Roberto Mendes", "roberto@banca.com", "Arquitetura de Software"));
        banca.add(new Avaliador("Juliana Castro", "juliana@banca.com", "Modelo de Negócios & Pitch"));
        banca.add(new Avaliador("Marcos Vinicius", "marcos@banca.com", "Cloud & DevOps"));
        banca.add(new Avaliador("Beatriz Lima", "beatriz@banca.com", "Inovação e Experiência do Usuário"));

        Pitch pitchAlpha = new Pitch(
            "Falta de automação na gestão de resíduos urbanos locais.",
            "Plataforma inteligente integrada ao GCP para otimizar rotas de coleta.",
            true // Apresentado em inglês
        );

        pitchAlpha.setNotaProblema(9.5);
        pitchAlpha.setNotaSolucao(9.0);
        pitchAlpha.setNotaApresentacao(9.8);

        
        
        System.out.println("\n--- DETALHES DA EQUIPE ---");
        System.out.println(equipeAlpha);
        System.out.println("Repositório: " + equipeAlpha.getRepositorioGit());
        System.out.println("Deploy GCP: " + equipeAlpha.getUrlDeployGcp());
        
        
        System.out.println("\nIntegrantes:");
        for (MembroEquipe membro : equipeAlpha.getMembros()) {
            System.out.println(" - " + membro.getNome() + " (" + membro.getPapelNoProjeto() + ")");
        }

        System.out.println("\n--- AVALIAÇÃO DO PITCH (SÁBADO) ---");
        System.out.println("Problema: " + pitchAlpha.getProblema());
        System.out.println("Solução: " + pitchAlpha.getSolucao());
        System.out.println("Apresentado em Inglês? " + (pitchAlpha.isApresentadoEmIngles() ? "Sim (Bônus aplicado)" : "Não"));
        System.out.println("Pontuação Final Calculada (Polimorfismo/Interface): " + String.format("%.2f", pitchAlpha.calcularPontuacaoFinal()));
    }
}