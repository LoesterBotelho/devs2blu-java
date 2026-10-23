package exercicios23102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Inventario {

    private final List<Item> itens = new ArrayList<>();
    private Arma armaEquipada;

    public void adicionar(Item item) {
        itens.add(item);
        System.out.println("Item adicionado: " + item.getNome());
    }

    public boolean remover(Long id) {
        boolean removido = itens.removeIf(
                item -> item.getId().equals(id)
        );

        if (removido && armaEquipada != null
                && armaEquipada.getId().equals(id)) {
            armaEquipada = null;
        }

        return removido;
    }

    public List<Item> listarTodos() {
        return List.copyOf(itens);
    }

    public Optional<Arma> armaEquipada() {
        return Optional.ofNullable(armaEquipada);
    }

    public boolean equiparArma(Long id) {
        Optional<Arma> arma = itens.stream()
                .filter(Arma.class::isInstance)
                .map(Arma.class::cast)
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (arma.isEmpty()) {
            return false;
        }

        armaEquipada = arma.get();

        System.out.println(
                "Arma equipada: " + armaEquipada.getNome()
        );

        return true;
    }

    public boolean usarPocao(Long id, Personagem personagem) {
        Optional<Pocao> pocao = itens.stream()
                .filter(Pocao.class::isInstance)
                .map(Pocao.class::cast)
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (pocao.isEmpty()) {
            return false;
        }

        pocao.get().usar(personagem);
        remover(id);

        return true;
    }

    public int quantidade() {
        return itens.size();
    }

    public List<Item> filtrarPorRaridade(Raridade raridade) {
        return itens.stream()
                .filter(item -> item.getRaridade() == raridade)
                .toList();
    }
}