package net.vinograd.manual.clinic.local.service;

import net.vinograd.manual.clinic.repository.AppointmentRepository;
import net.vinograd.manual.clinic.service.ReceptionService;
import net.vinograd.manual.model.Doctor;
import net.vinograd.manual.model.Patient;

public class LocalReceptionService implements ReceptionService {

    private final AppointmentRepository appointmentRepository;

    public LocalReceptionService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void createAnAppointment(Patient patient, Doctor doctor) {
        appointmentRepository.appoint(patient, doctor);

        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName() + " appointed to doctor: "+ doctor.getFirstName() + " " + doctor.getLastName() + " " + doctor.getSpecialty().name());

    }

}
