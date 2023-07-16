package net.vinograd.manual.clinic.local_variants.local_spring.repositories;

import net.vinograd.manual.clinic.local_variants.repository.PatientRepository;
import net.vinograd.manual.clinic.local_variants.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LocalSpringPatientRepository implements PatientRepository {

    private final List<Patient> patients;

    public LocalSpringPatientRepository() {
        patients = new ArrayList<>();
    }

    @Override
    public void save(Patient patient) {
        if(!patients.contains(patient))
            patients.add(patient);
    }

    @Override
    public List<Patient> findByName(String name) {
        return patients.stream().filter(patient -> patient.getFirstName().equals(name) || patient.getLastName().equals(name)).collect(Collectors.toList());
    }

    @Override
    public Optional<Patient> findById(int id) {
        return patients.stream().filter(patient -> patient.getId() == id).findFirst();
    }

}