package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Film {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idfilm;

    private String titre;


    @Column(columnDefinition = "TIME")
    private Duration duree;

    private String realisateur;

    private String description;


    private String photo;

    private Date datesortie;


    /*categorie */
    @ManyToOne
    private  Categorie categorie;


    @OneToMany(mappedBy = "film")
    private List<Projectionfilm> projectionfilms;
    @OneToMany(mappedBy = "film")
    private List<Avis> Avis;





}
