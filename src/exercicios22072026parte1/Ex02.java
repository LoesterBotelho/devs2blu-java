package exercicios22072026parte1;

public class Ex02 {

	private int idade;

	public Ex02() { }

	public Ex02(int idade) {
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public String getClassificacao() {
		
		String classificacao = "";
		
		if ( (this.idade >= 5) && (this.idade <= 7) ) {
			classificacao = "Infantil A";
		} else if ( (this.idade >= 8) && (this.idade <= 10) ) {
			classificacao = "Infantil B";
		} else if ( (this.idade >= 11) && (this.idade <= 13) ) {
			classificacao = "Juvenil A";
		} else if ( (this.idade >= 14) && (this.idade <= 17) ) {
			classificacao = "Juvenil B";
		} else if (this.idade >= 18) {
			classificacao = "Adulto";
		}
		
		return classificacao;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Ex02 [idade=" + idade +
				" ,classificacao=" + this.getClassificacao() + 
				"]";
	}
}
