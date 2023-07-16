package net.vinograd.manual.clinic.repository;

import net.vinograd.manual.model.Doctor;
import net.vinograd.manual.model.Patient;

import java.util.Optional;

public interface AppointmentRepository {

    void appoint(Patient patient, Doctor doctor);

    Optional<Patient> take(Doctor doctor);

}
