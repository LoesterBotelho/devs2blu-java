package exercicios22072026parte1;

public class Ex08 {

    private double valorProduto;
    private String formaPagamento;

    public Ex08() {
    }

    public Ex08(double valorProduto, String formaPagamento) {
        this.valorProduto = valorProduto;
        this.formaPagamento = formaPagamento;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean getTemDesconto() {

        return this.valorProduto >= 100
                && this.formaPagamento.equalsIgnoreCase("dinheiro"); // comparar duas Strings, ignorando letras maiúsculas e minúsculas.
    }

    public double getDesconto() {

        if (this.getTemDesconto()) {
            return this.valorProduto * 0.10;
        }

        return 0.0;
    }

    public double getValorFinal() {
        return this.valorProduto - this.getDesconto();
    }

    @Override
    public String toString() {
        return "Ex08 [valorProduto=" + this.getValorProduto()
                + ", formaPagamento=" + this.getFormaPagamento()
                + ", desconto=" + this.getDesconto()
                + ", valorFinal=" + this.getValorFinal()
                + "]";
    }

}