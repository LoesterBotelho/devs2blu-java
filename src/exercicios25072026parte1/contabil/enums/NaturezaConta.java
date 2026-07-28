package exercicios25072026parte1.contabil.enums;

public enum NaturezaConta {

	ATIVO("Ativo"), 
	PASSIVO("Passivo"), 
	PATRIMONIO_LIQUIDO("Patrimônio Líquido"), 
	RECEITA("Receita"),
	DESPESA("Despesa");

	private final String descricao;

	NaturezaConta(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}

}