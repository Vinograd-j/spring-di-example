package net.vinograd.manual.clinic.local_variants.service;

import net.vinograd.manual.clinic.local_variants.model.Doctor;
import net.vinograd.manual.clinic.local_variants.model.Patient;

public interface ReceptionService {

    void createAnAppointment(Patient patient, Doctor doctor);

}
