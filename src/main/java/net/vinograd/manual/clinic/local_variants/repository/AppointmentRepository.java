package net.vinograd.manual.clinic.local_variants.repository;

import net.vinograd.manual.clinic.local_variants.model.Doctor;
import net.vinograd.manual.clinic.local_variants.model.Patient;

import java.util.Optional;

public interface AppointmentRepository {

    void appoint(Patient patient, Doctor doctor);

    Optional<Patient> take(Doctor doctor);

}
