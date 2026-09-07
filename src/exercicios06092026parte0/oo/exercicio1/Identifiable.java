package exercicios06092026parte0.oo.exercicio1;

sealed interface Identifiable<ID> permits User, Product {
    ID id();
}
