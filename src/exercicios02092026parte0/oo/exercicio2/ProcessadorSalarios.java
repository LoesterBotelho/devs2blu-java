package exercicios02092026parte0.oo.exercicio2;

import java.util.List;

class ProcessadorSalarios {

    // Wildcard com Limite Inferior (<? super Double>): Aceita Double ou classes superiores (como Number ou Object).
    // Exemplo em texto: É como uma caixa de doações rotulada "Dinheiro ou itens gerais", onde você tem permissão para colocar (adicionar) novos valores.
    public static void adicionarBonusExtra(List<? super Double> listaBonus, Double extra) {
        listaBonus.add(extra);
    }

    // Wildcard irrestrito (<?>): Aceita qualquer tipo de lista para inspeção básica.
    // Exemplo em texto: É como olhar para uma prateleira genérica apenas para contar quantas caixas existem, sem abrir nenhuma delas.
    public static void contarRegistros(List<?> lista) {
        System.out.println("Total de registros na lista: " + lista.size());
    }
}