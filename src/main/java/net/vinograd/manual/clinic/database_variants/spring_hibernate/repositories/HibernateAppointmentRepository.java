package net.vinograd.manual.clinic.database_variants.spring_hibernate.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.vinograd.manual.clinic.database_variants.model.Appointment;
import net.vinograd.manual.clinic.database_variants.model.Doctor;
import net.vinograd.manual.clinic.database_variants.model.Patient;
import net.vinograd.manual.clinic.database_variants.spring_hibernate.repository.AppointmentRepository;
import net.vinograd.manual.clinic.database_variants.spring_hibernate.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Component
@Repository
public class HibernateAppointmentRepository implements AppointmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void appoint(Appointment appointment) {
        entityManager.persist(appointment);
    }

    @Override
    public Optional<Patient> take(Doctor doctor) {

        String query = "DELETE FROM appointment a WHERE a.time = (SELECT MIN(a2.time) FROM appointment a2 WHERE a2.doctor_id = :doctor_id) RETURNING a.patient_id;";

        TypedQuery<Integer> typedQuery = entityManager.createQuery(query, Integer.class);
        typedQuery.setParameter("doctor_id", doctor.getId());

        return patientRepository.findById(typedQuery.getSingleResult());
    }


}
