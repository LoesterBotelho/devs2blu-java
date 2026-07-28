package exemplos;

public class EstruturasDeDadosBasicas {

    public static void main(String[] args) {

        System.out.println("===== ARRAYS =====");
        arrays();

        System.out.println("\n===== LIST =====");
        listas();

        System.out.println("\n===== QUEUE =====");
        filas();

        System.out.println("\n===== STACK =====");
        pilhas();

        System.out.println("\n===== TREE =====");
        arvores();
    }

    /**
     * ============================================================
     * ARRAYS
     * ============================================================
     */
    static void arrays() {

        /*
         *
         * ANALOGIA
         *
         * Imagine um prédio com apartamentos.
         *
         * Cada apartamento possui um número.
         *
         * Apartamento:
         *
         * 0
         * 1
         * 2
         * 3
         * 4
         *
         * Você acessa diretamente o apartamento desejado.
         *
         */

        String[] nomes = {
                "João",
                "Maria",
                "Pedro",
                "Lucas"
        };

        System.out.println(nomes[0]);
        System.out.println(nomes[1]);

        /*
         * MATRIZ
         *
         * Imagine um tabuleiro de xadrez.
         *
         * Existem linhas e colunas.
         *
         */

        int[][] matriz = {
                {1,2},
                {3,4},
                {5,6}
        };

        System.out.println(matriz[2][1]);
    }

    /**
     * ============================================================
     * LIST
     * ============================================================
     */
    static void listas() {

        /*
         *
         * ANALOGIA
         *
         * Imagine uma lista de compras.
         *
         * Você pode:
         *
         * adicionar
         * remover
         * alterar
         *
         * facilmente.
         *
         */

        java.util.List<String> frutas = new java.util.ArrayList<>();

        frutas.add("Maçã");
        frutas.add("Banana");
        frutas.add("Uva");

        frutas.remove("Banana");

        frutas.add("Laranja");

        System.out.println(frutas);

    }

    /**
     * ============================================================
     * QUEUE
     * ============================================================
     */
    static void filas() {

        /*
         *
         * ANALOGIA
         *
         * Imagine uma fila de banco.
         *
         * Quem chega primeiro
         * sai primeiro.
         *
         * FIFO
         *
         * First In
         * First Out
         *
         */

        java.util.Queue<String> fila =
                new java.util.LinkedList<>();

        fila.add("Cliente A");
        fila.add("Cliente B");
        fila.add("Cliente C");

        System.out.println(fila.poll());

        System.out.println(fila.poll());

        System.out.println(fila);

    }

    /**
     * ============================================================
     * STACK
     * ============================================================
     */
    static void pilhas() {

        /*
         *
         * ANALOGIA
         *
         * Imagine uma pilha de pratos.
         *
         * O último prato colocado
         * será o primeiro retirado.
         *
         * LIFO
         *
         * Last In
         * First Out
         *
         */

        java.util.Stack<String> pilha =
                new java.util.Stack<>();

        pilha.push("Livro 1");
        pilha.push("Livro 2");
        pilha.push("Livro 3");

        System.out.println(pilha.pop());

        System.out.println(pilha);

    }

    /**
     * ============================================================
     * TREE
     * ============================================================
     */
    static void arvores() {

        /*
         *
         * ANALOGIA
         *
         * Imagine uma árvore genealógica.
         *
         *         Pai
         *       /     \
         *   Filho1   Filho2
         *    /
         * Neto
         *
         */

        No raiz = new No("A");

        raiz.esquerda = new No("B");
        raiz.direita = new No("C");

        raiz.esquerda.esquerda = new No("D");

        System.out.println("Raiz: " + raiz.valor);
        System.out.println("Esquerda: " + raiz.esquerda.valor);
        System.out.println("Direita: " + raiz.direita.valor);
        System.out.println("Neto: " + raiz.esquerda.esquerda.valor);

    }

}

