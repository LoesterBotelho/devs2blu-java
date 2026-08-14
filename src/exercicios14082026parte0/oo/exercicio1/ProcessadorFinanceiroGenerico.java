package exercicios14082026parte0.oo.exercicio1;

import java.util.List;

public class ProcessadorFinanceiroGenerico<T extends TransacaoFinanceira> {

	private List<T> transacoes;

	public ProcessadorFinanceiroGenerico() {
	}

	public ProcessadorFinanceiroGenerico(List<T> transacoes) {
		this.transacoes = transacoes;
	}

	public List<T> getTransacoes() {
		return transacoes;
	}

	public void setTransacoes(List<T> transacoes) {
		this.transacoes = transacoes;
	}

	public void adicionarTransacao(T transacao) {
		this.transacoes.add(transacao);
	}

	public double somarValores(List<? extends TransacaoFinanceira> lista) {
		double total = 0.0;
		for (TransacaoFinanceira t : lista) {
			total += t.getValor();
		}
		return total;
	}

	@Override
	public String toString() {
		return "ProcessadorFinanceiroGenerico [transacoes=" + transacoes + "]";
	}
}