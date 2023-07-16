package net.vinograd.manual.clinic.local_spring.service;

import net.vinograd.manual.clinic.repository.AppointmentRepository;
import net.vinograd.manual.clinic.service.ReceptionService;
import net.vinograd.manual.model.Doctor;
import net.vinograd.manual.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocalSpringReceptionService implements ReceptionService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void createAnAppointment(Patient patient, Doctor doctor) {
        appointmentRepository.appoint(patient, doctor);

        System.out.println("Patient: " + patient.getFirstName() + " " + patient.getLastName() + " appointed to doctor: "+ doctor.getFirstName() + " " + doctor.getLastName() + " " + doctor.getSpecialty().name());

    }

}
