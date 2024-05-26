package com.example.demo.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
public class Film {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idfilm;

    private String titre;


     @Column(columnDefinition = "TIME")
    private LocalTime duree;
 
    private String realisateur;

    private String description;


    private String photo;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date datesortie;


    /*categorie */
    @ManyToOne
    private  Categorie categorie;


    @OneToMany(mappedBy = "film")
    private List<Projectionfilm> projectionfilms;
    @OneToMany(mappedBy = "film")
    private List<Avis> Avis;
 
    
	public Film(int idfilm, String titre, LocalTime duree, String realisateur, String description, String photo,
			Date datesortie, Categorie categorie, List<Projectionfilm> projectionfilms,
			List<Avis> avis) {
		super();
		this.idfilm = idfilm;
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
		this.photo = photo;
		this.datesortie = datesortie;
		this.categorie = categorie;
		this.projectionfilms = projectionfilms;
		Avis = avis;
	}
	public Film() {
		super();
	}
	public int getIdfilm() {
		return idfilm;
	}
	public void setIdfilm(int idfilm) {
		this.idfilm = idfilm;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public LocalTime getDuree() {
		return duree;
	}
	public void setDuree(LocalTime duree) {
		this.duree = duree;
	}
	public String getRealisateur() {
		return realisateur;
	}
	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Date getDatesortie() {
		return datesortie;
	}
	public void setDatesortie(Date datesortie) {
		this.datesortie = datesortie;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Projectionfilm> getProjectionfilms() {
		return projectionfilms;
	}
	public void setProjectionfilms(List<Projectionfilm> projectionfilms) {
		this.projectionfilms = projectionfilms;
	}
	public List<Avis> getAvis() {
		return Avis;
	}
	public void setAvis(List<Avis> avis) {
		Avis = avis;
	}
	public Film(String titre, LocalTime duree, String realisateur, String description, String photo, Date datesortie,
			Categorie categorie) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
		this.photo = photo;
		this.datesortie = datesortie;
		this.categorie = categorie;
	}
	public Film(int idfilm, String titre, LocalTime duree, String realisateur, String description, String photo,
			Date datesortie, Categorie categorie) {
		super();
		this.idfilm = idfilm;
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
		this.photo = photo;
		this.datesortie = datesortie;
		this.categorie = categorie;
	}
	public Film(String titre, LocalTime duree, String realisateur, String description, Date datesortie) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
		this.datesortie = datesortie;
	}
	public Film(String titre, LocalTime duree, String realisateur, String description) {
		super();
		this.titre = titre;
		this.duree = duree;
		this.realisateur = realisateur;
		this.description = description;
	}
	public Film(String titre, String realisateur, String description) {
		super();
		this.titre = titre;
		this.realisateur = realisateur;
		this.description = description;
	}
	





}