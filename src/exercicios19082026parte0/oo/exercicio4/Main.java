package exercicios19082026parte0.oo.exercicio4;

public class Main {

    public static void main(String[] args) {

        Aviao aviao = new Aviao(
                "737",
                "Boeing",
                180,
                12000,
                2,
                "Querosene",
                "LATAM",
                "Comercial",
                35.8);

        Onibus onibus = new Onibus(
                "Paradiso",
                "Marcopolo",
                50,
                6,
                "Diesel",
                "Branco",
                "Linha 500",
                "Blumenau Transportes",
                true);

        Automovel automovel = new Automovel(
                "Civic",
                "Honda",
                5,
                4,
                "Gasolina",
                "Preto",
                "ABC-1234",
                "Sedan",
                4);

        aviao.mover();
        onibus.mover();
        automovel.mover();

        System.out.println(aviao);
        System.out.println(onibus);
        System.out.println(automovel);
    }
}