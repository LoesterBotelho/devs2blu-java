package exceptions;

import exceptions.custom.ValidacaoException;

public class Classe7 {

	public void executar() throws ValidacaoException {

		System.out.println("Classe7");

		try {
			new Classe6().executar();
		} catch (ValidacaoException e) {

			throw new ValidacaoException("Classe7 -> " + e.getMessage());

		}

	}

}