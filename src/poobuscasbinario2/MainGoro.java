package poobuscasbinario2;

public class MainGoro {


    public static void main(String[] args) {


        int tamanhoMemoria = 200000;


        int[] memoria = new int[tamanhoMemoria];



        // Criando memória ordenada
        for (int i = 0; i < memoria.length; i++) {

            memoria[i] = i + 1;
        }



        int alvo = 175000;



        System.out.println(
                "Goro procurando: "
                + alvo
        );


        System.out.println();



        long inicioTempo = System.nanoTime();



        ResultadoBusca resultado =
                GoroBuscaBinaria.procurar(
                        memoria,
                        alvo
                );



        long fimTempo = System.nanoTime();



        System.out.println();


        if(resultado.posicao() != -1) {


            System.out.println(
                    "Encontrou na posição: "
                    + resultado.posicao()
            );


        } else {


            System.out.println(
                    "Não encontrou"
            );
        }



        System.out.println(
                "Quantidade de golpes: "
                + resultado.golpes()
        );



        System.out.println(
                "Tempo: "
                + (fimTempo - inicioTempo)
                + " ns"
        );
    }
}