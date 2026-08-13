package exercicios12082026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente {

	private static final double DESCONTO_FIXO_CLIENTE_ANTIGO = 0.1; // 10/100 = 10%;

	// Variável estática compartilhada entre todos os clientes para gerar o ID sequencial
	private static int contadorId = 1;
	
	private Integer id;
	private String nome;
	private String cpf;
	private String endereco;
	private List<Aluguel> listaAlugueisPago;
	private Boolean ehClienteNovo = true;
	private Boolean jahFezPedidosAntes = false;

	public Cliente() {
		this.id = contadorId++; // Atribui o ID atual e incrementa para o próximo		
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
		return id;
	}

	public void setIdCliente(Integer idCliente) {
		this.id = idCliente;
	}

	public void adicionarAluguel(Aluguel aluguel) {
		this.listaAlugueisPago.add(aluguel);
		this.ehClienteNovo = false;
		this.jahFezPedidosAntes = true;
	}

	public double aplicarDesconto(double valorOriginal) {
		if (this.jahFezPedidosAntes) {
			return valorOriginal * (1 - DESCONTO_FIXO_CLIENTE_ANTIGO);
		}
		return valorOriginal;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", endereco=" + endereco
				+ ", listaAlugueisPago=" + listaAlugueisPago + ", ehClienteNovo=" + ehClienteNovo
				+ ", jahFezPedidosAntes=" + jahFezPedidosAntes + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}
}