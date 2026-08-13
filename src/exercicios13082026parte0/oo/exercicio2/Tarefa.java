package exercicios13082026parte0.oo.exercicio2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

class Tarefa {
	private static int contadorId = 1;
	private int id;
	private String nomeCurto;
	private String descricaoLonga;
	private LocalDate dataInicio;
	private LocalDate dataFim;
	private double totalHorasGastas;

	public Tarefa() {
		this.id = contadorId++;
	}

	public Tarefa(String nomeCurto, String descricaoLonga, LocalDate dataInicio, LocalDate dataFim) {
		this();
		this.nomeCurto = nomeCurto;
		this.descricaoLonga = descricaoLonga;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.totalHorasGastas = calcularHorasUteis();
	}

	private double calcularHorasUteis() {
		if (dataInicio == null || dataFim == null || dataInicio.isAfter(dataFim))
			return 0;

		long totalHoras = 0;
		LocalDate cursor = dataInicio;
		while (!cursor.isAfter(dataFim)) {
			DayOfWeek day = cursor.getDayOfWeek();

			if (day != DayOfWeek.SATURDAY && day != DayOfWeek.SUNDAY) {
				totalHoras += 9;
			}
			cursor = cursor.plusDays(1);
		}
		return (double) totalHoras;
	}

	@Override
	public String toString() {
		return "Tarefa [ID=" + id + ", Nome=" + nomeCurto + ", Horas Uteis=" + totalHorasGastas + "h]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeCurto() {
		return nomeCurto;
	}

	public void setNomeCurto(String nomeCurto) {
		this.nomeCurto = nomeCurto;
	}

	public String getDescricaoLonga() {
		return descricaoLonga;
	}

	public void setDescricaoLonga(String descricaoLonga) {
		this.descricaoLonga = descricaoLonga;
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

	public double getTotalHorasGastas() {
		return totalHorasGastas;
	}

	public void setTotalHorasGastas(double totalHorasGastas) {
		this.totalHorasGastas = totalHorasGastas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return id == other.id;
	}

}
