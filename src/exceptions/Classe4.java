package exceptions;

import exceptions.custom.ValidacaoException;

public class Classe4 {

    public void executar() throws ValidacaoException {

        System.out.println("Classe4");

        try {
            new Classe3().executar();
        } catch (ValidacaoException e) {

            throw new ValidacaoException("Classe4 -> " + e.getMessage());

        }

    }

}