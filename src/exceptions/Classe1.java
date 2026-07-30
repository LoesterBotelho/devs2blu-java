package exceptions;

import exceptions.custom.ValidacaoException;

public class Classe1 {

	public void executar() throws ValidacaoException {

		System.out.println("Classe1");

		// Simula um erro
		throw new ValidacaoException("Erro na Classe1");

	}

}
