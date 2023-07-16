package net.vinograd.manual;

import net.vinograd.manual.clinic.local_variants.local_spring.BeanConfig;
import net.vinograd.manual.clinic.local_variants.repository.AppointmentRepository;
import net.vinograd.manual.clinic.local_variants.repository.DoctorRepository;
import net.vinograd.manual.clinic.local_variants.repository.PatientRepository;
import net.vinograd.manual.clinic.local_variants.service.DoctorService;
import net.vinograd.manual.clinic.local_variants.service.ReceptionService;
import net.vinograd.manual.clinic.local_variants.model.Doctor;
import net.vinograd.manual.clinic.local_variants.model.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringLearningApplication {

    private final DoctorRepository doctorRepository;

    private final PatientRepository patientRepository;

    AppointmentRepository appointmentRepository;

    DoctorService doctorService;

    ReceptionService receptionService;

    //@Autowired
    //DatabaseDoctorRepository doctorRepositoryHiber;
    //
    //@Autowired
    //DatabasePatientRepository patientRepositoryHiber;

    public static void main(String[] args) {
        SpringApplication.run(SpringLearningApplication.class, args);

    }

    public SpringLearningApplication() {

        // ----------------------------InitializeRepositories-----------------------
        //                                (Getting beans)

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);

        doctorRepository = context.getBean(DoctorRepository.class);
        patientRepository = context.getBean(PatientRepository.class);

        appointmentRepository = context.getBean(AppointmentRepository.class);
        doctorService = context.getBean(DoctorService.class);
        receptionService = context.getBean(ReceptionService.class);

        prepare();
        simulate();
    }

    private void prepare() {

        Doctor firstDoctor = new Doctor(0, "Pasha", "Volya", Doctor.Specialty.DENTIST);
        Doctor secondDoctor = new Doctor(1, "Misha", "Huev", Doctor.Specialty.SURGEON);
        Doctor firdDoctor = new Doctor(2, "Arnold", "Schwarzenegger", Doctor.Specialty.TRAUMATOLOGIST);

        Patient firstPatient = new Patient(0, "Im", "Ill");
        Patient secondPatient = new Patient(1, "Bill", "Will");
        Patient firdPatient = new Patient(2, "Sarah", "Ill");


        doctorRepository.save(firstDoctor);
        doctorRepository.save(secondDoctor);
        doctorRepository.save(firdDoctor);

        patientRepository.save(firstPatient);
        patientRepository.save(secondPatient);
        patientRepository.save(firdPatient);

    }


    private void simulate() {

        // -----------------------------------Getting Doctors and Patients------------------

        Doctor firstDoctor = doctorRepository.findById(0).orElseThrow();
        Doctor secondDoctor = doctorRepository.findById(1).orElseThrow();
        Doctor firdDoctor = doctorRepository.findById(2).orElseThrow();

        Patient firstPatient = patientRepository.findByName("Im").stream().findFirst().orElseThrow();
        Patient secondPatient = patientRepository.findByName("Will").stream().findFirst().orElseThrow();
        Patient firdPatient = patientRepository.findByName("Ill").stream().filter(patient -> patient.getFirstName().equals("Sarah")).findFirst().orElseThrow();

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

            Patient: Sarah Ill appointed to doctor: Pasha Volya DENTIST
            Observe patient: Sarah Ill
            Patient: Bill Will appointed to doctor: Misha Huev SURGEON
            Patient: Im Ill appointed to doctor: Misha Huev SURGEON
            Observe patient: Bill Will
            Observe patient: Im Ill
            Queue is empty. I go to sleep...

         */
    }

}
