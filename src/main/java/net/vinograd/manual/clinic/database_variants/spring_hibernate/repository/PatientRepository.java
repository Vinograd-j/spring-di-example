package net.vinograd.manual.clinic.database_variants.spring_hibernate.repository;

import net.vinograd.manual.clinic.database_variants.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {

    void save(Patient patient);

    Optional<Patient> findById(int id);

    List<Patient> findByName(String name);

}
