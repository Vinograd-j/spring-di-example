package net.vinograd.manual.clinic.local_variants.local_spring.service;

import net.vinograd.manual.clinic.local_variants.repository.AppointmentRepository;
import net.vinograd.manual.clinic.local_variants.service.ReceptionService;
import net.vinograd.manual.clinic.local_variants.model.Doctor;
import net.vinograd.manual.clinic.local_variants.model.Patient;
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
