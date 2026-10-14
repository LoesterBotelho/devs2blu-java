package exercicios14102026parte0.oo.exercicio1;

import java.time.LocalDateTime;

public class Consulta {
	
    private final int id;
    private final Paciente paciente;
    private final Medico medico;
    private final LocalDateTime dataHora;
    private StatusConsulta status;

    public Consulta(
            int id,
            Paciente paciente,
            Medico medico,
            LocalDateTime dataHora) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID invalido");
        }
        if (paciente == null || medico == null || dataHora == null) {
            throw new IllegalArgumentException("Dados obrigatorios");
        }

        this.id = id;
        this.paciente = paciente;
        this.medico = medico;
        this.dataHora = dataHora;
        this.status = StatusConsulta.AGENDADA;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void confirmar() {
        validarTransicao(StatusConsulta.AGENDADA);
        status = StatusConsulta.CONFIRMADA;
    }

    public void concluir() {
        validarTransicao(StatusConsulta.CONFIRMADA);
        status = StatusConsulta.CONCLUIDA;
        paciente.adicionarRegistro(
                "Consulta com " + medico.getNome()
                        + " em " + dataHora);
    }

    public void cancelar() {
        if (status == StatusConsulta.CONCLUIDA
                || status == StatusConsulta.CANCELADA) {
            throw new IllegalStateException(
                    "Consulta nao pode ser cancelada");
        }

        status = StatusConsulta.CANCELADA;
    }

    private void validarTransicao(StatusConsulta esperado) {
        if (status != esperado) {
            throw new IllegalStateException(
                    "Status atual invalido: " + status);
        }
    }

    @Override
    public String toString() {
        return "Consulta #" + id
                + " | Paciente: " + paciente.getNome()
                + " | Medico: " + medico.getNome()
                + " | Data: " + dataHora
                + " | Status: " + status;
    }
}