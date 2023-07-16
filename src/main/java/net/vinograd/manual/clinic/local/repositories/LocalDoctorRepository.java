package net.vinograd.manual.clinic.local.repositories;

import net.vinograd.manual.model.Doctor;
import net.vinograd.manual.clinic.repository.DoctorRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocalDoctorRepository implements DoctorRepository {

    private final List<Doctor> doctors;

    public LocalDoctorRepository(){
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
