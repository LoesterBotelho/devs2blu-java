package exercicios25102026parte0.oo.exercicio1;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class RelatorioLogistica {
    public List<Encomenda> filtrarPorStatus(
            List<Encomenda> encomendas,
            StatusEntrega status) {

        return encomendas.stream()
                .filter(e -> e.getStatus() == status)
                .toList();
    }

    public List<Encomenda> ordenarPorFrete(
            List<Encomenda> encomendas) {

        return encomendas.stream()
                .sorted(Comparator.comparing(Encomenda::getValorFrete))
                .toList();
    }

    public List<Encomenda> filtrar(
            List<Encomenda> encomendas,
            Predicate<Encomenda> criterio) {

        return encomendas.stream()
                .filter(criterio)
                .toList();
    }

    public BigDecimal calcularFaturamento(
            List<Encomenda> encomendas) {

        return encomendas.stream()
                .filter(e -> e.getStatus() == StatusEntrega.ENTREGUE)
                .map(Encomenda::getValorFrete)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public long contarPorStatus(
            List<Encomenda> encomendas,
            StatusEntrega status) {

        return encomendas.stream()
                .filter(e -> e.getStatus() == status)
                .count();
    }

    public void imprimir(List<Encomenda> encomendas) {
        encomendas.forEach(e -> System.out.printf(
                "ID: %s | Cliente: %s | Status: %s | Frete: R$ %s%n",
                e.getId(),
                e.getCliente().getNome(),
                e.getStatus(),
                e.getValorFrete().toPlainString()));
    }
    
}