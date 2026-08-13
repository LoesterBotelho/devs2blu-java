package exercicios12082026parte0.oo.exercicio4;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("Loester Botelho", 3577.75);

        EnvioService envioService = new EnvioService();
        NotaFiscalService notaFiscalService = new NotaFiscalService();
 
        notaFiscalService.gerarNotaFiscal(pedido);
        envioService.enviarPedido(pedido, "Rua Heinrich Hosang, 605, Blumenau - SC");
    }
}