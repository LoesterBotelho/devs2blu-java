package exercicios30072026parte1.desafio.oo;

public class ValidadorVitoria {

    public boolean validar(Tabuleiro tabuleiro, char simbolo) {

        return validarLinhas(tabuleiro, simbolo)
                || validarColunas(tabuleiro, simbolo)
                || validarDiagonais(tabuleiro, simbolo);

    }


    private boolean validarLinhas(Tabuleiro tabuleiro, char simbolo) {

        return validarSequencia(tabuleiro, simbolo,
                new Posicao(0, 0),
                new Posicao(0, 1),
                new Posicao(0, 2))

            || validarSequencia(tabuleiro, simbolo,
                new Posicao(1, 0),
                new Posicao(1, 1),
                new Posicao(1, 2))

            || validarSequencia(tabuleiro, simbolo,
                new Posicao(2, 0),
                new Posicao(2, 1),
                new Posicao(2, 2));

    }


    private boolean validarColunas(Tabuleiro tabuleiro, char simbolo) {

        return validarSequencia(tabuleiro, simbolo,
                new Posicao(0, 0),
                new Posicao(1, 0),
                new Posicao(2, 0))

            || validarSequencia(tabuleiro, simbolo,
                new Posicao(0, 1),
                new Posicao(1, 1),
                new Posicao(2, 1))

            || validarSequencia(tabuleiro, simbolo,
                new Posicao(0, 2),
                new Posicao(1, 2),
                new Posicao(2, 2));

    }


    private boolean validarDiagonais(Tabuleiro tabuleiro, char simbolo) {

        return validarSequencia(tabuleiro, simbolo,
                new Posicao(0, 0),
                new Posicao(1, 1),
                new Posicao(2, 2))

            || validarSequencia(tabuleiro, simbolo,
                new Posicao(0, 2),
                new Posicao(1, 1),
                new Posicao(2, 0));

    }


    private boolean validarSequencia(
            Tabuleiro tabuleiro,
            char simbolo,
            Posicao p1,
            Posicao p2,
            Posicao p3) {

        return tabuleiro.get(p1) == simbolo
                && tabuleiro.get(p2) == simbolo
                && tabuleiro.get(p3) == simbolo;

    }

}