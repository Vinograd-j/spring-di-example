package net.vinograd.manual.clinic.local_spring.service;

import net.vinograd.manual.clinic.repository.AppointmentRepository;
import net.vinograd.manual.clinic.service.DoctorService;
import net.vinograd.manual.model.Doctor;
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
