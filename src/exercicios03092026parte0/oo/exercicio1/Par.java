package exercicios03092026parte0.oo.exercicio1;

class Par<K, V> {
	private K primeiro;
	private V segundo;

	public Par(K primeiro, V segundo) {
		this.primeiro = primeiro;
		this.segundo = segundo;
	}

	public K getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(K primeiro) {
		this.primeiro = primeiro;
	}

	public V getSegundo() {
		return segundo;
	}

	public void setSegundo(V segundo) {
		this.segundo = segundo;
	}

	@Override
	public String toString() {
		return "(" + primeiro + ", " + segundo + ")";
	}
}
