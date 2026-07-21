package exercicios17072026parte2;

public class Ex06 {

	private double metrosQuadradosM2 = 0.0;

	public Ex06() { }

	public Ex06(double metrosQuadradosM2) {	
		this.metrosQuadradosM2 = metrosQuadradosM2;
	}

	public double getMetrosQuadradosM2() {
		return metrosQuadradosM2;
	}
	
	public void setMetrosQuadradosM2(double metrosQuadradosM2) {
		this.metrosQuadradosM2 = metrosQuadradosM2;
	}
	
	public double getAcres() {
		return metrosQuadradosM2 / 4046.86;
	}
	
	public double getPesQuadradosFT2() {		
		return metrosQuadradosM2 * 10.7639; // (43560.0 / 4046.86) = 10.7639
	}
	
	public double getHectares() {
		return metrosQuadradosM2 / 10000.0;
	}

	@Override
	public String toString() {
		return "Ex06 [metrosQuadradosM2=" + this.getMetrosQuadradosM2() + 
				", acres=" + this.getAcres() + 
				", pesQuadradosFT2=" + this.getPesQuadradosFT2() + 
				", hectares=" + this.getHectares() + 
				"]";
	}

}
