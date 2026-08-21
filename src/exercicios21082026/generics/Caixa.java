package exercicios21082026.generics;

//A classe aceita qualquer tipo T
public class Caixa<T> {
 private T conteudo;

 public void guardar(T conteudo) {
     this.conteudo = conteudo;
 }

 public T abrir() {
     return conteudo;
 }
}