package exercicios14102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class Paciente extends Pessoa {
	
    private final String numeroProntuario;
    private final List<String> historico = new ArrayList<>();

    public Paciente(
            String nome,
            String documento,
            int idade,
            String numeroProntuario) {

        super(nome, documento, idade);

        if (numeroProntuario == null || numeroProntuario.isBlank()) {
            throw new IllegalArgumentException("Prontuario obrigatorio");
        }

        this.numeroProntuario = numeroProntuario;
    }

    public String getNumeroProntuario() {
        return numeroProntuario;
    }

    public void adicionarRegistro(String registro) {
        if (registro == null || registro.isBlank()) {
            throw new IllegalArgumentException("Registro obrigatorio");
        }

        historico.add(registro);
    }

    public List<String> getHistorico() {
        return List.copyOf(historico);
    }

    @Override
    public String getTipo() {
        return "Paciente";
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Prontuario: " + numeroProntuario;
    }
    
}