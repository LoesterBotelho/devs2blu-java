package buscasbinario;

public class BuscaBinaria {


    public static ResultadoBusca buscar(
            int[] numeros,
            int valor) {


        int inicio = 0;

        int fim = numeros.length - 1;

        int passos = 0;



        while (inicio <= fim) {


            passos++;


            int meio = (inicio + fim) / 2;



            if (numeros[meio] == valor) {

                return new ResultadoBusca(
                        meio,
                        passos
                );
            }



            if (valor > numeros[meio]) {


                inicio = meio + 1;


            } else {


                fim = meio - 1;
            }
        }


        return new ResultadoBusca(
                -1,
                passos
        );
    }
}