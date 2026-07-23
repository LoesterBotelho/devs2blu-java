package exercicios22072026parte1;

public class Ex05 {

    private int valorCompra;
    private int valorPagamento;

    public Ex05() {
    }

    public Ex05(int valorCompra, int valorPagamento) {
        this.valorCompra = valorCompra;
        this.valorPagamento = valorPagamento;
    }

    public int getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(int valorCompra) {
        this.valorCompra = valorCompra;
    }

    public int getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(int valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public boolean isPagamentoValido() {
        return this.valorPagamento >= this.valorCompra;
    }

    public int getTroco() {
        if (!isPagamentoValido()) {
            return 0;
        }

        return this.valorPagamento - this.valorCompra;
    }

	 // Princípio da decomposição de números.
	 // Exemplo:
	 // 757 = 700 + 50 + 7
	 //
	 // 7 notas de R$100
	 // 5 notas de R$10
	 // 7 notas de R$1
    
    
	 // Calcula a quantidade de notas de R$100.
	 // Exemplo:
	 // 757 / 100 = 7    
    public int getNotas100() {
        return this.getTroco() / 100;
    }

	 // Calcula a quantidade de notas de R$10.
	 // Primeiro pega o restante após retirar as centenas.
	 // Exemplo:
	 // 757 % 100 = 57
	 // 57 / 10 = 5
    public int getNotas10() {
        return (this.getTroco() % 100) / 10;
    }

	 // Calcula a quantidade de notas de R$1.
	 // Pega o restante após retirar as dezenas.
	 // Exemplo:
	 // 757 % 10 = 7    
    public int getNotas1() {
        return this.getTroco() % 10;
    }

    @Override
    public String toString() {

        if (!isPagamentoValido()) {
            return "Ex05 [Pagamento Negado]";
        }

        return "Ex05 [valorCompra=" + this.getValorCompra()
                + ", valorPagamento=" + this.getValorPagamento()
                + ", troco=" + this.getTroco()
                + ", notas100=" + this.getNotas100()
                + ", notas10=" + this.getNotas10()
                + ", notas1=" + this.getNotas1()
                + "]";
    }

}