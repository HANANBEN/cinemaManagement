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
public class Cinema {
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idcinema;
    private String nom;
    private Integer nbrsalle;
    private Double longitude , latitude,altitude ;

    private Boolean isaffected;
    @ManyToOne
    private Ville ville;
    @ManyToOne
    private SuperAdmin superadmin;

    @OneToOne
    private Gestionnaire Gestionnaire;
}