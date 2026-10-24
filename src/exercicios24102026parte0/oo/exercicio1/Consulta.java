package exercicios24102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Consulta implements Identificavel {

	private final Long id;
    private final Animal animal;
    private final Veterinario veterinario;
    private final LocalDateTime dataHora;
    private final BigDecimal valor;
    private final Prontuario prontuario = new Prontuario();
    private StatusConsulta status = StatusConsulta.AGENDADA;

    public Consulta(
            Long id,
            Animal animal,
            Veterinario veterinario,
            LocalDateTime dataHora,            
            BigDecimal valor) {
        if (id == null || id <= 0 || animal == null || veterinario == null
                || dataHora == null || valor == null || valor.signum() < 0) {
            throw new IllegalArgumentException("Dados da consulta inválidos");
        }

        this.id = id;
        this.animal = animal;
        this.veterinario = veterinario;
        this.dataHora = dataHora;
        this.valor = valor;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void iniciar() {
        alterarStatus(StatusConsulta.AGENDADA, StatusConsulta.EM_ANDAMENTO);
    }

    public void concluir() {
        alterarStatus(StatusConsulta.EM_ANDAMENTO, StatusConsulta.CONCLUIDA);
    }

    public void cancelar() {
        if (status == StatusConsulta.CONCLUIDA || status == StatusConsulta.CANCELADA) {
            throw new IllegalStateException("Consulta não pode ser cancelada");
        }

        status = StatusConsulta.CANCELADA;
    }

    private void alterarStatus(StatusConsulta atual, StatusConsulta novo) {
        if (status != atual) {
            throw new IllegalStateException("Transição de status inválida");
        }

        status = novo;
    }
    
}