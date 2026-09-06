package exercicios05092026parte0.oo.exercicio2;

import java.util.Objects;

class Produto implements Identificavel {
	private static Integer CONTADOR_ID = 0;
	private int id;
	private String nome;
	private double preco;

	
	public Produto() {
		CONTADOR_ID++;
	}

	public Produto(String nome, double preco) {
		this();
		this.id = CONTADOR_ID;
		this.nome = nome;
		this.preco = preco;
	}

	@Override
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

    @Override
    public String toString() {
        return "Produto { id=" + id + 
        		", nome='" + nome + 
        		"', preco=R$ " + preco + 
        		" }";
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
		Produto other = (Produto) obj;
		return id == other.id;
	}
    
    
}