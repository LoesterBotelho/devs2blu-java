package exercicios21082026.collections;

import java.util.*;

public class GerenciadorEstoque {

    // 1. List: Mantém a ordem de inserção de todos os produtos cadastrados
    private List<Produto> listaProdutos = new ArrayList<>();

    // 2. Set: Garante unicidade de categorias ou nomes cadastrados (sem repetição)
    private Set<String> categoriasUnicas = new HashSet<>();

    // 3. Queue: Fila de atendimento de pedidos (FIFO - First In, First Out)
    private Queue<String> filaPedidos = new ArrayDeque<>();

    // 4. Map: Associa um ID (chave) diretamente a um Produto (valor) para busca O(1)
    private Map<Integer, Produto> mapaProdutos = new HashMap<>();

    public void adicionarProduto(Produto p, String categoria) {
        listaProdutos.add(p);
        categoriasUnicas.add(categoria);
        mapaProdutos.put(p.getId(), p);
    }

    public void adicionarPedido(String cliente) {
        filaPedidos.offer(cliente); // Adiciona na fila
    }

    // Métodos de exibição integrando Lambdas e Method References
    public void exibirListas() {
        System.out.println("\n--- [LIST] Todos os Produtos (ArrayList) ---");
        listaProdutos.forEach(System.out::println);

        System.out.println("\n--- [SET] Categorias Únicas (HashSet) ---");
        categoriasUnicas.forEach(c -> System.out.println("Categoria: " + c));

        System.out.println("\n--- [QUEUE] Fila de Pedidos Pendentes (ArrayDeque) ---");
        filaPedidos.forEach(pedido -> System.out.println("Aguardando atendimento: " + pedido));

        System.out.println("\n--- [MAP] Consulta por ID (HashMap) ---");
        mapaProdutos.forEach((id, prod) -> System.out.println("ID Chave: " + id + " -> " + prod.getNome()));
    }
    
    public Produto buscarNoMapa(int id) {
        return mapaProdutos.get(id);
    }
}