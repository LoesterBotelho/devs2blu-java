package exercicios25102026parte0.oo.exercicio1;

public class Entregador extends Pessoa {
    private final String cnh;
    private Veiculo veiculo;

    public Entregador(String id, String nome, String telefone, String cnh, Veiculo veiculo) {
        super(id, nome, telefone);

        if (cnh == null || cnh.isBlank()) {
            throw new IllegalArgumentException("CNH obrigatória");
        }

        this.cnh = cnh;
        this.veiculo = veiculo;
    }

    public String getCnh() {
        return cnh;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}