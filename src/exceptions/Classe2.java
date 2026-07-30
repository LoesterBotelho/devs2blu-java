package exceptions;

import exceptions.custom.ValidacaoException;

public class Classe2 {

    public void executar() throws ValidacaoException {

        System.out.println("Classe2");

        try {
            new Classe1().executar();
        } catch (ValidacaoException e) {

            // Acrescenta informação ao erro
            throw new ValidacaoException("Classe2 -> " + e.getMessage());

        }

    }

}