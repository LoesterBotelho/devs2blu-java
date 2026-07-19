package exercicios19072026parte2;

import java.util.Scanner;

public class ProdutoMain {

    public static void main(String[] args) {

        getAuthor();

        String div = "-----------------------------------------";
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos produtos deseja cadastrar? ");
        int quantidade = sc.nextInt();
        sc.nextLine();

        Produto[] produtos = new Produto[quantidade];

        for (int i = 0; i < produtos.length; i++) {

            System.out.println();
            System.out.println(div);
            System.out.println("Cadastro Produto " + (i + 1));
            System.out.println(div);

            Produto produto = new Produto();

            System.out.print("Nome: ");
            produto.setNome(sc.nextLine());

            System.out.print("Quantidade: ");
            produto.setQuantidade(sc.nextInt());

            System.out.print("Preço Unitário: R$ ");
            produto.setPreco(sc.nextDouble());

            sc.nextLine();

            produtos[i] = produto;
        }

        System.out.println();
        System.out.println("--------------- RELATÓRIO --------------");
        
        double totalEstoque = 0;

        for (Produto produto : produtos) {

            System.out.println(produto);

            totalEstoque += produto.getValorTotal();
        }

        System.out.println(div);
        System.out.printf("Valor Total do Estoque: R$ %.2f%n", totalEstoque);

        sc.close();

    }

    public static void getAuthor() {

        System.out.println("---------------------------------------");
        System.out.println("Author : Loester Botelho");
        System.out.println("---------------------------------------");
        System.out.println();

    }

}