package net.vinograd.manual.clinic.local_variants.repository;

import net.vinograd.manual.clinic.local_variants.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository {

    void save(Doctor doctor);

    List<Doctor> findByName(String name);

    Optional<Doctor> findById(int id);

}
