package exercicios12082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

	private static final double DESCONTO_FIXO_CLIENTE_ANTIGO = 0.1;  // 10/100 = 10%; 
	
	private Integer idCliente;
	private String nome;
	private String cpf;
	private String endereco;
	private List<Aluguel> listaAlugueisPago;
	private Boolean ehClienteNovo = true;
	private Boolean jahFezPedidosAntes = false;

	public Cliente() {
		this.listaAlugueisPago = new ArrayList<Aluguel>();
		this.ehClienteNovo = true;
		this.jahFezPedidosAntes = false;
	}

	public Cliente(String nome, String cpf, String endereco) {
		this();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public Cliente(String nome, String cpf, String endereco, List<Aluguel> listaAlugueisPago) {
		this();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.listaAlugueisPago = listaAlugueisPago;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Aluguel> getListaAlugueisPago() {
		return listaAlugueisPago;
	}

	public void setListaAlugueisPago(List<Aluguel> listaAlugueisPago) {
		this.listaAlugueisPago = listaAlugueisPago;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Boolean getEhClienteNovo() {
		return ehClienteNovo;
	}

	public void setEhClienteNovo(Boolean ehClienteNovo) {
		this.ehClienteNovo = ehClienteNovo;
	}

	public Boolean getJahFezPedidosAntes() {
		return jahFezPedidosAntes;
	}

	public void setJahFezPedidosAntes(Boolean jahFezPedidosAntes) {
		this.jahFezPedidosAntes = jahFezPedidosAntes;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco
				+ ", listaAlugueisPago=" + listaAlugueisPago + ", ehClienteNovo=" + ehClienteNovo
				+ ", jahFezPedidosAntes=" + jahFezPedidosAntes + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(idCliente, other.idCliente);
	}

}
