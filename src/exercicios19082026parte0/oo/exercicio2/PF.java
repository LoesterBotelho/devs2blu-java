package exercicios19082026parte0.oo.exercicio2;

public class PF extends contribuinte {

	private String cpf;
	
	public PF() {
		super();
	}

	public PF(String nome, String cpf, double faturamento) {
		super(nome, faturamento);
		this.cpf = cpf;
	}

	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double calcularValorIIRF() {		
		
		double salarioBruto = this.getFaturamento();
		double impostoCalculado = 0.0;
		
		     if (salarioBruto <= 1400.00) { impostoCalculado = (salarioBruto * 0.0) - 0; } 
		else if (salarioBruto <= 2100.00) { impostoCalculado = (salarioBruto * 0.10) - 100.00; } 
		else if (salarioBruto <= 2800.00) { impostoCalculado = (salarioBruto * 0.15) - 270.00; } 
		else if (salarioBruto <= 3600.00) { impostoCalculado = (salarioBruto * 0.25) - 500.00; } 
        else { impostoCalculado = (salarioBruto * 0.30) - 700.00;
        }
		     
		     return impostoCalculado;
		
	}
	
	@Override
	public void calcularIIRF() {		
		
		double impostoCalculado = calcularValorIIRF();
		     
	     System.out.println("O Contribuinte PF : " + this.getNome() +
	    		            " Com CPF : " + this.getCpf() + 
	    		            " Com Faturalmento Mensal de : " + this.getFaturamento() + 
    		                " Com imposto devido de : " + impostoCalculado
	    		 );
		
	}
	
	@Override
	public String toString() {
		return "PF [nome=" + this.getNome() + 
				", cpf=" + this.getCpf() +
				", faturamentoMensal=" + this.getFaturamento() +
				", impostoDevido=" + calcularValorIIRF() + 				
				"]";
	}	

}
