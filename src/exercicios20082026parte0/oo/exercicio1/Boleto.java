package exercicios20082026parte0.oo.exercicio1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Boleto implements Pagamento {

	private String dataVencimento;
	private String codigoDeBarras;

	public Boleto() {
	}

	public Boleto(String codigoDeBarras, String dataVencimento) {
		this.codigoDeBarras = codigoDeBarras;
		this.dataVencimento = dataVencimento;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	@Override
	public String toString() {
		return "Boleto [codigoDeBarras=" + this.getCodigoDeBarras() + 
				", dataVencimento=" + this.getDataVencimento() + 
				"]";
	}

	@Override
	public void processarPagamento(double valor) {
		
		String comprovante = String.format("Processando pagamento de R$ %.2f com Boleto Bancário.\n\n", valor) + 
		                   this.obterDetalhes() + 
		                   "Data de Pagamento: " + formatarData( LocalDateTime.now() );
		
		System.out.println( comprovante );		
	}

	@Override
	public String obterDetalhes() {
		
		return "Pagamento via Cartão de Crédito\n" + 
		       "Código de Barras: " + this.getCodigoDeBarras() + "\n" +
		       "Data de vencimento: " + this.getDataVencimento() + "\n";
	}

	
	public static String formatarData(LocalDateTime data) {
	    DateTimeFormatter formatter =
	            DateTimeFormatter.ofPattern("dd/MM/yyyy");

	    return data.format(formatter);
	}
	
}
