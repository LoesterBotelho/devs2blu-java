package exercicios23082026parte0.oo.exercicio1;

import java.math.BigDecimal;

public interface Financeiro {

	BigDecimal calcularValorTotal();

	boolean estaPago();

	BigDecimal calcularSaldo();

}