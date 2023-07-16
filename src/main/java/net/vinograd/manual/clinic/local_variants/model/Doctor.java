package net.vinograd.manual.clinic.local_variants.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Doctor {

    private int id;

    private String firstName;

    private String lastName;

    private Specialty specialty;


    public enum Specialty {
        DENTIST, TRAUMATOLOGIST, SURGEON
    }

}
