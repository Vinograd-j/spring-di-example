package net.vinograd.manual.clinic.local_variants.local_spring.service;

import net.vinograd.manual.clinic.local_variants.repository.AppointmentRepository;
import net.vinograd.manual.clinic.local_variants.service.DoctorService;
import net.vinograd.manual.clinic.local_variants.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocalSpringDoctorService implements DoctorService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void observePatient(Doctor doctor) {
        appointmentRepository.take(doctor).ifPresentOrElse(
            patient ->
                System.out.println("Observe patient: "+patient.getFirstName() + " " + patient.getLastName()),

            () ->
                System.out.println("Queue is empty. I go to sleep...")
        );
    }
}
