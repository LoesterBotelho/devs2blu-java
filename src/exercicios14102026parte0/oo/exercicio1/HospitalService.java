package exercicios14102026parte0.oo.exercicio1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class HospitalService {

	private final Repositorio<Paciente, String> pacientes =
            new Repositorio<>(Paciente::getNumeroProntuario);

    private final Repositorio<Medico, String> medicos =
            new Repositorio<>(Medico::getCrm);

    private final Repositorio<Consulta, Integer> consultas =
            new Repositorio<>(Consulta::getId);

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.adicionar(paciente);
    }

    public void cadastrarMedico(Medico medico) {
        medicos.adicionar(medico);
    }

    public Consulta agendarConsulta(
            int id,
            String prontuario,
            String crm,
            LocalDateTime dataHora) {

        Paciente paciente = pacientes.buscar(prontuario)
                .orElseThrow(() ->
                        new IllegalArgumentException("Paciente nao encontrado"));

        Medico medico = medicos.buscar(crm)
                .orElseThrow(() ->
                        new IllegalArgumentException("Medico nao encontrado"));

        boolean horarioOcupado = consultas.listar().stream()
                .filter(c -> c.getMedico().getCrm().equals(crm))
                .filter(c -> c.getStatus() != StatusConsulta.CANCELADA)
                .anyMatch(c -> c.getDataHora().equals(dataHora));

        if (horarioOcupado) {
            throw new IllegalStateException(
                    "Medico ja possui consulta nesse horario");
        }

        Consulta consulta = new Consulta(id, paciente, medico, dataHora);
        consultas.adicionar(consulta);

        return consulta;
    }

    public Optional<Paciente> buscarPaciente(String prontuario) {
        return pacientes.buscar(prontuario);
    }

    public Optional<Medico> buscarMedico(String crm) {
        return medicos.buscar(crm);
    }

    public Optional<Consulta> buscarConsulta(int id) {
        return consultas.buscar(id);
    }

    public List<Paciente> listarPacientes() {
        return pacientes.listar();
    }

    public List<Medico> listarMedicos() {
        return medicos.listar();
    }

    public List<Consulta> listarConsultas() {
        return consultas.listar();
    }

    public List<Consulta> listarConsultasPorStatus(StatusConsulta status) {
        return consultas.filtrar(c -> c.getStatus() == status);
    }

    public List<Medico> listarMedicosPorEspecialidade(
            Especialidade especialidade) {

        return medicos.filtrar(
                m -> m.getEspecialidade() == especialidade);
    }

    public int quantidadePacientes() {
        return pacientes.quantidade();
    }

    public int quantidadeMedicos() {
        return medicos.quantidade();
    }

    public int quantidadeConsultas() {
        return consultas.quantidade();
    }
    
}