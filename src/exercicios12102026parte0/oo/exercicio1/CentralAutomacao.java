package exercicios12102026parte0.oo.exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CentralAutomacao<T extends Dispositivo> {
	
    private final List<T> dispositivos = new ArrayList<>();  

    public void adicionar(T dispositivo) {
        dispositivos.add(dispositivo);
    }

    public List<T> listar() {
        return List.copyOf(dispositivos);
    }

    public List<T> listarLigados() {
        return dispositivos.stream()
                .filter(Dispositivo::isLigado)
                .toList();
    }

    public Optional<T> buscarPorNome(String nome) {
        return dispositivos.stream()
                .filter(dispositivo -> dispositivo.getNome().equalsIgnoreCase(nome))
                .findFirst();
    }

    public void ligarTodos() {
        dispositivos.forEach(Dispositivo::ligar);
    }

    public long contarLigados() {
        return dispositivos.stream()
                .filter(Dispositivo::isLigado)
                .count();
    }
    
}