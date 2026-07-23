package exercicios22072026parte1;

public class Ex01 {

	private int inteiroPositivo = 0;

	public Ex01() { }

	public Ex01(int inteiroPositivo) {
		this.inteiroPositivo = inteiroPositivo;
	}

	public int getInteiroPositivo() {
		return inteiroPositivo;
	}

	public String getParImpar() {		
		return ( (this.inteiroPositivo % 2 == 0) ? "Par" : "Ímpar" );
		
	}
	
	public void setInteiroPositivo(int inteiroPositivo) {
		
		if (inteiroPositivo >= 0) {
			this.inteiroPositivo = inteiroPositivo;
		} else {
			this.inteiroPositivo = 0;
			System.out.println("Erro : somente é aceito números positivos");
		}
	}

	@Override
	public String toString() {
		return "Ex01 [inteiroPositivo=" + this.getInteiroPositivo() + 
				" ,ehPar=" + this.getParImpar() +
				"]";
	}

}
