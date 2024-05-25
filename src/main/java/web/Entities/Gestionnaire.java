package web.Entities;

import java.util.List;

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
    public Gestionnaire(Integer idgestionnaire) {
		super();
		this.idgestionnaire = idgestionnaire;
	}

	private String nom;
    private String prenom;
    private String email;
    private String tele;
    private Boolean isaffected;
  
    @OneToOne
    private Login emailgestionnaire;
    
	@ManyToOne
    private SuperAdmin superadmin;

	public Gestionnaire() {
		super();
	}

	public Integer getIdgestionnaire() {
		return idgestionnaire;
	}

	public void setIdgestionnaire(Integer idgestionnaire) {
		this.idgestionnaire = idgestionnaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTele() {
		return tele;
	}

	public void setTele(String tele) {
		this.tele = tele;
	}

	public Boolean getIsaffected() {
		return isaffected;
	}

	public void setIsaffected(Boolean isaffected) {
		this.isaffected = isaffected;
	}

	public Login getEmailgestionnaire() {
		return emailgestionnaire;
	}

	public void setEmailgestionnaire(Login emailgestionnaire) {
		this.emailgestionnaire = emailgestionnaire;
	}

	public SuperAdmin getSuperadmin() {
		return superadmin;
	}

	public Gestionnaire( String nom, String prenom, String email, String tele,
			Boolean isaffected) {
		super();
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		this.isaffected = isaffected;
	}

	public void setSuperadmin(SuperAdmin superadmin) {
		this.superadmin = superadmin;
	}

	public Gestionnaire(Boolean isaffected) {
		super();
		this.isaffected = isaffected;
	}
	
	
	
}
