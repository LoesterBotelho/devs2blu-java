package exercicios22072026parte1;

public class Ex03 {

	public static final int CAIXA_LARANJA = 60;
	public static final int CAIXA_LIMAO = 80;
	public static final int CAIXA_MORANGO = 80;
	
	private double precoCxLaranja = 0.0;
	private double PrecoCxLimao = 0.0;
	private double precoCxMorango = 0.0;
	
	public double getPrecoUnitarioLaranja() {
		return precoCxLaranja / CAIXA_LARANJA;
	}
	
	public double getPrecoUnitarioLimao() {
		return PrecoCxLimao / CAIXA_LIMAO;
	}
	
	public double getPrecoUnitarioMorango() {
		return precoCxMorango / CAIXA_MORANGO;
	}

	public void setPrecoCxLaranja(double precoCxLaranja) {
		this.precoCxLaranja = precoCxLaranja;
	}

	public void setPrecoCxLimao(double precoCxLimao) {
		PrecoCxLimao = precoCxLimao;
	}

	public void setPrecoCxMorango(double precoCxMorango) {
		this.precoCxMorango = precoCxMorango;
	}

	@Override
	public String toString() {
		return "Ex03 [precoCxLaranja=" + precoCxLaranja + 
				", PrecoCxLimao=" + PrecoCxLimao + 
				", precoCxMorango=" + precoCxMorango + 				
				", precoUnitarioLaranja=" + this.getPrecoUnitarioLaranja() + 
				", PrecoUnitarioLimao=" + this.getPrecoUnitarioLimao() + 
				", precoUnitarioMorango=" + this.getPrecoUnitarioMorango() + 
				"]";
	}	
	
	
}
