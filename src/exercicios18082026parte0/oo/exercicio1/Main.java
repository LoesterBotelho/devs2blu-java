package exercicios18082026parte0.oo.exercicio1;

public class Main {
    public static void main(String[] args) {
        RelatorioSistema relatorio = new RelatorioSistema("Sistema Executando");
        relatorio.gerar();

        Funcionario f1 = new Gerente("Ana", 5000.0, "admin");
        Funcionario f2 = new Desenvolvedor("Bruno", 4000.0, 10);
        Tributavel c1 = new ClientePJ("Tech Corp", 50000.0);

        ProcessadorPagamento processador = new ProcessadorPagamento();

        processador.processar(f1);
        f1.registrarPonto();
        f1.registrarPonto("08:30");

        System.out.println("---------------------------------------------------------------------------");
        
        processador.processar(f2);
        f2.registrarPonto();

        System.out.println("---------------------------------------------------------------------------");

        processador.processar(c1);

        System.out.println("---------------------------------------------------------------------------");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
        System.out.println(c1.toString());
    }
}