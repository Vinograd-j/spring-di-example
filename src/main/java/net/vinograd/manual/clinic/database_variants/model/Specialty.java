package net.vinograd.manual.clinic.database_variants.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Specialty {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Getter
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private SpecialtyType type;

    public enum SpecialtyType{

        DENTIST, TRAUMATOLOGIST, SURGEON

    }

}


