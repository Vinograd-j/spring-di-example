package net.vinograd.manual.clinic.database_variants.spring_hibernate.repository;

import net.vinograd.manual.clinic.database_variants.model.Appointment;

public interface AppointmentRepository {

    void appoint(Appointment appointment);

}
