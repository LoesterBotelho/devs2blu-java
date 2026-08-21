package exercicios21082026.generics;

//O T deve ser obrigatoriamente um Number (ou subclasse como Integer, Double)
public class Calculadora<T extends Number> {
 private T numero1;
 private T numero2;

 public Calculadora(T numero1, T numero2) {
     this.numero1 = numero1;
     this.numero2 = numero2;
 }

 public double somar() {
     // Podemos usar métodos de Number graças ao 'extends Number'
     return numero1.doubleValue() + numero2.doubleValue();
 }
}
