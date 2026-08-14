package exercicios14082026parte0.oo.exercicio1;

public class ServicoSemEncapsulamentoPix implements RelatorioService {

	public String qrCodeId;
	public double descontoPix;

	public ServicoSemEncapsulamentoPix() {
	}

	public ServicoSemEncapsulamentoPix(String qrCodeId, double descontoPix) {
		this.qrCodeId = qrCodeId;
		this.descontoPix = descontoPix;
	}

	public String getQrCodeId() {
		return qrCodeId;
	}

	public void setQrCodeId(String qrCodeId) {
		this.qrCodeId = qrCodeId;
	}

	public double getDescontoPix() {
		return descontoPix;
	}

	public void setDescontoPix(double descontoPix) {
		this.descontoPix = descontoPix;
	}

	@Override
	public void exportar() {
		System.out.println("Exportando relatorio sem encapsulamento para Pix: " + qrCodeId);
	}

	@Override
	public String toString() {
		return "ServicoSemEncapsulamentoPix [qrCodeId=" + qrCodeId + ", descontoPix=" + descontoPix + "]";
	}
}