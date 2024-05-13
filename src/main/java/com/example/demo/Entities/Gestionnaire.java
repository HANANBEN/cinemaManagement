package com.example.demo.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Gestionnaire {
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idgestionnaire;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    private Boolean isaffected;
    @OneToOne
    private Login emailgestionnaire;
    @ManyToOne
    private SuperAdmin superadmin;
}
