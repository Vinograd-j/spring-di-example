package net.vinograd.manual.clinic.database_variants.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDateTime time;

    protected Appointment() {}

    public Appointment(Patient patient, Doctor doctor, LocalDateTime time) {
        this.patient = patient;
        this.doctor = doctor;
        this.time = time;
    }
}
