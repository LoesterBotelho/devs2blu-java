package exercicios14102026parte0.oo.exercicio2;

import java.math.BigDecimal;

public class Entrega implements Rastreador {
	
    private final int id;
    private final String destinatario;
    private final Endereco endereco;
    private final double pesoKg;
    private final double distanciaKm;
    private final BigDecimal frete;

    private StatusEntrega status;
    private Veiculo veiculo;

    public Entrega(
            int id,
            String destinatario,
            Endereco endereco,
            double pesoKg,
            double distanciaKm) {

        if (id <= 0) {
            throw new IllegalArgumentException("ID invalido");
        }
        if (destinatario == null || destinatario.isBlank()) {
            throw new IllegalArgumentException("Destinatario obrigatorio");
        }
        if (endereco == null) {
            throw new IllegalArgumentException("Endereco obrigatorio");
        }
        if (!Double.isFinite(pesoKg) || pesoKg <= 0) {
            throw new IllegalArgumentException("Peso invalido");
        }
        if (!Double.isFinite(distanciaKm) || distanciaKm <= 0) {
            throw new IllegalArgumentException("Distancia invalida");
        }

        this.id = id;
        this.destinatario = destinatario;
        this.endereco = endereco;
        this.pesoKg = pesoKg;
        this.distanciaKm = distanciaKm;
        this.status = StatusEntrega.REGISTRADA;
        this.frete = BigDecimal.ZERO;
    }

    public int getId() {
        return id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public BigDecimal getFrete() {
        return veiculo == null
                ? frete
                : veiculo.calcularFrete(distanciaKm);
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void despachar(Veiculo veiculo) {
        if (status != StatusEntrega.REGISTRADA) {
            throw new IllegalStateException(
                    "Entrega nao pode ser despachada");
        }
        if (veiculo == null || !veiculo.suportaPeso(pesoKg)) {
            throw new IllegalArgumentException(
                    "Veiculo incompativel com o peso");
        }

        this.veiculo = veiculo;
        this.status = StatusEntrega.EM_TRANSITO;
    }

    public void confirmarEntrega() {
        if (status != StatusEntrega.EM_TRANSITO) {
            throw new IllegalStateException(
                    "Entrega nao esta em transito");
        }

        status = StatusEntrega.ENTREGUE;
    }

    public void cancelar() {
        if (status == StatusEntrega.ENTREGUE
                || status == StatusEntrega.CANCELADA) {
            throw new IllegalStateException(
                    "Entrega nao pode ser cancelada");
        }

        status = StatusEntrega.CANCELADA;
    }

    @Override
    public String rastrear() {
        return "Entrega #" + id
                + " | Status: " + status
                + " | Destinatario: " + destinatario
                + " | Endereco: " + endereco
                + " | Veiculo: "
                + (veiculo == null ? "Nao atribuido" : veiculo.getPlaca());
    }

    @Override
    public String toString() {
        return rastrear()
                + " | Peso: " + pesoKg + " kg"
                + " | Frete: R$ " + getFrete();
    }
    
}