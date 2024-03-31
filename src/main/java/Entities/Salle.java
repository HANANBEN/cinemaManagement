package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Salle {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idsalle;



    private String nom;

    private int nbrplace;

    private boolean isconfig;

    private boolean isdispo;

    @ManyToOne
    private Cinema Cinema;

    @ManyToOne
    private Gestionnaire Gestionnaire;


}
