package exceptions;

import exceptions.custom.ValidacaoException;

public class Main {

	public static void main(String[] args) {

		try {

			System.out.println("APP INICIADO");

			Classe7 classe7 = new Classe7();
			classe7.executar();

			System.out.println("Fim do programa.");

		} catch (ValidacaoException e) {

			System.out.println();
			System.out.println("ERRO DE VALIDAÇÃO");
			System.out.println(e.getMessage());

		} catch (Exception e) {

			System.out.println();
			System.out.println("ERRO INESPERADO");
			e.printStackTrace();

		} finally {

			System.out.println();
			System.out.println("Finally sempre será executado.");

		}

		System.out.println("APP FINALIZADO");

	}

}