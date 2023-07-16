package net.vinograd.manual.clinic.local.repositories;

import net.vinograd.manual.model.Patient;
import net.vinograd.manual.clinic.repository.PatientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocalPatientRepository implements PatientRepository {

    private final List<Patient> patients;

    public LocalPatientRepository() {
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