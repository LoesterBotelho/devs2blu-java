package exercicios12092026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;

public class MainTestes {

    public static void main(String[] args) {
        System.out.println();

        Repositorio<Usuario, Long> repoUsuarios = new RepositorioEmMemoria<>();
        repoUsuarios.salvar(new Usuario(1L, "Ana Silva", "ana@email.com"));
        repoUsuarios.salvar(new Usuario(2L, "Carlos Souza", "carlos@email.com"));

        // -------------------------------------------------------------------------------------
        
        System.out.println("\n[Teste 1] Buscando Usuário ID 1:");
        repoUsuarios.buscarPorId(1L)
                .ifPresent(u -> System.out.println("Encontrado: " + u.nome()));

        // -------------------------------------------------------------------------------------
        
        Repositorio<Produto, String> repoProdutos = new RepositorioEmMemoria<>();
        repoProdutos.salvar(new Produto("P01", "Notebook Gamer", 4500.00));
        repoProdutos.salvar(new Produto("P02", "Mouse Sem Fio", 150.00));

        // -------------------------------------------------------------------------------------
        
        System.out.println("\n[Teste 2] Listando todos os Produtos:");
        repoProdutos.listarTodos()
                .forEach(p -> System.out.println("Produto: " + p.descricao() + " - R$ " + p.preco()));

        // -------------------------------------------------------------------------------------
               
        System.out.println("\n[Teste 3] Mapeando nomes de usuários:");
        List<String> nomes = repoUsuarios.transformar(Usuario::nome);
        nomes.forEach(n -> System.out.println("Nome mapeado: " + n));

        // -------------------------------------------------------------------------------------
        
        System.out.println("\n[Teste 4] Impressão genérica com Wildcard (PECS):");
        ProcessadorUtil.imprimirColecao(repoUsuarios.listarTodos());
        ProcessadorUtil.imprimirColecao(repoProdutos.listarTodos());
        
        // -------------------------------------------------------------------------------------
        
        System.out.println("\n[Teste 5] Testando adição com super wildcard:");
        List<Identifiable<?>> gerenciais = new ArrayList<>();
        List<Usuario> novosUsuarios = List.of(
                new Usuario(3L, "Beatriz Lima", "bia@email.com")
        );

        ProcessadorUtil.adicionarLote(gerenciais, novosUsuarios);

        System.out.println("Itens na lista genérica após adição: " + gerenciais.size());

        // -------------------------------------------------------------------------------------
    }
}