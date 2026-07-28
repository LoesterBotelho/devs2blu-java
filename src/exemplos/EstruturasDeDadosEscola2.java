package exemplos;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * ===============================================================
 *           ESTRUTURAS DE DADOS - EXEMPLO SIMPLES
 * ===============================================================
 *
 * Imagine uma ESCOLA.
 *
 * Temos os seguintes alunos:
 *
 * Carlos
 * Ana
 * Pedro
 * Bruno
 *
 * Vamos armazenar esses alunos utilizando várias estruturas
 * diferentes para entender como cada uma funciona.
 *
 * Cada estrutura possui um objetivo diferente.
 *
 * ===============================================================
 */
public class EstruturasDeDadosEscola2 {

    public static void main(String[] args) {

        exemploArray();

        exemploList();

        exemploQueue();

        exemploStack();

        exemploTree();

    }

    /**
     * ==========================================================
     * ARRAY
     * ==========================================================
     */
    private static void exemploArray() {

        System.out.println("\n========================================");
        System.out.println("ARRAY");
        System.out.println("========================================");

        /*
         * ANALOGIA
         *
         * Imagine uma estante com gavetas numeradas.
         *
         * Cada gaveta possui um número.
         *
         * 0
         * 1
         * 2
         * 3
         */

        String[] alunos = {
                "Carlos",
                "Ana",
                "Pedro",
                "Bruno"
        };

        System.out.println("Array original:");

        for (String aluno : alunos) {
            System.out.println(aluno);
        }

        System.out.println("\nAluno da posição 2:");

        System.out.println(alunos[2]);

        /*
         * O array NÃO organiza sozinho.
         *
         * Precisamos pedir para ordenar.
         */

        Arrays.sort(alunos);

        System.out.println("\nArray ordenado:");

        for (String aluno : alunos) {
            System.out.println(aluno);
        }

    }

    /**
     * ==========================================================
     * LIST
     * ==========================================================
     */
    private static void exemploList() {

        System.out.println("\n========================================");
        System.out.println("LIST");
        System.out.println("========================================");

        /*
         * ANALOGIA
         *
         * Imagine uma lista de chamada.
         *
         * Podemos adicionar
         * remover
         * alterar
         * facilmente.
         */

        List<String> alunos = new ArrayList<>();

        alunos.add("Carlos");
        alunos.add("Ana");
        alunos.add("Pedro");
        alunos.add("Bruno");

        System.out.println("Lista original:");

        alunos.forEach(System.out::println);

        /*
         * Chegou um novo aluno.
         */

        alunos.add("Lucas");

        System.out.println("\nDepois de adicionar Lucas:");

        alunos.forEach(System.out::println);

        /*
         * Agora vamos ordenar.
         */

        Collections.sort(alunos);

        System.out.println("\nLista ordenada:");

        alunos.forEach(System.out::println);

    }

    /**
     * ==========================================================
     * QUEUE
     * ==========================================================
     */
    private static void exemploQueue() {

        System.out.println("\n========================================");
        System.out.println("QUEUE (FILA)");
        System.out.println("========================================");

        /*
         * ANALOGIA
         *
         * Imagine a fila da cantina.
         *
         * Quem chega primeiro
         * será atendido primeiro.
         *
         * FIFO
         * First In
         * First Out
         */

        Queue<String> fila = new LinkedList<>();

        fila.add("Carlos");
        fila.add("Ana");
        fila.add("Pedro");
        fila.add("Bruno");

        System.out.println("Fila:");

        System.out.println(fila);

        System.out.println("\nPrimeiro atendido:");

        System.out.println(fila.poll());

        System.out.println("\nFila restante:");

        System.out.println(fila);

        /*
         * A fila NÃO é feita para ordenar.
         *
         * Ela respeita quem chegou primeiro.
         */

    }

    /**
     * ==========================================================
     * STACK
     * ==========================================================
     */
    private static void exemploStack() {

        System.out.println("\n========================================");
        System.out.println("STACK (PILHA)");
        System.out.println("========================================");

        /*
         * ANALOGIA
         *
         * Imagine uma pilha de livros.
         *
         * O último livro colocado
         * será o primeiro retirado.
         *
         * LIFO
         * Last In
         * First Out
         */

        Stack<String> pilha = new Stack<>();

        pilha.push("Carlos");
        pilha.push("Ana");
        pilha.push("Pedro");
        pilha.push("Bruno");

        System.out.println("Pilha:");

        System.out.println(pilha);

        System.out.println("\nLivro removido:");

        System.out.println(pilha.pop());

        System.out.println("\nPilha restante:");

        System.out.println(pilha);

    }

    /**
     * ==========================================================
     * TREE
     * ==========================================================
     */
    private static void exemploTree() {

        System.out.println("\n========================================");
        System.out.println("TREE (ÁRVORE)");
        System.out.println("========================================");

        /*
         * ANALOGIA
         *
         * Imagine uma árvore genealógica.
         *
         * Cada pessoa possui filhos.
         *
         * Ou imagine as pastas do Windows.
         *
         * C:
         *   Documentos
         *      Fotos
         *      PDF
         *   Downloads
         */

        No raiz = new No("Carlos");

        raiz.esquerda = new No("Ana");

        raiz.direita = new No("Pedro");

        raiz.esquerda.direita = new No("Bruno");

        /*
         * Estrutura criada:
         *
         *          Carlos
         *          /    \
         *       Ana     Pedro
         *         \
         *        Bruno
         */

        System.out.println("Raiz: " + raiz.valor);

        System.out.println("Filho esquerdo: " + raiz.esquerda.valor);

        System.out.println("Filho direito: " + raiz.direita.valor);

        System.out.println("Neto: " + raiz.esquerda.direita.valor);

        System.out.println("\nPercorrendo em ordem:");

        emOrdem(raiz);

        /*
         * Resultado:
         *
         * Ana
         * Bruno
         * Carlos
         * Pedro
         *
         * Observe que os nomes ficaram em ordem alfabética
         * graças ao percurso em ordem da árvore.
         */

    }

    /**
     * Percurso em Ordem (In-Order)
     *
     * Esquerda
     * Raiz
     * Direita
     */
    private static void emOrdem(No no) {

        if (no == null) {
            return;
        }

        emOrdem(no.esquerda);

        System.out.println(no.valor);

        emOrdem(no.direita);

    }

}

