package com.example.demo.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.example.demo.entities.*;

@Entity
public class Boulvard {
    @Id
    private String nom;
    private String longitude;

    private String latitude;

    private String altitude;
    @ManyToOne
    private Ville ville;

    
    
}
