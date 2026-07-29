package buscasbinario;

public class MainTesteBusca {


    public static void main(String[] args) {


        int quantidade = 2000;


        int[] numeros = new int[quantidade];



        // Criando números ordenados
        for (int i = 0; i < numeros.length; i++) {

            numeros[i] = i + 1;
        }



        int procurar = 1750;



        System.out.println(
                "Quantidade de números: "
                + numeros.length
        );


        System.out.println(
                "Número procurado: "
                + procurar
        );



        long inicio = System.nanoTime();



        ResultadoBusca resultado =
                BuscaBinaria.buscar(
                        numeros,
                        procurar
                );



        long fim = System.nanoTime();



        long tempo =
                fim - inicio;




        if (resultado.posicao() != -1) {


            System.out.println(
                    "Encontrado na posição: "
                    + resultado.posicao()
            );


        } else {


            System.out.println(
                    "Número não encontrado"
            );
        }



        System.out.println(
                "Quantidade de passos: "
                + resultado.passos()
        );



        System.out.println(
                "Tempo: "
                + tempo
                + " ns"
        );

    }
}