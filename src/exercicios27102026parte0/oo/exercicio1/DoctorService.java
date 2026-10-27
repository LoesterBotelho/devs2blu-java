package exercicios27102026parte0.oo.exercicio1;

import java.util.Comparator;
import java.util.List;

public class DoctorService {

    private final DoctorRepository repository;

    public DoctorService(DoctorRepository repository) {
        this.repository = repository;
    }

    public Doctor register(Doctor doctor) {
        return repository.save(doctor);
    }

    public Doctor findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Doctor not found: " + id));
    }

    public List<Doctor> findAll() {
        return repository.findAll()
                .stream()
                .sorted(Comparator.comparing(Doctor::getName))
                .toList();
    }

    public List<Doctor> findBySpecialty(MedicalSpecialty specialty) {
        return repository.findAll()
                .stream()
                .filter(doctor -> doctor.getSpecialty() == specialty)
                .sorted(Comparator.comparing(Doctor::getName))
                .toList();
    }

    public List<Doctor> findWithinBudget(java.math.BigDecimal maximumPrice) {
        return repository.findAll()
                .stream()
                .filter(doctor -> doctor.getConsultationPrice()
                        .compareTo(maximumPrice) <= 0)
                .sorted(Comparator.comparing(Doctor::getConsultationPrice))
                .toList();
    }
    
}