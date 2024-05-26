package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



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
    @OneToMany(mappedBy = "superadmin")
    private List<Cinema> Cinemas ;
	public SuperAdmin(Integer idadmin, String nom, String prenom, String email, String tele, Login emailadmin,
			List<Gestionnaire> gestionnaires, List<Cinema> cinemas) {
		super();
		this.idadmin = idadmin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
		this.emailadmin = emailadmin;
		this.gestionnaires = gestionnaires;
		Cinemas = cinemas;
	}
	public Integer getIdadmin() {
		return idadmin;
	}
	public void setIdadmin(Integer idadmin) {
		this.idadmin = idadmin;
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
	public Login getEmailadmin() {
		return emailadmin;
	}
	public void setEmailadmin(Login emailadmin) {
		this.emailadmin = emailadmin;
	}
	public List<Gestionnaire> getGestionnaires() {
		return gestionnaires;
	}
	public void setGestionnaires(List<Gestionnaire> gestionnaires) {
		this.gestionnaires = gestionnaires;
	}
	public List<Cinema> getCinemas() {
		return Cinemas;
	}
	public void setCinemas(List<Cinema> cinemas) {
		Cinemas = cinemas;
	}
	public SuperAdmin(Integer idadmin, String nom, String prenom, String email, String tele) {
		super();
		this.idadmin = idadmin;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tele = tele;
	}
	public SuperAdmin() {
		super();
	}

   




}
