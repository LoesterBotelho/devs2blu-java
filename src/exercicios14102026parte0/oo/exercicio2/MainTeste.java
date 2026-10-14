package exercicios14102026parte0.oo.exercicio2;

public class MainTeste {

    public static void main(String[] args) {

    	TransportadoraService transportadora =
                new TransportadoraService();

        Van van = new Van("ABC1D23");
        Caminhao caminhao = new Caminhao("XYZ4E56");
        
        transportadora.adicionarVeiculo(van);
        transportadora.adicionarVeiculo(caminhao);

        Endereco endereco1 = new Endereco(
                "Rua XV de Novembro", "Blumenau", "SC", "89010-000");

        Endereco endereco2 = new Endereco(
                "Rua das Palmeiras", "Joinville", "SC", "89201-000");

        Endereco endereco3 = new Endereco(
                "Avenida Brasil", "Curitiba", "PR", "80010-000");

        Entrega entrega1 = new Entrega(
                1, "Ana Silva", endereco1, 25.0, 15.0);

        Entrega entrega2 = new Entrega(
                2, "Carlos Souza", endereco2, 900.0, 120.0);

        Entrega entrega3 = new Entrega(
                3, "Maria Costa", endereco3, 5000.0, 200.0);

        transportadora.registrarEntrega(entrega1);
        transportadora.registrarEntrega(entrega2);
        transportadora.registrarEntrega(entrega3);

        transportadora.despacharEntrega(1, van.getPlaca());
        transportadora.despacharEntrega(2, caminhao.getPlaca());

        entrega1.confirmarEntrega();

        System.out.println("FROTA");
        transportadora.listarVeiculos().forEach(System.out::println);

        System.out.println("\nENTREGAS");
        transportadora.listarEntregas().forEach(System.out::println);

        System.out.println("\nENTREGAS EM TRANSITO");
        transportadora.listarPorStatus(StatusEntrega.EM_TRANSITO)
                .forEach(System.out::println);

        System.out.println("\nVEICULOS PARA CARGA DE 1000 KG");
        transportadora.listarVeiculosPorCapacidade(1000.0)
                .forEach(System.out::println);

        System.out.println("\nRASTREAMENTO");
        transportadora.buscarEntrega(2)
                .ifPresent(entrega -> System.out.println(entrega.rastrear()));

        System.out.println("\nRESUMO");
        System.out.println("Veiculos: "
                + transportadora.quantidadeVeiculos());

        System.out.println("Entregas: "
                + transportadora.quantidadeEntregas());

        System.out.println("Entregues: "
                + transportadora.contarEntregas(StatusEntrega.ENTREGUE));

        System.out.println("Em transito: "
                + transportadora.contarEntregas(StatusEntrega.EM_TRANSITO));

        System.out.println("Frete total entregue: R$ "
                + transportadora.calcularFreteTotalEntregue());
    }
    
}