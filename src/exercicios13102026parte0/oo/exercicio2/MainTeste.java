package exercicios13102026parte0.oo.exercicio2;

public class MainTeste {

    public static void main(String[] args) {

    	EstacaoMonitoramento<Sensor> estacao =
                new EstacaoMonitoramento<>("Estacao Blumenau");

        SensorTemperatura temperatura1 =
                new SensorTemperatura("T001", "Centro");

        SensorTemperatura temperatura2 =
                new SensorTemperatura("T002", "Velha");

        SensorUmidade umidade1 =
                new SensorUmidade("U001", "Centro");

        temperatura1.registrarMedicao(25.5);
        temperatura1.registrarMedicao(28.0);
        temperatura1.registrarMedicao(26.5);

        temperatura2.registrarMedicao(22.0);
        temperatura2.registrarMedicao(24.0);

        umidade1.registrarMedicao(65.0);
        umidade1.registrarMedicao(72.0);
        umidade1.registrarMedicao(68.0);

        estacao.adicionarSensor(temperatura1);
        estacao.adicionarSensor(temperatura2);
        estacao.adicionarSensor(umidade1);

        System.out.println(" " + estacao.getNome() + " ");

        estacao.listarSensores().forEach(sensor -> {
            System.out.println(sensor);
            System.out.println("Media: " + sensor.calcularMedia());
        });

        System.out.println("\n SENSORES ORDENADOS PELA MEDIA ");

        estacao.ordenarPorMedia().forEach(sensor ->
                System.out.println(sensor.getIdentificador()
                        + " - " + sensor.calcularMedia()));

        System.out.println("\n BUSCAR SENSOR ");

        estacao.buscarPorIdentificador("T001")
                .ifPresent(System.out::println);

        System.out.println("\nTotal de sensores: "
                + estacao.contarSensores());
    }
}