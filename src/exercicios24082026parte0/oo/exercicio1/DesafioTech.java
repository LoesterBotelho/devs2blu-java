package exercicios24082026parte0.oo.exercicio1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DesafioTech {
    private String nomeEvento;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    private List<Equipe> equipes = new ArrayList<>(); 
    private List<Avaliador> banca = new ArrayList<>();

    public DesafioTech(String nomeEvento, LocalDate dataInicio, LocalDate dataFim) {
        this.nomeEvento = nomeEvento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public void registrarEquipe(Equipe equipe) {
        if (equipes.size() < 12) {
            equipes.add(equipe);
        } else {
            throw new IllegalStateException("O evento já atingiu o limite máximo de 12 equipes.");
        }
    }

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public List<Equipe> getEquipes() {
		return equipes;
	}

	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}

	public List<Avaliador> getBanca() {
		return banca;
	}

	public void setBanca(List<Avaliador> banca) {
		this.banca = banca;
	}

	@Override
	public String toString() {
		return "DesafioTech [nomeEvento=" + nomeEvento + 
				", dataInicio=" + dataInicio + 
				", dataFim=" + dataFim
				+ ", equipes=" + equipes + 
				", banca=" + banca + 
				"]";
	}

}