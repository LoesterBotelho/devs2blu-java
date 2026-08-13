package exercicios12082026parte0.oo.exercicio1;

import java.util.Objects;

public class Aluguel {

	// Variável estática compartilhada entre todos os clientes para gerar o ID sequencial
	private static int contadorId = 1;
	
	private int id;
	private String nomeTema;
	private String dataFesta;
	private String horaInicio;
	private String horaTermino;
	private double valorCobrado;
	private String endereco;
	private Cliente cliente;

	public Aluguel() {
		this.id = contadorId++; // Atribui o ID atual e incrementa para o próximo
	}

	public Aluguel(String nomeTema, String dataFesta, String horaInicio, String horaTermino, double valorCobrado, String endereco) {
		this();
		this.nomeTema = nomeTema;
		this.dataFesta = dataFesta;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.valorCobrado = valorCobrado;
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public double calcularValorFinal() {
		if (cliente != null) {
			return cliente.aplicarDesconto(this.valorCobrado);
		}
		return this.valorCobrado;
	}

	public String getNomeTema() {
		return nomeTema;
	}

	public void setNomeTema(String nomeTema) {
		this.nomeTema = nomeTema;
	}

	public String getDataFesta() {
		return dataFesta;
	}

	public void setDataFesta(String dataFesta) {
		this.dataFesta = dataFesta;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(String horaTermino) {
		this.horaTermino = horaTermino;
	}

	public double getValorCobrado() {
		return valorCobrado;
	}

	public void setValorCobrado(double valorCobrado) {
		this.valorCobrado = valorCobrado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Aluguel [id=" + id 
				+ ", tema=" + nomeTema 
				+ ", dataFesta=" + dataFesta 
				+ ", horaInicio=" + horaInicio 
				+ ", horaTermino=" + horaTermino 
				+ ", valorCobrado=" + valorCobrado 
				+ ", endereco=" + endereco 
				+ ", cliente=" + (cliente != null ? cliente.getNome() : "Não informado") + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(id));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluguel other = (Aluguel) obj;
		return id == other.id;
	}
}