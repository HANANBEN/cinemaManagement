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
public class Gestionnaire {
    @Id  @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idgestionnaire;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    @OneToOne
    private Login emailgestionnaire;
    @ManyToOne
    private SuperAdmin superadmin;
}
