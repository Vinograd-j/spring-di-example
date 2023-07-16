package net.vinograd.manual.clinic.database_variants.spring_hibernate.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import net.vinograd.manual.clinic.database_variants.model.Doctor;
import net.vinograd.manual.clinic.database_variants.spring_hibernate.repository.DoctorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateDoctorRepository implements DoctorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Doctor doctor) {
        entityManager.persist(doctor);
    }

    @Override
    public Optional<Doctor> findById(int id) {
        return Optional.ofNullable(entityManager.find(Doctor.class, id));
    }

    @Override
    public List<Doctor> findByName(String name) {

        TypedQuery<Doctor> query = entityManager.createQuery("SELECT doctor FROM Doctor WHERE doctor.first_name LIKE : %name% OR doctor.last_name LIKE : %name%", Doctor.class);
        query.setParameter("name", name);

        return query.getResultList();
    }
}
