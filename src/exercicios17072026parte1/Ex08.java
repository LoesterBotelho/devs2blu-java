package exercicios17072026parte1;

public class Ex08 {

	private int horas = 0;

	public Ex08() { }

	public Ex08(int horas) {
		this.horas = horas;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		return this.horas * 60;
	}

	public int getSegundos() {
		return this.horas * 3600;
	}

	@Override
	public String toString() {
		return "Ex08 [horas=" + this.getHoras() + 
				", minutos=" + this.getMinutos() + 
				", segundos=" + this.getSegundos() + 
				"]";
	}

}