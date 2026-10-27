package exercicios27102026parte0.oo.exercicio1;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class PatientService {

    private final PatientRepository repository;

    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient register(Patient patient) {
        return repository.save(patient);
    }

    public Patient findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Patient not found: " + id));
    }

    public List<Patient> findAll() {
        return repository.findAll();
    }

    public List<Patient> searchByName(String name) {
        String search = name.toLowerCase(Locale.ROOT);

        return repository.findAll()
                .stream()
                .filter(patient -> patient.getName()
                        .toLowerCase(Locale.ROOT)
                        .contains(search))
                .sorted(Comparator.comparing(Patient::getName))
                .toList();
    }

    public List<Patient> findAdults() {
        return repository.findAll()
                .stream()
                .filter(patient -> patient.getAge() >= 18)
                .sorted(Comparator.comparingInt(Patient::getAge).reversed())
                .toList();
    }

    public boolean delete(long id) {
        return repository.deleteById(id);
    }
    
}