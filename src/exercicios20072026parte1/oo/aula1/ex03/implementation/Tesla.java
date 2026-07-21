package exercicios20072026parte1.oo.aula1.ex03.implementation;

public final class Tesla extends CarroEletrico {

    public Tesla(String modelo, int ano) {
        super(modelo, ano);
    }

    @Override
    public void exibirInfo() {
        System.out.println("[TESLA PREMIUM]");
        super.exibirInfo();
    }
}