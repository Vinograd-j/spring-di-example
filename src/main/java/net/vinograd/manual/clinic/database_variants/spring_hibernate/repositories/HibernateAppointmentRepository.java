package net.vinograd.manual.clinic.database_variants.spring_hibernate.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import net.vinograd.manual.clinic.database_variants.model.Appointment;
import net.vinograd.manual.clinic.database_variants.spring_hibernate.repository.AppointmentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateAppointmentRepository implements AppointmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void appoint(Appointment appointment) {
        entityManager.persist(appointment);
    }

}
