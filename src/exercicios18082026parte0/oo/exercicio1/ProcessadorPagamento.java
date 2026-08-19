package exercicios18082026parte0.oo.exercicio1;

public class ProcessadorPagamento {
    public void processar(Funcionario f) {
        System.out.println("Processando para: " + f.getNome());
        System.out.println("Salario calculado: " + f.calcularSalario());
        System.out.println("Hash: " + f.hashCode());
    }

    public void processar(Tributavel t) {
        System.out.println("Tributo calculado: " + t.calcularTributo());
    }
}
