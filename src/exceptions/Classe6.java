package exceptions;

import exceptions.custom.ValidacaoException;

public class Classe6 {

    public void executar() throws ValidacaoException {

        System.out.println("Classe6");

        try {
            new Classe5().executar();
        } catch (ValidacaoException e) {

            throw new ValidacaoException("Classe6 -> " + e.getMessage());

        }

    }

}