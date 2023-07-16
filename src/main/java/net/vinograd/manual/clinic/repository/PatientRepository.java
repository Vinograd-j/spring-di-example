package net.vinograd.manual.clinic.repository;

import net.vinograd.manual.model.Patient;

import java.util.List;
import java.util.Optional;

public interface PatientRepository {

    void save(Patient patient);

    List<Patient> findByName(String name);

    Optional<Patient> findById(int id);


}
