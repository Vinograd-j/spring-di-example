package net.vinograd.manual.clinic.local.repositories;

import net.vinograd.manual.clinic.repository.AppointmentRepository;
import net.vinograd.manual.model.Doctor;
import net.vinograd.manual.model.Patient;

import java.util.*;

public class LocalAppointmentRepository implements AppointmentRepository {

    private final HashMap<Doctor, Queue<Patient>> appointments;

    public LocalAppointmentRepository() {
        appointments = new HashMap<>();
    }

    @Override
    public void appoint(Patient patient, Doctor doctor) {

        if(!appointments.containsKey(doctor)){

            Queue<Patient> patientQueue = new LinkedList<>();

            patientQueue.add(patient);

            appointments.put(doctor, patientQueue);

            return;
        }

        appointments.get(doctor).add(patient);
    }

    @Override
    public Optional<Patient> take(Doctor doctor) {

        if(!appointments.containsKey(doctor))
            return Optional.empty();

        var queue = appointments.get(doctor);

        if (queue.isEmpty())
            return Optional.empty();

        return Optional.ofNullable(queue.poll());
    }
}
