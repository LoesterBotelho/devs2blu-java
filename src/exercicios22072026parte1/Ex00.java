package exercicios22072026parte1;

import java.util.Calendar;

public class Ex00 {

	private int diaSemana = 0;

	public Ex00() { }

	public Ex00(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public String getDiaSemanaTexto() {

		        switch (this.diaSemana) {		        
	            case Calendar.SUNDAY: return "Domingo";
				case Calendar.MONDAY: return "Segunda-feira";
				case Calendar.TUESDAY: return "Terça-feira";
				case Calendar.WEDNESDAY: return "Quarta-feira";
				case Calendar.THURSDAY: return "Quinta-feira";
				case Calendar.FRIDAY: return "Sexta-feira";
				case Calendar.SATURDAY: return "Sábado";
				default: return "Dia inválido";		                
		        }
	}

	public void setDiaSemana(int diaSemana) {
		this.diaSemana = diaSemana;
	}

	public int getDiaSemana() {
		return diaSemana;
	}

	@Override
	public String toString() {
		return "Ex00 [diaSemana=" + this.getDiaSemana() + 
				" , diaSemanaTexto=" + this.getDiaSemanaTexto() + 
				"]";
	}

}
