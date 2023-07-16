package net.vinograd.manual.clinic.service;

import net.vinograd.manual.model.Doctor;
import net.vinograd.manual.model.Patient;

public interface ReceptionService {

    void createAnAppointment(Patient patient, Doctor doctor);

}
