package exercicios14082026parte0.oo.exercicio1;

public interface PagamentoService<T> {

	void processarPagamento(T t);
	double calcularTaxa(T t);
	
}