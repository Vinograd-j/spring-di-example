package net.vinograd.manual.clinic.database_variants.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Getter
    @Column(name = "first_name")
    private String firstName;

    @Getter
    @Column(name = "last_name")
    private String lastName;

}
