package poobuscasbinario2;

public class GoroBuscaBinaria {


    public static ResultadoBusca procurar(
            int[] memoria,
            int numero) {


        int inicio = 0;

        int fim = memoria.length - 1;

        int golpes = 0;



        while (inicio <= fim) {


            golpes++;


            int meio = (inicio + fim) / 2;



            System.out.println(
                    "Golpe " + golpes +
                    " - olhando posição " + meio +
                    " valor: " + memoria[meio]
            );



            if (memoria[meio] == numero) {


                return new ResultadoBusca(
                        meio,
                        golpes
                );
            }



            if (numero > memoria[meio]) {


                inicio = meio + 1;


            } else {


                fim = meio - 1;
            }
        }


        return new ResultadoBusca(
                -1,
                golpes
        );
    }
}