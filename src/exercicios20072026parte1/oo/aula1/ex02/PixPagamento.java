	package exercicios20072026parte1.oo.aula1.ex02;

	public class PixPagamento extends Pagamento {

	    private static final double TAXA = 0.01;

	    public PixPagamento(double valor) {
	        super(valor);
	    }

	    @Override
	    public double calcularTaxa() {
	        return getValor() * TAXA;
	    }

	    @Override
	    public void pagar() {
	        System.out.println("Pagamento via PIX realizado com sucesso.");
	    }

	    @Override
	    public String gerarComprovante() {

	        return String.format(
	                """
	                -------- PIX --------
	                Valor: R$ %.2f
	                Taxa : R$ %.2f
	                Total: R$ %.2f
	                """,
	                getValor(),
	                calcularTaxa(),
	                calcularTotal());
	    }

	}