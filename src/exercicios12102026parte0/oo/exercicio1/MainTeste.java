package exercicios12102026parte0.oo.exercicio1;

public class MainTeste {

    public static void main(String[] args) {

    	CentralAutomacao<Dispositivo> central = new CentralAutomacao<>();

        central.adicionar(new Lampada("Sala", 12));
        central.adicionar(new Lampada("Cozinha", 15));
        central.adicionar(new ArCondicionado("Quarto", 22.0));

        central.buscarPorNome("Sala").ifPresent(Dispositivo::ligar);
        central.buscarPorNome("Quarto").ifPresent(Dispositivo::ligar);

        System.out.println("TODOS OS DISPOSITIVOS");
        central.listar().forEach(dispositivo ->
                System.out.println(dispositivo.obterStatus()));

        System.out.println("\nDISPOSITIVOS LIGADOS");
        central.listarLigados().forEach(System.out::println);

        System.out.println("\nBUSCAR DISPOSITIVO");
        central.buscarPorNome("Cozinha")
                .ifPresent(System.out::println);

        System.out.println("\nTotal ligados: " + central.contarLigados());

        central.ligarTodos();

        System.out.println("\nTotal ligados após ligar todos: "
                + central.contarLigados());
    }
    
}