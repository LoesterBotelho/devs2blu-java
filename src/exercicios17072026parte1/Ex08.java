package exercicios17072026parte1;

public class Ex08 {

	private int horas = 0;
	private int minutos = 0;
	private int segundos = 0;

	public Ex08() { }

	public Ex08(int horas) {
		this.horas = horas;
		this.getMinutos();
		this.getSegundos();
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMinutos() {
		this.minutos = this.horas * 60;
		return this.minutos;
	}

	public int getSegundos() {
		this.segundos = this.horas * 3600;
		return this.segundos;
	}

	@Override
	public String toString() {
		return "Ex08 [horas=" + this.getHoras() + 
				", minutos=" + this.getMinutos() + 
				", segundos=" + this.getSegundos() + 
				"]";
	}

}