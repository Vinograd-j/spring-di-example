package net.vinograd.manual.clinic.database_variants.service;

import net.vinograd.manual.clinic.database_variants.model.Appointment;
import net.vinograd.manual.clinic.database_variants.model.Doctor;
import net.vinograd.manual.clinic.database_variants.model.Patient;
import net.vinograd.manual.clinic.database_variants.spring_hibernate.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReceptionService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public void createAnAppointment(Patient patient, Doctor doctor){
        appointmentRepository.appoint(new Appointment(patient, doctor, LocalDateTime.now()));
    }

}
