package pratica.orientacaoobjetos.ex01;

public class Endereco {

	private final String rua;
	private final String numero;
	private final String bairro;
	private final String cidade;
	private final String estado;
	private final String cep;

	public Endereco(String rua, String numero, String bairro, String cidade, String estado, String cep) {

		this.rua = validarCampo(rua, "Rua");
		this.numero = validarCampo(numero, "Número");
		this.bairro = validarCampo(bairro, "Bairro");
		this.cidade = validarCampo(cidade, "Cidade");
		this.estado = validarCampo(estado, "Estado");
		this.cep = validarCampo(cep, "CEP");
	}

	public String obterEnderecoCompleto() {

		return String.format("%s, %s - %s - %s/%s - CEP: %s", rua, numero, bairro, cidade, estado, cep);

	}

	public String getRua() {

		return rua;

	}

	public String getNumero() {

		return numero;

	}

	public String getBairro() {

		return bairro;

	}

	public String getCidade() {

		return cidade;

	}

	public String getEstado() {

		return estado;

	}

	public String getCep() {

		return cep;

	}

	private String validarCampo(String valor, String campo) {

		if (valor == null || valor.isBlank()) {

			throw new IllegalArgumentException(campo + " obrigatório");
		}

		return valor;
	}
}