package exercicios17072026parte2;

public class Ex04 {

	private int velocidade = 0;

	public Ex04() { }

	public Ex04(int velocidade) {
		this.setVelocidade(velocidade);
	}

	public int getVelocidade() {
		return velocidade;
	}
	
	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;				
	}
	
	public int getDistancia5HorasEmKM() {
		return this.velocidade * 5;
	}
	
	public int getDistancia8HorasEmKM() {
		return this.velocidade * 8;
	}
	
	public int getDistancia12HorasEmKM() {
		return this.velocidade * 12;
	}

	@Override
	public String toString() {
		return "Ex04 [velocidade=" + velocidade + 
				  ", distancia5HorasEmKM=" + this.getDistancia5HorasEmKM() +
				  ", distancia8HorasEmKM=" + this.getDistancia8HorasEmKM() + 
				  ", distancia12HorasEmKM=" + this.getDistancia12HorasEmKM()
				  + "]";
	}

}
