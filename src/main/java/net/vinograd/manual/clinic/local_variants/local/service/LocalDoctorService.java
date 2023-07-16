package net.vinograd.manual.clinic.local_variants.local.service;

import net.vinograd.manual.clinic.local_variants.repository.AppointmentRepository;
import net.vinograd.manual.clinic.local_variants.service.DoctorService;
import net.vinograd.manual.clinic.local_variants.model.Doctor;

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
