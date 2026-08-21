package exercicios21082026.lambda;

//Anotação opcional, mas recomendada para segurança de compilação
@FunctionalInterface
interface OperacaoMatematica {
 int calcular(int a, int b); // Único método abstrato
}