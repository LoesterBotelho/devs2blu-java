package exercicios17072026parte1;

public class Ex05 {

	private static final double PRECO_HORA = 2.30;
	private static final double PRECO_MINUTO = 0.0383;
	private int totalMinutos = 0;
	private double precoTotal = 0;

	public Ex05() { }

	public Ex05(int totalMinutos) {
		this.totalMinutos = totalMinutos;
		this.getPrecoTotal();
	}

	public double getPrecoTotal() {
		
		int horas = (this.totalMinutos / 60);
		int minutos = this.totalMinutos - (horas * 60);
		
		this.precoTotal = (horas * PRECO_HORA) + (minutos * PRECO_MINUTO);

		return this.precoTotal;
	}
	
	public void setTotalMinutos(int totalMinutos) {
		this.totalMinutos = totalMinutos;
	}
	
	
	public int getTotalMinutos() {
		return totalMinutos;
	}

	@Override
	public String toString() {
		return "Ex05 [totalMinutos=" + this.getTotalMinutos() + 
				", precoTotal=" + this.getPrecoTotal() + 
				"]";
	} 

	
	
}
