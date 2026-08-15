package exercicios14082026parte0.oo.exercicio1;

public class ServicoSemEncapsulamentoDinheiro implements RelatorioService {

	public String reciboNumero;
	public double troco;

	public ServicoSemEncapsulamentoDinheiro() {
	}

	public ServicoSemEncapsulamentoDinheiro(String reciboNumero, double troco) {
		this.reciboNumero = reciboNumero;
		this.troco = troco;
	}

	public String getReciboNumero() {
		return reciboNumero;
	}

	public void setReciboNumero(String reciboNumero) {
		this.reciboNumero = reciboNumero;
	}

	public double getTroco() {
		return troco;
	}

	public void setTroco(double troco) {
		this.troco = troco;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio sem encapsulamento para dinheiro: " + reciboNumero);
	}

	@Override
	public String toString() {
		return "ServicoSemEncapsulamentoDinheiro [reciboNumero=" + reciboNumero + ", troco=" + troco + "]";
	}
}