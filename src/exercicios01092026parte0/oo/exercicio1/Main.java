package exercicios01092026parte0.oo.exercicio1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		

		Map<Integer, List<Double>> registroNotas = new HashMap<>();

		// Adicionando dados (Autoboxing converte literais para os wrappers Integer e  Double)
		
		registroNotas.put(101, List.of(8.5, 7.0, 9.0));
		registroNotas.put(102, List.of(5.0, 6.5, 5.5));
		registroNotas.put(103, List.of(9.5, 10.0, 9.0));

		// Set para armazenar os IDs dos alunos que entregaram as avaliações
		Set<Integer> alunosEntregues = new HashSet<>(registroNotas.keySet());
		Set<Integer> alunosAprovados = new HashSet<>();

		// Processando as notas utilizando Generics
		for (Map.Entry<Integer, List<Double>> entry : registroNotas.entrySet()) {
			
			Integer idAluno = entry.getKey();      // Wrapper Integer
			
			List<Double> notas = entry.getValue(); // Collection com Wrapper Double
			
			try {
				
				ProcessadorAcademico<Double> processador = new ProcessadorAcademico<>(notas);
				
				double media = processador.calcularMedia();

				System.out.printf("Aluno ID %d -> Média: %.2f\n", idAluno, media);

				// Requisito 1: Filtrar alunos com média >= 7.0
				if (media >= 7.0) {
					alunosAprovados.add(idAluno);
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Erro ao processar o aluno " + idAluno + ": " + e.getMessage());
			}
		}

		System.out.println("\nIDs dos alunos aprovados (Média >= 7.0): " + alunosAprovados);
	}
}