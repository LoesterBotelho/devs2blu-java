package exercicios17072026parte2;

public class Ex06 {

	private double metrosQuadradosM2 = 0.0;
	private double acres = 0.0;
	private double pesQuadradosFT2 = 0.0;
	private double hectares = 0.0;

	public Ex06() { }

	public Ex06(double metrosQuadradosM2) {	
		this.metrosQuadradosM2 = metrosQuadradosM2;
		getAcres();
		getPesQuadradosFT2();
		getHectares();
	}

	public double getMetrosQuadradosM2() {
		return metrosQuadradosM2;
	}
	
	public void setMetrosQuadradosM2(double metrosQuadradosM2) {
		this.metrosQuadradosM2 = metrosQuadradosM2;
	}
	
	public double getAcres() {
		this.acres = metrosQuadradosM2 / 4046.86;
		return this.acres;
	}
	
	public double getPesQuadradosFT2() {
		this.pesQuadradosFT2 = metrosQuadradosM2 * 10.7639; // (43560.0 / 4046.86) = 10.7639
		return this.pesQuadradosFT2;
	}
	
	public double getHectares() {
		this.hectares = metrosQuadradosM2 / 10000.0;
		return this.hectares;
	}

	@Override
	public String toString() {
		return "Ex06 [metrosQuadradosM2=" + metrosQuadradosM2 + 
				", acres=" + acres + 
				", pesQuadradosFT2=" + pesQuadradosFT2 + 
				", hectares=" + hectares + 
				"]";
	}

}
