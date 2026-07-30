package exceptions;

import exceptions.custom.ValidacaoException;

public class Classe5 {

    public void executar() throws ValidacaoException {

        System.out.println("Classe5");

        try {
            new Classe4().executar();
        } catch (ValidacaoException e) {

            throw new ValidacaoException("Classe5 -> " + e.getMessage());

        }

    }

}