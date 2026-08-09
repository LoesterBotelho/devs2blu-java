package exercicios09082026parte1.oo;

public interface Reportable {

    void generateReport();

    default void printReportHeader() {
        System.out.println("----------------------------");
        System.out.println("Author : Loester Botelho    ");
        System.out.println("----------------------------");
        System.out.println("========== REPORT ==========");
    }
}