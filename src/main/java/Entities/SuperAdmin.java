package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SuperAdmin {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idadmin;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    @OneToOne
    private Login emailadmin;
    @OneToMany(mappedBy = "superadmin")
    private List<Gestionnaire> gestionnaires;






}
