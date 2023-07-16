package net.vinograd.manual.clinic.local.app;

import net.vinograd.manual.clinic.local.repositories.LocalAppointmentRepository;
import net.vinograd.manual.clinic.local.repositories.LocalDoctorRepository;
import net.vinograd.manual.clinic.local.repositories.LocalPatientRepository;
import net.vinograd.manual.clinic.local.service.LocalDoctorService;
import net.vinograd.manual.clinic.local.service.LocalReceptionService;
import net.vinograd.manual.model.Doctor;
import net.vinograd.manual.model.Patient;

public class Application {

    static LocalDoctorRepository doctorRepository = new LocalDoctorRepository();
    static LocalPatientRepository patientRepository = new LocalPatientRepository();

    public static void main(String[] args) {



        Doctor firstDoctor = new Doctor(0, "Pasha", "Volya", Doctor.Specialty.DENTIST);
        Doctor secondDoctor = new Doctor(1, "Misha", "Huev", Doctor.Specialty.SURGEON);
        Doctor firdDoctor = new Doctor(2, "Arnold", "Schwarzenegger", Doctor.Specialty.TRAUMATOLOGIST);

        Patient firstPatient = new Patient(0, "I", "Ill");
        Patient secondPatient = new Patient(1, "He", "Will");
        Patient firdPatient = new Patient(2, "She", "Ill");


        doctorRepository.save(firstDoctor);
        doctorRepository.save(secondDoctor);
        doctorRepository.save(firdDoctor);

        patientRepository.save(firstPatient);
        patientRepository.save(secondPatient);
        patientRepository.save(firdPatient);

        simulate();

    }

    private static void simulate(){
        // -----------------------------------InitializeRepositories-----------------------
        LocalAppointmentRepository appointmentRepository = new LocalAppointmentRepository();

        LocalDoctorService doctorService = new LocalDoctorService(appointmentRepository);
        LocalReceptionService receptionService = new LocalReceptionService(appointmentRepository);

        // -----------------------------------GettingDoctors and Patients------------------
        Doctor firstDoctor = doctorRepository.findById(0).orElseThrow();
        Doctor secondDoctor = doctorRepository.findById(1).orElseThrow();
        Doctor firdDoctor = doctorRepository.findById(2).orElseThrow();

        Patient firstPatient = patientRepository.findByName("I").stream().findFirst().orElseThrow();
        Patient secondPatient = patientRepository.findByName("Will").stream().findFirst().orElseThrow();
        Patient firdPatient = patientRepository.findByName("Ill").stream().filter(patient -> patient.getFirstName().equals("She")).findFirst().orElseThrow();
        // -----------------------------------Some tests)-----------------------------------
        receptionService.createAnAppointment(firdPatient, firstDoctor);

        doctorService.observePatient(firstDoctor);

        receptionService.createAnAppointment(secondPatient, secondDoctor);
        receptionService.createAnAppointment(firstPatient, secondDoctor);

        doctorService.observePatient(secondDoctor);
        doctorService.observePatient(secondDoctor);

        doctorService.observePatient(firdDoctor);

        /*
            Expect:

            Patient: She Ill appointed to doctor: Pasha Volya DENTIST
            Observe patient: She Ill
            Patient: He Will appointed to doctor: Misha Huev SURGEON
            Patient: I Ill appointed to doctor: Misha Huev SURGEON
            Observe patient: He Will
            Observe patient: I Ill
            Queue is empty. I go to sleep...

         */
    }

}
