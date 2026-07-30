package exceptions;

import exceptions.custom.ValidacaoException;

public class Classe3 {

    public void executar() throws ValidacaoException {

        System.out.println("Classe3");

        try {
            new Classe2().executar();
        } catch (ValidacaoException e) {

            throw new ValidacaoException("Classe3 -> " + e.getMessage());

        }

    }

}