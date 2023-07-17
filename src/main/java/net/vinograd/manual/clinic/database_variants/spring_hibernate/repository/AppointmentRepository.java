package net.vinograd.manual.clinic.database_variants.spring_hibernate.repository;

import net.vinograd.manual.clinic.database_variants.model.Appointment;
import net.vinograd.manual.clinic.database_variants.model.Doctor;
import net.vinograd.manual.clinic.database_variants.model.Patient;

import java.util.Optional;

public interface AppointmentRepository {

    void appoint(Appointment appointment);

    Optional<Patient> take(Doctor doctor);

}
