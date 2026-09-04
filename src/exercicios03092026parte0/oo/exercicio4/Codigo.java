package exercicios03092026parte0.oo.exercicio4;

class Codigo<T, U> {
	private T parte1;
	private U parte2;

	public Codigo(T parte1, U parte2) {
		this.parte1 = parte1;
		this.parte2 = parte2;
	}

	@Override
	public String toString() {
		return "" + parte1 + parte2;
	}
}