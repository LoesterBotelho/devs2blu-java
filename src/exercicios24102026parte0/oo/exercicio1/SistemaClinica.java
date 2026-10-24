package exercicios24102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class SistemaClinica {
	
    private final RepositorioAnimais repositorioAnimais = new RepositorioAnimais();
    private final AnimalService animalService = new AnimalService(repositorioAnimais);
    private final ConsultaService consultaService = new ConsultaService();
    private final VeterinarioService veterinarioService = new VeterinarioService();
    private final RelatorioClinica relatorio = new RelatorioClinica();

    public void executar() {
        Tutor tutor1 = new Tutor(1L, "Mariana Costa", "47999990001");
        Tutor tutor2 = new Tutor(2L, "Rafael Souza", "47999990002");

        Animal cachorro = new Cachorro(
                101L, "Thor", LocalDate.of(2021, 3, 12), tutor1);
        Animal gato = new Gato(
                102L, "Mimi", LocalDate.of(2023, 6, 5), tutor2);
        Animal ave = new Ave(
                103L, "Loro", LocalDate.of(2020, 1, 10), tutor1);

        animalService.cadastrar(cachorro);
        animalService.cadastrar(gato);
        animalService.cadastrar(ave);

        Veterinario veterinario1 = new Veterinario(
                201L, "Ana Martins", "47988880001",
                Especialidade.CLINICA_GERAL, "CRMV-SC-1234");

        Veterinario veterinario2 = new Veterinario(
                202L, "Paulo Mendes", "47988880002",
                Especialidade.CIRURGIA, "CRMV-SC-5678");

        veterinarioService.cadastrar(veterinario1);
        veterinarioService.cadastrar(veterinario2);

        Consulta consulta1 = consultaService.agendar(
                301L, cachorro, veterinario1,
                LocalDateTime.now().plusDays(1), new BigDecimal("180.00"));

        Consulta consulta2 = consultaService.agendar(
                302L, gato, veterinario2,
                LocalDateTime.now().plusDays(2), new BigDecimal("250.00"));

        consulta1.iniciar();
        consulta1.getProntuario().registrar("Avaliação clínica de rotina");
        consulta1.concluir();
        
        consulta2.iniciar();
        consulta2.getProntuario().registrar("Avaliação clínica de rotina");
        consulta2.concluir();        

        System.out.println("Sistema de Clínica Veterinária");
        System.out.println("Animais cadastrados: " + repositorioAnimais.listarTodos().size());
        System.out.println("Veterinários cadastrados: " + veterinarioService.listarTodos().size());
        System.out.println("Consultas cadastradas: " + consultaService.listarTodas().size());
        
        System.out.println("Consultas concluídas: "
                + relatorio.contarPorStatus(
                        consultaService.listarTodas(), StatusConsulta.CONCLUIDA));
        
        System.out.println("Consultas agendadas: "
                + consultaService.listarAgendadas().size());

        System.out.println("Faturamento concluído: R$"
                + relatorio.faturamentoConcluido(consultaService.listarTodas()));

        System.out.println("\nAnimais da espécie cachorro:");
        animalService.listarPorEspecie(Especie.CACHORRO)
                .forEach(animal -> System.out.println(
                        animal.getNome() + " | Tutor: "
                                + animal.getTutor().getNome()
                                + " | Idade: " + animal.getIdade()));

        System.out.println("\nAnimais com nome iniciado por M:");
        animalService.pesquisar(
                animal -> animal.getNome().startsWith("M"))
                .forEach(animal -> System.out.println(animal.getNome()));

        System.out.println("\nConsultas por veterinário:");
        relatorio.consultasPorVeterinario(consultaService.listarTodas())
                .forEach((nome, quantidade) ->
                        System.out.println(nome + ": " + quantidade));

        System.out.println("\nStatus das consultas:");
        consultaService.listarTodas().forEach(consulta ->
                System.out.println(
                        consulta.getAnimal().getNome()
                                + " | " + consulta.getVeterinario().getNome()
                                + " | " + consulta.getStatus()));

        System.out.println("\nAnimais cadastrados por tutor:");
        List.of(tutor1, tutor2).forEach(tutor ->
                System.out.println(
                        tutor.getNome() + ": "
                                + tutor.getAnimais().stream()
                                        .map(Animal::getNome)
                                        .collect(java.util.stream.Collectors.joining(", "))));

        System.out.println("\nEspecialistas em cirurgia:");
        veterinarioService.listarPorEspecialidade(Especialidade.CIRURGIA)
                .forEach(veterinario -> System.out.println(veterinario.getNome()));

        System.out.println("\nSom dos animais:");
        repositorioAnimais.listarTodos().forEach(animal ->
                System.out.println(animal.getNome() + ": " + animal.emitirSom()));
    }
}