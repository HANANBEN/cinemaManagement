package web.Entities;

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
    public SuperAdmin(Integer idadmin, String nom, String prenom, String email, String tele) {
		super();
		this.idadmin = idadmin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		
	}
	@OneToOne
    private Login emailadmin;
    @OneToMany(mappedBy = "superadmin")
    private List<Gestionnaire> gestionnaires;
    @OneToMany(mappedBy = "superadmin")
    private List<Cinema> Cinemas ;






}
