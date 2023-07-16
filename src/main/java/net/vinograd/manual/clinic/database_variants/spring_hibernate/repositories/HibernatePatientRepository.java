package net.vinograd.manual.clinic.database_variants.spring_hibernate.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.vinograd.manual.clinic.database_variants.model.Doctor;
import net.vinograd.manual.clinic.database_variants.model.Patient;
import net.vinograd.manual.clinic.database_variants.spring_hibernate.repository.PatientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernatePatientRepository implements PatientRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Patient patient) {
        entityManager.persist(patient);
    }

    @Override
    public Optional<Patient> findById(int id) {
        return Optional.ofNullable(entityManager.find(Patient.class, id));
    }

    @Override
    public List<Patient> findByName(String name) {
        TypedQuery<Patient> query = entityManager.createQuery("SELECT patient FROM Patient WHERE patient.first_name LIKE : %name% OR patient.last_name LIKE : %name%", Patient.class);
        query.setParameter("name", name);

        return query.getResultList();
    }
}
