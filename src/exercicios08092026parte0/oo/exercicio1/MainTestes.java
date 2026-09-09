package exercicios08092026parte0.oo.exercicio1;

import java.util.ArrayList;

public class MainTestes {
	public static void main(String[] args) {
		
		Carro carro1 = new Carro(1L, "Sedan Luxo", 4);
		Moto moto1 = new Moto(2L, "Esportiva 1000cc", 1000);

		Garagem<Veiculo> garagemGeral = new Garagem<>(1L, new ArrayList<>());
		
		garagemGeral.adicionarVeiculo(carro1);
		garagemGeral.adicionarVeiculo(moto1);

		garagemGeral.listarVeiculos();
	}
}