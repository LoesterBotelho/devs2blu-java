package exercicios24102026parte0.oo.exercicio1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class AnimalService {
    private final RepositorioAnimais repositorio;

    public AnimalService(RepositorioAnimais repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrar(Animal animal) {
        repositorio.salvar(animal);
        animal.getTutor().adicionarAnimal(animal);
    }

    public List<Animal> listarPorEspecie(Especie especie) {
        return repositorio.listarTodos().stream()
                .filter(animal -> animal.getEspecie() == especie)
                .toList();
    }

    public List<Animal> pesquisar(Predicate<Animal> criterio) {
        return repositorio.listarTodos().stream()
                .filter(criterio)
                .sorted(Comparator.comparing(Animal::getNome))
                .toList();
    }
    
}