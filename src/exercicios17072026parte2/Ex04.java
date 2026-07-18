package exercicios17072026parte2;

public class Ex04 {

	private int velocidade = 0;
	private int distancia5HorasEmKM = 0;
	private int distancia8HorasEmKM = 0;
	private int distancia12HorasEmKM = 0;

	public Ex04() { }

	public Ex04(int velocidade) {
		this.setVelocidade(velocidade);
	}

	public int getVelocidade() {
		return velocidade;
	}
	
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
		this.distancia5HorasEmKM = this.velocidade * 5;
		this.distancia8HorasEmKM = this.velocidade * 8;
		this.distancia12HorasEmKM = this.velocidade * 12;
				
	}
	
	public int getDistancia5HorasEmKM() {
		return distancia5HorasEmKM;
	}
	
	public int getDistancia8HorasEmKM() {
		return distancia8HorasEmKM;
	}
	
	public int getDistancia12HorasEmKM() {
		return distancia12HorasEmKM;
	}

	@Override
	public String toString() {
		return "Ex04 [velocidade=" + velocidade + 
				  ", distancia5HorasEmKM=" + distancia5HorasEmKM +
				  ", distancia8HorasEmKM=" + distancia8HorasEmKM + 
				  ", distancia12HorasEmKM=" + distancia12HorasEmKM
				  + "]";
	}

}
