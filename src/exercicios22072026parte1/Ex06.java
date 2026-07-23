package exercicios22072026parte1;

public class Ex06 {

	private double saldoMedioUltimoAno = 0.0;

	public Ex06() {	}

	public Ex06(double saldoMedioUltimoAno) {
		this.saldoMedioUltimoAno = saldoMedioUltimoAno;
	}

	public double getValorCreditoPreAprovado() {
		
		if ( (this.saldoMedioUltimoAno >= 0) && (this.saldoMedioUltimoAno <= 200)  ) {
			return 0;
		} else 	if ( (this.saldoMedioUltimoAno >= 201) && (this.saldoMedioUltimoAno <= 400)  ) {
			return this.saldoMedioUltimoAno * 0.2; // (20/100)=0,2; // 20%
		} else 	if ( (this.saldoMedioUltimoAno >= 401) && (this.saldoMedioUltimoAno <= 600)  ) { 
			return this.saldoMedioUltimoAno * 0.3; // (30/100)=0,3; //30%
		} else 	if ( (this.saldoMedioUltimoAno >= 601) ) { 
			return this.saldoMedioUltimoAno * 0.4; // (40/100)=0,4; //40¨%
		} else {
			return 0.0;
		}
		
	}
	
	public double getSaldoMedioUltimoAno() {
		return saldoMedioUltimoAno;
	}

	public void setSaldoMedioUltimoAno(double saldoMedioUltimoAno) {
		this.saldoMedioUltimoAno = saldoMedioUltimoAno;
	}

	@Override
	public String toString() {
		return "Ex06 [saldoMedioUltimoAno=" + this.getSaldoMedioUltimoAno() + 
				", valorCreditoPreAprovado=" + this.getValorCreditoPreAprovado() +
				"]";
	}

}