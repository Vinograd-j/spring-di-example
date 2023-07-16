package net.vinograd.manual.clinic.repository;

import net.vinograd.manual.model.Doctor;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository {

    void save(Doctor doctor);

    List<Doctor> findByName(String name);

    Optional<Doctor> findById(int id);

}
