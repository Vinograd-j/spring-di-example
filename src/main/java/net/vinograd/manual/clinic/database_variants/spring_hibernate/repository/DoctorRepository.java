package net.vinograd.manual.clinic.database_variants.spring_hibernate.repository;

import net.vinograd.manual.clinic.database_variants.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository {

    void save(Doctor doctor);

    Optional<Doctor> findById(int id);

    List<Doctor> findByName(String name);

}
