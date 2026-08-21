package exercicios21082026.generics;

class ParImpar<K, V> implements Par<K, V> {
    private K chave;
    private V valor;

    public ParImpar(K chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public K getChave() { return chave; }
    public V getValor() { return valor; }
}
