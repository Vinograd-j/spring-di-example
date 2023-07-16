package net.vinograd.manual.clinic.local.service;

import net.vinograd.manual.clinic.repository.AppointmentRepository;
import net.vinograd.manual.clinic.service.DoctorService;
import net.vinograd.manual.model.Doctor;

public class LocalDoctorService implements DoctorService {

    private final AppointmentRepository appointmentRepository;

    public LocalDoctorService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

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
