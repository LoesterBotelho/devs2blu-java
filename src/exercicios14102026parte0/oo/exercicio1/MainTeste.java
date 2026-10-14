package exercicios14102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MainTeste {

    public static void main(String[] args) {

    	HospitalService hospital = new HospitalService();

        Paciente paciente1 = new Paciente(
                "Ana Silva", "11111111111", 28, "P001");

        Paciente paciente2 = new Paciente(
                "Carlos Souza", "22222222222", 45, "P002");

        Medico medico1 = new Medico(
                "Mariana Costa", "33333333333", 42,
                "CRM001", Especialidade.CARDIOLOGIA,
                new BigDecimal("350.00"));

        Medico medico2 = new Medico(
                "Paulo Mendes", "44444444444", 38,
                "CRM002", Especialidade.ORTOPEDIA,
                new BigDecimal("280.00"));

        hospital.cadastrarPaciente(paciente1);
        hospital.cadastrarPaciente(paciente2);
        hospital.cadastrarMedico(medico1);
        hospital.cadastrarMedico(medico2);

        Consulta consulta1 = hospital.agendarConsulta(
                1, "P001", "CRM001",
                LocalDateTime.of(2026, 11, 10, 9, 0));

        Consulta consulta2 = hospital.agendarConsulta(
                2, "P002", "CRM002",
                LocalDateTime.of(2026, 11, 10, 10, 30));

        consulta1.confirmar();
        consulta1.concluir();
        consulta2.confirmar();

        System.out.println(" PACIENTES ");
        hospital.listarPacientes().forEach(System.out::println);

        System.out.println("\n MEDICOS ");
        hospital.listarMedicos().forEach(System.out::println);

        System.out.println("\n CONSULTAS ");
        hospital.listarConsultas().forEach(System.out::println);

        System.out.println("\n CONSULTAS CONFIRMADAS ");
        hospital.listarConsultasPorStatus(StatusConsulta.CONFIRMADA)
                .forEach(System.out::println);

        System.out.println("\n CARDIOLOGISTAS ");
        hospital.listarMedicosPorEspecialidade(Especialidade.CARDIOLOGIA)
                .forEach(System.out::println);

        System.out.println("\n HISTORICO DO PACIENTE ");
        hospital.buscarPaciente("P001")
                .ifPresent(p -> p.getHistorico().forEach(System.out::println));

        System.out.println("\n RESUMO ");
        System.out.println("Pacientes: " + hospital.quantidadePacientes());
        System.out.println("Medicos: " + hospital.quantidadeMedicos());
        System.out.println("Consultas: " + hospital.quantidadeConsultas());
    }
    
}