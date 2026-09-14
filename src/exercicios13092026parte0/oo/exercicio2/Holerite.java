package exercicios13092026parte0.oo.exercicio2;

import java.util.List;

public record Holerite(
        Funcionario funcionario,
        double salarioBase,
        List<Provento> proventos,
        List<Desconto> descontos
) {

    public double totalProventos() {
        return proventos.stream()
                .mapToDouble(Provento::calcular)
                .sum();
    }

    public double salarioBruto() {
        return salarioBase + totalProventos();
    }

    public double totalDescontos() {
        return descontos.stream()
                .mapToDouble(Desconto::calcular)
                .sum();
    }

    public double salarioLiquido() {
        return salarioBruto() - totalDescontos();
    }

}