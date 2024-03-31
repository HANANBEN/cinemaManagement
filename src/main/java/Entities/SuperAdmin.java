package Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class SuperAdmin {
    @Id
    private Integer idadmin;
    private String nom;
    private String prenom;
    private String email;
    private String tele;
    @OneToOne
    private Login emailadmin;






}
