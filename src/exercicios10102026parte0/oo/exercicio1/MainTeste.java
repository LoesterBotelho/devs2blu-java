package exercicios10102026parte0.oo.exercicio1;

public class MainTeste {

    public static void main(String[] args) {

    	Repositorio<Pessoa> repositorio = new Repositorio<>();

        repositorio.adicionar(new Pessoa("Ana", 25));
        repositorio.adicionar(new Aluno("Carlos", 20, "A001"));
        repositorio.adicionar(new Aluno("Maria", 17, "A002"));

        System.out.println("\nPESSOAS\n");
        repositorio.listar().forEach(System.out::println);

        System.out.println("\nMAIORES DE IDADE\n");
        repositorio.filtrar(pessoa -> pessoa.getIdade() >= 18)
                .forEach(System.out::println);

        System.out.println("\nPRIMEIRA PESSOA\n");
        repositorio.primeiro().ifPresent(System.out::println);

        System.out.println("\nTotal: " + repositorio.tamanho());
    }
    
}