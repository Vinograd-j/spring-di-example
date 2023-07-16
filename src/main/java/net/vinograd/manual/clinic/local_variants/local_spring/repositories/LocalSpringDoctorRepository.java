package net.vinograd.manual.clinic.local_variants.local_spring.repositories;

import net.vinograd.manual.clinic.local_variants.repository.DoctorRepository;
import net.vinograd.manual.clinic.local_variants.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LocalSpringDoctorRepository implements DoctorRepository {

    private final List<Doctor> doctors;

    public LocalSpringDoctorRepository(){
        doctors = new ArrayList<>();
    }

    @Override
    public void save(Doctor doctor) {
        if(!doctors.contains(doctor))
            this.doctors.add(doctor);
    }

    @Override
    public List<Doctor> findByName(String name) {
        return doctors.stream().filter(doctor -> doctor.getFirstName().contains(name) || doctor.getLastName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public Optional<Doctor> findById(int id) {
        return doctors.stream().filter(doctor -> doctor.getId() == id).findFirst();
    }
}
